package pl.teamxd.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.teamxd.model.Recipe;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;

@Component
@AllArgsConstructor
public class MockData {
    private final RecipeRepository recipeRepository;

    @PostConstruct
    public void mockDataInit() {
        Recipe recipe = null;
        Recipe recipe1 = new Recipe("Przepis 1", "kategoria", "url", "imgUrl");
        recipeRepository.save(recipe1);
        recipe1.addIngredients(Arrays.asList("A", "B", "C"));
        recipeRepository.save(recipe1);

        Recipe recipe2 = new Recipe("Przepis 2", "kategoria", "url", "imgUrl");
        recipeRepository.save(recipe2);
        recipe2.addIngredients(Arrays.asList("A", "B"));
        recipeRepository.save(recipe2);

        Recipe recipe3 = new Recipe("Przepis 3", "kategoria", "url", "imgUrl");
        recipeRepository.save(recipe3);
        recipe3.addIngredients(Arrays.asList("A", "B", "D"));
        recipeRepository.save(recipe3);
    }
}
