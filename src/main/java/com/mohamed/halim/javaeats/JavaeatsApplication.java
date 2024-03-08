package com.mohamed.halim.javaeats;

import com.mohamed.halim.javaeats.model.Restaurant;
import com.mohamed.halim.javaeats.repository.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JavaeatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaeatsApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(RestaurantRepository restaurantRepository) {
		return args -> {
            var restaurant = new Restaurant();
            restaurant.setName("test");
            restaurant.setDescription("test desc");
            restaurant.setLocation("test loc");
            for (int i = 0; i < 100; i++) {
                restaurant.setId((long) i);
                restaurantRepository.save(restaurant);
            }
        };

    }
}
