package pl.teamxd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.teamxd.service.RecipeService;

@SpringBootTest
class ApplicationTests {
    @Autowired
    RecipeService recipeService;


}
