package com.CryptoProject.CryptoInfosys.controller;

import com.CryptoProject.CryptoInfosys.model.ExchangeAccount;
import com.CryptoProject.CryptoInfosys.dto.AddExchangeAccountRequest;
import com.CryptoProject.CryptoInfosys.service.ExchangeAccountService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exchange-accounts")
@CrossOrigin(origins = "http://localhost:3000")
public class ExchangeAccountController {

    private final ExchangeAccountService exchangeAccountService;

    // ✅ Constructor injection
    public ExchangeAccountController(ExchangeAccountService exchangeAccountService) {
        this.exchangeAccountService = exchangeAccountService;
    }

    /* ================= GET USER EXCHANGE ACCOUNTS ================= */
    @GetMapping
    public List<ExchangeAccount> getUserExchangeAccounts(
            Authentication authentication
    ) {
        String email = authentication.getName();
        return exchangeAccountService.getUserExchanges(email);
    }

    /* ================= ADD EXCHANGE ACCOUNT ================= */
    @PostMapping
    public ExchangeAccount addExchangeAccount(
            @RequestBody AddExchangeAccountRequest request,
            Authentication authentication
    ) {
        String email = authentication.getName();

        return exchangeAccountService.addExchange(
                email,
                request.getExchange(),
                request.getApiKey(),
                request.getApiSecret()
        );
    }
}
