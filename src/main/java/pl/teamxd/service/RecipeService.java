package pl.teamxd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.teamxd.model.Recipe;
import pl.teamxd.repository.RecipeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    public List<Recipe> getRecipeByName(String name) {
        return recipeRepository.findByName(name);
    }

    public List<Recipe> getRecipesByCategory(String category) {
        return recipeRepository.findRecipeByCategory(category);
    }

//    public List<Recipe> getRecipesByIngredients() {
//        List<Recipe> recipes = recipeRepository.findAll();
//    }

}
