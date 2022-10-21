package com.example.security;

import com.example.security.entity.AppUser;
import com.example.security.entity.AppUserRole;
import com.example.security.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityMysqlApplication {

	@Autowired
	private AppUserRepository appUserRepository;

	@PostConstruct
	public void initUsers(){
		List<AppUser> customers = Stream.of(
				new AppUser("Admin","xin.gu1707@gmail.com","123456", AppUserRole.ADMIN,false,false),
				new AppUser("user1","us1@gmail.com","pwd1",AppUserRole.USER,false,false),
				new AppUser("user2","us2@gmail.com","pwd2",AppUserRole.USER,false,false),
				new AppUser("user3","us3@gmail.com","pwd3",AppUserRole.USER,false,false)
		).collect(Collectors.toList());
		appUserRepository.saveAll(customers);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityMysqlApplication.class, args);
	}

}
