package com.CryptoProject.CryptoInfosys.service;

import org.springframework.stereotype.Service;

@Service
public interface AiAssistantService {
    String getResponse(String prompt, String username);
}
