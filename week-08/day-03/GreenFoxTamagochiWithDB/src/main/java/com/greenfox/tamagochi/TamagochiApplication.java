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
            fox1.setName("fox1");
            fox1.setFood(Food.chicken.name());
            fox1.setDrink(Drink.apple_juice.name());
            fox1.setTamagochier(tamagochier2);

            Fox fox2 = new Fox();
            fox2.setName("fox2");
            fox2.setFood(Food.pasta.name());
            fox2.setDrink(Drink.cola.name());
            fox2.setTamagochier(tamagochier3);

            Fox fox3 = new Fox();
            fox3.setName("fox3");
            fox3.setFood(Food.pizza.name());
            fox3.setDrink(Drink.tea.name());
            fox3.setTamagochier(tamagochier1);

            Trick trick1 = new Trick();
            trick1.setDescription("Basic level");
            trick1.setName("Code in Haskell");
            trick1.getFoxes().add(fox1);
            trickService.addNewTrick(trick1);

            Trick trick2 = new Trick();
            trick2.setDescription("Intermediate level");
            trick2.setName("Use Bootstrap");
            trick1.getFoxes().add(fox3);
            trickService.addNewTrick(trick2);

            foxService.addNewFox(fox1);
            foxService.addNewFox(fox2);
            foxService.addNewFox(fox3);
        };
    }
}
