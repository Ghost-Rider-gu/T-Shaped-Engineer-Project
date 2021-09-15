/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.processing.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class JobListener extends JobExecutionListenerSupport {
    private static final Logger log = LoggerFactory.getLogger(JobListener.class);

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("Batch Job is FINISHED! All new products were uploaded!");
        }
    }
}
