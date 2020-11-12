package com.derteuffel.scpt;

import com.derteuffel.scpt.entities.Role;
import com.derteuffel.scpt.enums.ERole;
import com.derteuffel.scpt.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScptApplication implements CommandLineRunner{

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(ScptApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*Role user = new Role(ERole.ROLE_USER);
		Role root = new Role(ERole.ROLE_ROOT);
		Role admin = new Role(ERole.ROLE_ADMIN);

		roleRepository.save(user);
		roleRepository.save(root);
		roleRepository.save(admin);*/
	}
}
