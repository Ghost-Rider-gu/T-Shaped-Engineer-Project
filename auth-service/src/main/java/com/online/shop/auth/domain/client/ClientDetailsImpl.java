/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.auth.domain.client;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ClientDetailsImpl implements ClientDetails {
    private final String clientId;
    private final String clientSecret;
    private final Set<String> scope;
    private final Set<String> authorizedGrantTypes;
    private final Collection<GrantedAuthority> authorities;
    private final Integer accessTokenValiditySeconds;
    private final Integer refreshTokenValiditySeconds;

    public ClientDetailsImpl(Client client) {
        this.clientId = client.getClientId();
        this.clientSecret = client.getClientSecret();

        String[] scopes = client.getScope().split(",");
        this.scope = new HashSet<>(Arrays.asList(scopes));

        String[] grantTypes = client.getAuthorizedGrantTypes().split(",");
        this.authorizedGrantTypes = new HashSet<>(Arrays.asList(grantTypes));

        String[] authorities = client.getAuthorities().split(",");
        Collection<GrantedAuthority> grandAuthorities = Collections.EMPTY_LIST;
        for (String authority: authorities) {
            grandAuthorities.add(new SimpleGrantedAuthority(authority));
        }
        this.authorities = grandAuthorities;

        this.accessTokenValiditySeconds = client.getAccessTokenValidity();
        this.refreshTokenValiditySeconds = client.getRefreshTokenValidity();
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        return scope;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return true;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
