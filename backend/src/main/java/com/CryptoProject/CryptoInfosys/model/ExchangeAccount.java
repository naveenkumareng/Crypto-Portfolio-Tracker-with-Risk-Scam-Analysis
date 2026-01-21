package com.CryptoProject.CryptoInfosys.model;

import jakarta.persistence.*;

import com.CryptoProject.CryptoInfosys.model.User;

@Entity
public class ExchangeAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;

    private String exchange;
    private String apiKey;
    private String apiSecret;

    public void setUser(User user) { this.user = user; }
    public void setExchange(String exchange) { this.exchange = exchange; }
    public void setApiKey(String apiKey) { this.apiKey = apiKey; }
    public void setApiSecret(String apiSecret) { this.apiSecret = apiSecret; }
}
