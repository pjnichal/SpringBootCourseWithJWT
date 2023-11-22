package com.example.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

	// @Bean
	// CommandLineRunner run(AppUserService appUserService) {
	// return args -> {
	// appUserService.saveAppRole(new AppRole(null, "ROLE_USER"));
	// appUserService.saveAppRole(new AppRole(null, "ROLE_ADMIN"));
	// appUserService.saveAppUser(
	// new AppUser(null, "PRAVIN NICHAL", "nichal.pravin2001@gmail.com", "123", new
	// ArrayList<>()));
	// appUserService.saveAppUser(
	// new AppUser(null, "YASH LALIT", "yashlalit@gmail.com", "123", new
	// ArrayList<>()));
	// appUserService.addRoleToUser("nichal.pravin2001@gmail.com", "ROLE_ADMIN");
	// appUserService.addRoleToUser("yashlalit@gmail.com", "ROLE_USER");
	// appUserService.addRoleToUser("yashlalit@gmail.com", "ROLE_ADMIN");
	// };
	// }

}
