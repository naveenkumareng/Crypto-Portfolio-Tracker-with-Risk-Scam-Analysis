package com.CryptoProject.CryptoInfosys.service;

public class AiPromptBuilder {

    public static String build(String portfolioContext, String userQuestion) {
        return """
                You are a professional crypto portfolio analyst.

                RULES:
                - DO NOT give financial advice
                - DO NOT recommend specific buy/sell prices
                - Explain risks clearly
                - Be concise but insightful
                - Use bullet points when helpful

                USER PORTFOLIO:
                %s

                USER QUESTION:
                %s

                RESPONSE FORMAT:
                - Summary
                - Risk Analysis
                - Suggestions
                """.formatted(portfolioContext, userQuestion);
    }
}
