package com.CryptoProject.CryptoInfosys.service;

import com.CryptoProject.CryptoInfosys.model.ExchangeAccount;
import com.CryptoProject.CryptoInfosys.model.User;
import com.CryptoProject.CryptoInfosys.repository.ExchangeAccountRepository;
import com.CryptoProject.CryptoInfosys.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeAccountService {

    private final ExchangeAccountRepository exchangeAccountRepo;
    private final UserRepository userRepo;

    // ✅ CONSTRUCTOR INJECTION (MANDATORY)
    public ExchangeAccountService(
            ExchangeAccountRepository exchangeAccountRepo,
            UserRepository userRepo
    ) {
        this.exchangeAccountRepo = exchangeAccountRepo;
        this.userRepo = userRepo;
    }

    public List<ExchangeAccount> getUserExchanges(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return exchangeAccountRepo.findByUser(user);
    }

    public ExchangeAccount addExchange(
            String email,
            String exchange,
            String apiKey,
            String apiSecret
    ) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ExchangeAccount acc = new ExchangeAccount();
        acc.setUser(user);
        acc.setExchange(exchange);
        acc.setApiKey(apiKey);
        acc.setApiSecret(apiSecret);

        return exchangeAccountRepo.save(acc);
    }
}
