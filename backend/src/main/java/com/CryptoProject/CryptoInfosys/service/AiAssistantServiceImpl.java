package com.CryptoProject.CryptoInfosys.service;

import com.CryptoProject.CryptoInfosys.dto.GeminiRequest;
import com.CryptoProject.CryptoInfosys.dto.GeminiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
@Service
public class AiAssistantServiceImpl implements AiAssistantService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AiAssistantServiceImpl.class);

    private final WebClient webClient;

    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${gemini.api.url}")
    private String apiUrl;

    public AiAssistantServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public String getResponse(String prompt, String username) {

        GeminiRequest request = new GeminiRequest(
                List.of(
                        new GeminiRequest.Content(
                                List.of(new GeminiRequest.Part(prompt))
                        )
                ),
                "gemini-pro"
        );

        try {
            GeminiResponse response = webClient.post()
                    .uri(apiUrl + ":generateContent?key=" + apiKey)
                    .bodyValue(request)
                    .retrieve()
                    .bodyToMono(GeminiResponse.class)
                    .block();

            if (response == null ||
                response.candidates() == null ||
                response.candidates().isEmpty()) {
                return "Sorry, I couldn't generate a response.";
            }

            return response
                    .candidates()
                    .get(0)
                    .content()
                    .parts()
                    .get(0)
                    .text();

        } catch (Exception e) {
            LOGGER.error("AI service call failed", e);
            // NEVER crash dashboard because AI failed
            return "AI service is temporarily unavailable. Please try again later.";
        }
    }
}
