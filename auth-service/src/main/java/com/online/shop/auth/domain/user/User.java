/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.auth.domain.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "\"user\"")
public class User implements Serializable {
    private static final long serialVersionUID = 236067348552556419L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotNull(message = "Username cannot be empty")
    @Size(min = 2, message = "Login cannot be less than 2 letters")
    @Column(name = "username", nullable = false)
    private String username;

    @NotNull(message = "Password cannot be empty")
    @Size(min = 6, message = "Password must have at least 6 characters")
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull(message = "Authority cannot be empty")
    @Column(name = "authority", nullable = false)
    @ApiModelProperty(notes = "The authority could be Super Admin or Customer")
    private String authority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;

        return id != null && id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return 562048007;
    }
}
