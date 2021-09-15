/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.processing.config;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.online.shop.processing.domain.Game;
import com.online.shop.processing.listener.JobListener;
import com.online.shop.processing.processor.ProductItemProcessor;
import org.apache.commons.io.FileUtils;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final AmazonS3 amazonClient;

    @Autowired
    public BatchConfig(JobBuilderFactory jobBuilderFactory,
                       StepBuilderFactory stepBuilderFactory,
                       AmazonS3 amazonClient) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.amazonClient = amazonClient;
    }

    // TODO: get bucketName and csv file from properties file (rewrite it)
    private String getCsvFromS3() throws Exception {
        S3Object s3Object = amazonClient.getObject("shop-online", "catalog_of_product.csv");
        try(S3ObjectInputStream inputStream = s3Object.getObjectContent()) {
            FileUtils.copyInputStreamToFile(inputStream, new File("catalog_of_product.csv"));
            return "catalog_of_product.csv";
        } catch (IOException ex) {
           throw new Exception();
        }
    }

    @Bean
    public FlatFileItemReader<Game> reader() throws Exception {
        return new FlatFileItemReaderBuilder<Game>()
                .name("GameItemReader")
                .resource(new ClassPathResource(getCsvFromS3()))
                .delimited()
                .names(new String[] {
                        "name", "posterLink", "description",
                        "releaseDate", "price", "quantity", "genre"
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Game>() {{
                    setTargetType(Game.class);
                }})
                .build();
    }

    @Bean
    public ProductItemProcessor processor() {
        return new ProductItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Game> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Game>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO game (description, name, poster_link, price, quantity, release_date)" +
                     " VALUES (:description, :name, :posterLink, :price, :quantity, :releaseDate)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importGameItemsJob(JobListener listener, Step step1) {
        return jobBuilderFactory.get("importGameItemsJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Game> writer) throws Exception {
        return stepBuilderFactory.get("initStep")
                .<Game, Game> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }
}
