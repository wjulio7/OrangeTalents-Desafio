package com.example.vacinaja;

import com.example.vacinaja.repository.UserRepository;
import com.example.vacinaja.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class VacinaJaApplicationTests {

	@Autowired
	private UserService userservice;

	@MockBean
	private UserRepository userrepository;

	@Test
	void contextLoads() {

	}

	long id = 1L;
	LocalDate date = LocalDate.parse("2020-01-08");
/*
	@Test
	public void saeveUserTest(){
		User user = new User(id , "Pranya", "a@hotmail.com" , "77103210039", date);
		when(userrepository.save(user)).thenReturn(user);
		Assertions.assertEquals(user, userservice.save(user));
	}
*/
}
