package com.codegym.md4_airbnb.service.impl;

import com.codegym.md4_airbnb.model.VerificationToken;
import com.codegym.md4_airbnb.repository.VerificationTokenRepository;
import com.codegym.md4_airbnb.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;

public class VerificationTokenServiceImpl implements VerificationTokenService {
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    @Override
    public VerificationToken findByToken(String token) {
        return verificationTokenRepository.findByToken(token);
    }

    @Override
    public void save(VerificationToken token) {
        verificationTokenRepository.save(token);

    }
}
