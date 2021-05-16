package com.example.vacinaja.service;

import com.example.vacinaja.model.User;
import com.example.vacinaja.model.VerificationToken;
import com.example.vacinaja.repository.UserRepository;
import com.example.vacinaja.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class AuthService {

    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;

    public void verifyAccount(String token) {
        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
        fetchUserAndEnable(verificationToken.orElseThrow(() -> new RuntimeException("Invalid Token")));
    }

    private void fetchUserAndEnable(VerificationToken verificationToken) {
        String username = verificationToken.getUser().getUsername();
        User user = userRepository.findByUsername(username);
        user.setEnabled(true);
        userRepository.save(user);
    }
}
