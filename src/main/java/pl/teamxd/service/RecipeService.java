package pl.teamxd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.teamxd.model.Ingredient;
import pl.teamxd.model.Recipe;
import pl.teamxd.model.request.RecipeRequest;
import pl.teamxd.repository.IngredientRepository;
import pl.teamxd.repository.RecipeRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    public Recipe addRecipe(RecipeRequest recipeRequest) {
        Set<Ingredient> ingredients = new HashSet<>();
        for (String string : recipeRequest.getIngredients()){
            if (ingredientRepository.findByName(string).isPresent()){
                ingredients.add(ingredientRepository.findByName(string).get());
            } else {
                ingredients.add(new Ingredient(string));
            }
        }
        Recipe recipe = new Recipe(recipeRequest.getName(), recipeRequest.getCategory(), recipeRequest.getUrl(), recipeRequest.getImgUrl());
        recipeRepository.save(recipe);
        ingredients.forEach(ingredientRepository::save);
        recipe.setIngredients(ingredients);
        ingredients.forEach(ingredient -> ingredient.addRecipe(recipe));
        recipe.setIngredients(ingredients);
        ingredients.forEach(ingredientRepository::save);
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getRecipesMatching(List<Ingredient> ingredients, String category){
        List<Recipe> recipes = recipeRepository.findAllByCategory(category);
        List<Recipe> result = new ArrayList<>();
        for (Recipe recipe : recipes){
            int matches = 0;
            for (Ingredient ingredient : ingredients){
                if (recipe.getIngredients().contains(ingredient)){
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
