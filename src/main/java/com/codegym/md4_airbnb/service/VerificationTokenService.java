package com.codegym.md4_airbnb.service;

import com.codegym.md4_airbnb.model.VerificationToken;

public interface VerificationTokenService {
    VerificationToken findByToken(String token);

    void  save(VerificationToken token);
}
