package com.H2UKUM.Hukum;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.H2UKUM.Hukum.DataAccess.UserRepository;
import com.H2UKUM.Hukum.Models.User;

@SpringBootApplication
public class HukumApplication {

	public static void main(String[] args) {
		SpringApplication.run(HukumApplication.class, args);
	}


	@Bean
	public CommandLineRunner userCreator(UserRepository userRepository,PasswordEncoder passwordEncoder){
		return (args) -> {
				User user = new User();
				user.setUserId(61);
				user.setName("Mehmet Talha");
				user.setSurname("AYAR");
				user.setPassword(passwordEncoder.encode("Aa123456"));
				user.setEmail("mehmettalhaayar61@gmail.com");
				user.setUsername("Sultan");
				user.setVerified(true);
				user.setUserRoleId(1);
				userRepository.save(user);

			};
			
		};
}
