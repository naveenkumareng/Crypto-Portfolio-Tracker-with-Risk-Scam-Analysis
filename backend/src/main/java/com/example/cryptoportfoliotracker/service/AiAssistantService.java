package com.example.cryptoportfoliotracker.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AiAssistantService {

    private static final List<String> FORBIDDEN_KEYWORDS = Arrays.asList("buy", "sell", "hold", "invest", "price prediction", "target price");

    public String generateResponse(String userMessage, boolean isDemoMode) {
        // 1. Check for forbidden financial advice keywords
        if (isFinancialAdvice(userMessage)) {
            return "I cannot provide financial advice, including recommendations to buy, sell, or hold assets. My purpose is to provide informational analysis. You could ask me to explain a crypto concept or analyze the risk of your current (demo) portfolio instead.";
        }

        // 2. Gather context based on mode
        String context;
        if (isDemoMode) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String email = auth.getName();
            int holdingsCount = 5; // Mock
            double totalPnL = 1234.56; // Mock
            context = "User: " + email + ", Holdings: " + holdingsCount + ", P&L: $" + String.format("%.2f", totalPnL) + " (DEMO DATA)";
        } else {
            // Real user flow - no demo data leakage
            context = "User is not in demo mode. Portfolio data is not available to the AI.";
        }

        // 3. Call placeholder AI with context
        String aiResponse = callPlaceholderAI(userMessage, context);

        // 4. Prepend demo mode label if applicable
        if (isDemoMode) {
            return "[Demo Mode] " + aiResponse;
        }

        return aiResponse;
    }

    private boolean isFinancialAdvice(String message) {
        String lowerCaseMessage = message.toLowerCase();
        return FORBIDDEN_KEYWORDS.stream().anyMatch(lowerCaseMessage::contains);
    }

    private String callPlaceholderAI(String input, String context) {
        // In a real implementation, this would call an external AI API (e.g., OpenAI, Gemini)
        // The context is passed along with the user's message.
        return "AI response to: '" + input + "' with context: [" + context + "]";
    }
}
