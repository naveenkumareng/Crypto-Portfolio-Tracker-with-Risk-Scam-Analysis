package com.CryptoProject.CryptoInfosys.dto;

import java.util.List;

public record GeminiRequest(List<Content> contents, String model) {

    public record Content(List<Part> parts) {}

    public record Part(String text) {}
}
