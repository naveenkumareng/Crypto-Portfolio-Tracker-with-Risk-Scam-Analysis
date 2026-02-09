package com.example.cryptoportfoliotracker.controller;

import com.example.cryptoportfoliotracker.service.AiAssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

record AiRequest(String message, boolean isDemoMode) {}

@RestController
@RequestMapping("/api/ai")
public class AiAssistantController {

    @Autowired
    private AiAssistantService aiAssistantService;

    @PostMapping("/chat")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<String> getAiResponse(@RequestBody AiRequest request) {
        String response = aiAssistantService.generateResponse(request.message(), request.isDemoMode());
        return ResponseEntity.ok(response);
    }
}
