package pl.teamxd.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.teamxd.model.Ingredient;
import pl.teamxd.model.Recipe;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

@Component
@AllArgsConstructor
public class MockData {
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    @PostConstruct
    public void mockDataInit() {
        Ingredient ingredient = null;
        Recipe recipe = null;
        for (int i = 0; i < 5; i++) {
            ingredient = new Ingredient("Skladnik " + i);
            recipe = new Recipe("Przepis " + i, "kategoria", "url", "imgUrl");
            recipeRepository.save(recipe);
            ingredientRepository.save(ingredient);
            ingredient.setRecipes(Set.of(recipe));
            recipe.setIngredients(Set.of(ingredient));
            recipeRepository.save(recipe);
            ingredientRepository.save(ingredient);
        }
    }
}
