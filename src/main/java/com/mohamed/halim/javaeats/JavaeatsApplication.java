package com.mohamed.halim.javaeats;

import com.mohamed.halim.javaeats.model.Admin;
import com.mohamed.halim.javaeats.model.Restaurant;
import com.mohamed.halim.javaeats.repository.AdminRepository;
import com.mohamed.halim.javaeats.repository.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
public class JavaeatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaeatsApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(RestaurantRepository restaurantRepository, PasswordEncoder encoder, AdminRepository adminRepository) {
		return args -> {
            var restaurant = new Restaurant();
            restaurant.setName("test");
            restaurant.setDescription("test desc");
            restaurant.setLocation("test loc");
            for (int i = 0; i < 100; i++) {
                restaurant.setId((long) i);
                restaurantRepository.save(restaurant);
            }
            Admin admin = new Admin();
            admin.setName("root");
            admin.setPassword(encoder.encode("root"));
            adminRepository.save(admin);
        };

    }
}
