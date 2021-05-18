package com.example.vacinaja.service.serviceImpl;

import com.example.vacinaja.exception.CustomException;
import com.example.vacinaja.model.NotificationEmail;
import com.example.vacinaja.model.User;
import com.example.vacinaja.model.VerificationToken;
import com.example.vacinaja.repository.UserRepository;
import com.example.vacinaja.repository.VerificationTokenRepository;
import com.example.vacinaja.security.JwtTokenProvider;
import com.example.vacinaja.service.MailService;
import com.example.vacinaja.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MailService mailService;
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Override
    public String signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, userrepository.findByUsername(username).getRoles());
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Autowired
    UserRepository userrepository;
    private static Pattern PATTERN_GENERIC = Pattern.compile("[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}");
    private static Pattern PATTERN_NUMBERS = Pattern.compile("(?=^((?!((([0]{11})|([1]{11})|([2]{11})|([3]{11})|([4]{11})|([5]{11})|([6]{11})|([7]{11})|([8]{11})|([9]{11})))).)*$)([0-9]{11})");
    //CPF VALIDATOR
    public static boolean isValid(String cpf) {
        if (cpf != null && PATTERN_GENERIC.matcher(cpf).matches()) {
            cpf = cpf.replaceAll("-|\\.", "");
            if (cpf != null && PATTERN_NUMBERS.matcher(cpf).matches()) {
                int[] numbers = new int[11];
                for (int i = 0; i < 11; i++) numbers[i] = Character.getNumericValue(cpf.charAt(i));
                int i;
                int sum = 0;
                int factor = 100;
                for (i = 0; i < 9; i++) {
                    sum += numbers[i] * factor;
                    factor -= 10;
                }
                int leftover = sum % 11;
                leftover = leftover == 10 ? 0 : leftover;
                if (leftover == numbers[9]) {
                    sum = 0;
                    factor = 110;
                    for (i = 0; i < 10; i++) {
                        sum += numbers[i] * factor;
                        factor -= 10;
                    }
                    leftover = sum % 11;
                    leftover = leftover == 10 ? 0 : leftover;
                    return leftover == numbers[10];
                }
            }
        }
        return false;
    }
    //EMAIL VALIDATOR
    public static final String EMAIL_VERIFICATION = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
    Pattern pattern = Pattern.compile(EMAIL_VERIFICATION);

    @Override
    public String save(User user) {
        if (user.getEmail().trim().isEmpty() ){
            throw new RuntimeException("erro");
        }
        if(!pattern.matcher(user.getEmail()).matches()){
            throw new RuntimeException("EMAIL INVALID");
        }
        if(!isValid(user.getCpf())){
            throw new RuntimeException("CPF INVALID");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(false);
        userrepository.save(user);

        String token = generateVerificationToken(user);
        mailService.sendMail(new NotificationEmail("Please Activate your Account",
                user.getEmail(), "Thank you for signing up to Spring Reddit, " +
                "please click on the below url to activate your account : " +
                "http://localhost:8080/api/auth/accountVerification/" + token));
        return "Sucessfull";
    }




    private String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationTokenRepository.save(verificationToken);
        return token;
    }

   @Override
    public User findById(Long id) {
        Optional<User> user2 = userrepository.findById(id);
       return user2.get();
    }

    @Override
    public User findByUsername(String username){
        return userrepository.findByUsername(username);
    }

    @Override
    public String delete(String username) {
        User user = findByUsername(username);
        verificationTokenRepository.deleteByUserId(user.getId());
        return userrepository.deleteByUsername(username);

    }
}