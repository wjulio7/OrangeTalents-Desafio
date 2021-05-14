package com.example.vacinaja.service.serviceImpl;

import com.example.vacinaja.model.User;
import com.example.vacinaja.repository.UserRepository;
import com.example.vacinaja.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

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
    public User save(User user) {
        if (user.getEmail().trim().isEmpty() ){
            throw new RuntimeException("erro");
        }
        if(!pattern.matcher(user.getEmail()).matches()){
            throw new RuntimeException("EMAIL INVALID");
        }
        if(!isValid(user.getCpf())){
            throw new RuntimeException("CPF INVALID");
        }
        return userrepository.save(user);
    }

   @Override
    public User findById(Long id) {

        Optional<User> user2 = userrepository.findById(id);
        User user = user2.get();
        return user;
    }

    @Override
    public User findByUsername(String username){
        return userrepository.findByUsername(username);
    }
}