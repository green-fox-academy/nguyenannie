package com.greenfox.tamagochi;

import com.greenfox.tamagochi.Model.*;
import com.greenfox.tamagochi.Service.FoxService;
import com.greenfox.tamagochi.Service.TrickService;
import com.greenfox.tamagochi.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TamagochiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TamagochiApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo(UserService userService, FoxService foxService, TrickService trickService) {
        return (String... args) -> {
            Tamagochier tamagochier1 = new Tamagochier();
            tamagochier1.setName("Annie");
            tamagochier1.setPassword("rubrubisthebest");
            userService.addNewUser(tamagochier1);

            Tamagochier tamagochier2 = new Tamagochier();
            tamagochier2.setName("Sally");
            tamagochier2.setPassword("12345");
            userService.addNewUser(tamagochier2);

            Tamagochier tamagochier3 = new Tamagochier();
            tamagochier3.setName("Bobby");
            tamagochier3.setPassword("abcdefgh");
            userService.addNewUser(tamagochier3);

            Fox fox1 = new Fox();
            fox1.setName("Annie");
            fox1.setFood(Food.chicken.name());
            fox1.setDrink(Drink.apple_juice.name());
            fox1.setTamagochier(tamagochier2);

            Fox fox2 = new Fox();
            fox2.setName("Bea");
            fox2.setFood(Food.pasta.name());
            fox2.setDrink(Drink.cola.name());
            fox2.setTamagochier(tamagochier3);

            Fox fox3 = new Fox();
            fox3.setName("Charles");
            fox3.setFood(Food.pizza.name());
            fox3.setDrink(Drink.tea.name());
            fox3.setTamagochier(tamagochier1);

            Trick trick1 = new Trick("Use Bootstrap", "Basic level");
            Trick trick2 = new Trick("Code in Java", "Intermediate level");
            Trick trick3 = new Trick("Code in C#", "Intermediate level");
            Trick trick4 = new Trick("Code in C++", "Difficult level");
            Trick trick5 = new Trick("Code in Haskell", "Difficult level");

            trickService.addNewTrick(trick1);
            trickService.addNewTrick(trick2);
            trickService.addNewTrick(trick3);
            trickService.addNewTrick(trick4);
            trickService.addNewTrick(trick5);

            fox1.addTrick(trick2);
            fox2.addTrick(trick3);
            fox2.addTrick(trick1);
            fox3.addTrick(trick5);
            fox3.addTrick(trick1);

            foxService.addNewFox(fox1);
            foxService.addNewFox(fox2);
            foxService.addNewFox(fox3);

        };
    }
}
