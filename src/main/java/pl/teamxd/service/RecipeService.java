package pl.teamxd.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.teamxd.model.Recipe;
import pl.teamxd.repository.IngredientRepository;
import pl.teamxd.repository.RecipeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;
    private IngredientRepository ingredientRepository;

    @Autowired
    public void setRecipeRepository(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void setIngredientRepository(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    public List<Recipe> getRecipeByName(String name) {
        return recipeRepository.findByName(name);
    }

    public List<Recipe> getRecipeByCategory(String category) {
        return recipeRepository.findRecipeByCategory(category);
    }

}
