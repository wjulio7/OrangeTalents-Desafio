package com.example.vacinaja;

import com.example.vacinaja.model.User;
import com.example.vacinaja.repository.userRepository;
import com.example.vacinaja.service.userService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class VacinaJaApplicationTests {

	@Autowired
	private userService userservice;

	@MockBean
	private userRepository userrepository;

	@Test
	void contextLoads() {

	}

	long i = 1L;
	LocalDate date = LocalDate.parse("2020-01-08");
	@Test
	public void saeveUserTest(){
		User user = new User(i , "Pranya", "a@hotmail.com" , "00000000000", date);
		when(userrepository.save(user)).thenReturn(user);
		Assertions.assertEquals(user, userservice.save(user));


	}
}
