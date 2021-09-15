/*
 * Copyright (c) 2021 Smart-shop
 * All rights reserved
 */

package com.online.shop.auth.service;

import com.online.shop.auth.domain.client.ClientDetailsImpl;
import com.online.shop.auth.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {
    private static final Logger log = LoggerFactory.getLogger(ClientDetailsServiceImpl.class);

    private final ClientRepository clientRepository;

    public ClientDetailsServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return clientRepository.findByClientId(clientId)
                .map(ClientDetailsImpl::new)
                .orElseThrow(() -> new ClientRegistrationException(String.format("Client not found: %s", clientId)));
    }
}
