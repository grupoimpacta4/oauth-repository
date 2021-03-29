package com.impacta.oauth.jwt.controller;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.impacta.oauth.model.UserDao;
import com.impacta.oauth.model.UserDto;
import com.impacta.oauth.repository.UserRepository;
import com.impacta.oauth.service.OathServerDetailsService;

import java.util.List;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class TokenController {

	private OathServerDetailsService userDetailsService;

	private UserRepository userRepository;

	@PreAuthorize("#oauth2.hasScope('write')")
	@RequestMapping(value = "api/user/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String saveUser(@Valid @RequestBody UserDto user) throws Exception {
		try {

			userDetailsService = new OathServerDetailsService(userRepository);
			List<UserDao> listaUser = userDetailsService.searchingByUserName(user);
			if (listaUser.size() == 0) {
				userDetailsService.saveUser(user);
				userDetailsService.saveAuthority(user.getUsername(), "ROLE_USER");
			} 
			return "User was created";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erro 1 " + e.getMessage());
			return "User was not created";
		}
	}

}
