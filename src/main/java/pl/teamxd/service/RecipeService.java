package pl.teamxd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.teamxd.model.Recipe;
import pl.teamxd.repository.RecipeRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getRecipesMatching(List<String> ingredients, String category){
        List<Recipe> recipes = recipeRepository.findAllByCategory(category);
        List<Recipe> result = new ArrayList<>();

        for (Recipe recipe : recipes){
            int matches = 0;
            for (String ingredient : ingredients){
                if (recipe.getIngredients().contains(ingredient)){
                    System.out.println(recipe.getIngredients());
                    matches++;
                }
            }

            if  (Math.abs((double) (matches / recipe.getIngredients().size()) - 1) < 1e-10){
                result.add(recipe);
            }
        }
        return result;
    }
}
