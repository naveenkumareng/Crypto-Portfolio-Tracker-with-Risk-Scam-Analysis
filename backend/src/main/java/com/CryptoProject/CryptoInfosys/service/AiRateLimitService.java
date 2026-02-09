package com.CryptoProject.CryptoInfosys.service;

import org.springframework.stereotype.Service;

@Service
public interface AiRateLimitService {
    void validateRequest(String username);
}
