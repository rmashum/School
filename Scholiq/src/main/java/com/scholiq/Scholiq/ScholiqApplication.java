package com.scholiq.Scholiq;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@RestController
@SpringBootApplication
public class ScholiqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScholiqApplication.class, args);
	}

	@GetMapping("/")
	public String value() {
		return "Welcome to the ScholIQ School Management System";
	}
/*
	@Autowired
	private UserService userService;
	@Autowired
	private UserServiceImpl userServiceimpl;*/

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@GetMapping("/generate-offer")
	public ResponseEntity<?> generateOffer() {
		// Generate offer and return it
		// Example: Offer offer = ...;
		// return ResponseEntity.ok().body(offer);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/send-answer")
	public ResponseEntity<?> sendAnswer(@RequestBody Object answer) {
		// Process received answer
		return ResponseEntity.ok().build();
	}

/*
	@PostMapping("/login")
	public BusinessResponse login(@RequestBody User user) {
		BusinessResponse businessResponse = new BusinessResponse();
		User userResponse = userServiceimpl.authenticate(user.getMobileNumber(), user.getTempPassword());
		if (userResponse.getId() != null && userResponse.getId() > 0) {
			businessResponse.setCode(200);
			businessResponse.setStatus("SUCCESS");
			businessResponse.setResponse(userResponse);
		} else {
			businessResponse.setCode(500);
			businessResponse.setStatus("FAILURE");
			businessResponse.setResponse("Invalid Credential");
		}
		return businessResponse;
	}


	@PostMapping("/user/temp")
	public User saveTempUser(@RequestBody User user) {
		Random random = new Random();
		if (StringUtils.isNotBlank(user.getFirstName())) {
			int randomNumber = random.nextInt(90000) + 10000;
			user.setPrimary_user_id(user.getFirstName().trim() + randomNumber);
		} else if (StringUtils.isNotBlank(user.getMobileNumber())) {
			int randomNumber = random.nextInt(900) + 100;
			user.setPrimary_user_id(user.getMobileNumber().trim() + randomNumber);
		} else if (StringUtils.isNotBlank(user.getEmail())) {
			int randomNumber = random.nextInt(900) + 100;
			user.setPrimary_user_id(user.getEmail().trim() + randomNumber);
		} else {
			int randomData = random.nextInt(90000000) + 10000000;
			user.setPrimary_user_id(String.valueOf(randomData));
		}
		user.setFirstTimeLogin("Y");
		User userResponse = userService.save(user);
		return userResponse;
	}
*/

	@Bean(name = "corsFilter")
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		// config.addAllowedOrigin("*");
		config.addAllowedMethod("*");
		config.addAllowedOriginPattern("*");
		config.addAllowedHeader("*");
		config.setAllowCredentials(true);
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}


}
