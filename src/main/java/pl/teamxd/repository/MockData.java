package pl.teamxd.repository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.teamxd.model.Ingredient;
import pl.teamxd.model.Recipe;

import javax.annotation.PostConstruct;

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
             ingredient.addRecipe(recipe);
             recipe.addIngredient(ingredient);
             recipeRepository.save(recipe);
             ingredientRepository.save(ingredient);
        }
    }
}
