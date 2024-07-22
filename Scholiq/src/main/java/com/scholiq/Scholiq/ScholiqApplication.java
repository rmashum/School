package com.scholiq.Scholiq;

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

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@GetMapping("/generate-offer")
	public ResponseEntity<?> generateOffer() {
		return ResponseEntity.ok().build();
	}

	@PostMapping("/send-answer")
	public ResponseEntity<?> sendAnswer(@RequestBody Object answer) {
		return ResponseEntity.ok().build();
	}

	@Bean(name = "corsFilter")
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOriginPattern("*"); // Allow all origins
		config.addAllowedMethod("*"); // Allow all methods (GET, POST, etc.)
		config.addAllowedHeader("*"); // Allow all headers
		config.setAllowCredentials(true); // Allow credentials
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

/*	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}*/
}
