package com.dakar.DakarApi;

import com.dakar.DakarApi.entities.ERole;
import com.dakar.DakarApi.entities.RoleEntity;
import com.dakar.DakarApi.entities.UserEntity;
import com.dakar.DakarApi.repository.UserRepository;
import com.dakar.DakarApi.service.IUserService;
import com.dakar.DakarApi.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class DakarApiApplication {



	public static void main(String[] args) {
		SpringApplication.run(DakarApiApplication.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder;


	@Bean
	CommandLineRunner init() {
		return args -> {
		String pass = passwordEncoder.encode("12345");
			System.out.println(pass);

		};
	}



		}
