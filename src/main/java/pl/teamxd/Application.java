package pl.teamxd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.teamxd.model.Recipe;
import pl.teamxd.repository.IngredientRepository;
import pl.teamxd.repository.RecipeRepository;
import pl.teamxd.service.RecipeService;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
