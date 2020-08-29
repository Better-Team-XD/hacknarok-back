package pl.teamxd.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.teamxd.model.Recipe;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Component
@AllArgsConstructor
public class MockData {
    private final RecipeRepository recipeRepository;

    @PostConstruct
    public void mockDataInit() {
        Recipe recipe = null;
        for (int i = 0; i < 5; i++) {
             recipe = new Recipe("Przepis " + i, "kategoria", "url", "imgUrl");
             recipeRepository.save(recipe);
             recipe.addIngredients(Collections.singletonList("Skladnik " + i));
             recipeRepository.save(recipe);
        }
    }
}
