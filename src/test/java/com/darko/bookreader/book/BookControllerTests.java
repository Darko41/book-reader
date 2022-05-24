package com.darko.bookreader.book;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BookControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testFormLogin() throws Exception {
		mockMvc.perform(formLogin("/login").user("janko").password("janko123"))
		.andDo(print())
		.andExpect(authenticated());
	}
	
	public static RequestPostProcessor janko() {
		return user("janko").password("janko123").roles("ADMIN");
	}
	
	@Test
	public void unAuthenticatedUser() throws Exception {
		mockMvc.perform(formLogin().password("invalid"))
		.andDo(print())
		.andExpect(unauthenticated());
	}
		

}
