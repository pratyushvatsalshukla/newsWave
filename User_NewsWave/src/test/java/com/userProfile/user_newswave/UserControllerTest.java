package com.userProfile.user_newswave;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.userProfile.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.userProfile.controller.UserController;
import com.userProfile.entity.User;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@InjectMocks
	private UserController userController;

	@Mock
	private UserService userService;

	@Test
	public void testUserRegistration() {
		// Arrange
		User user = new User(); // create a User object with required fields
		when(userService.registerUser(any(User.class))).thenReturn(user);

		// Act
		ResponseEntity<User> responseEntity = userController.userRegistration(user);

		// Assert
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(user, responseEntity.getBody());
	}
}
