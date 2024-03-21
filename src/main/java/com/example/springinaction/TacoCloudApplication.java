package com.example.springinaction;

import com.example.springinaction.data.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.springinaction.Ingredient.Type.*;

@SpringBootApplication // 현재 클래스를 구성 클래스로 지정
public class TacoCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args); // 애플리케이션을 실행
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repo) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                repo.save(new Ingredient("FLTO", "Flour Tortilla", WRAP));
                repo.save(new Ingredient("COTO", "Corn Tortilla", WRAP));
                repo.save(new Ingredient("GRBF", "Ground Beef", PROTEIN));
                repo.save(new Ingredient("CARN", "Carnitas", PROTEIN));
                repo.save(new Ingredient("TMTO", "Diced Tomatoes", VEGGIES));
                repo.save(new Ingredient("LETC", "Lettuce", VEGGIES));
                repo.save(new Ingredient("CHED", "Cheddar", CHEESE));
                repo.save(new Ingredient("JACK", "Monterrey Jack", CHEESE));
                repo.save(new Ingredient("SLSA", "Salsa", SAUCE));
                repo.save(new Ingredient("SRCR", "Sour Cream", SAUCE));
            }
        };
    }
}

