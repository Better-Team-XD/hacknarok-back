package pl.teamxd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.teamxd.model.request.RecipeRequest;
import pl.teamxd.repository.RecipeRepository;
import pl.teamxd.service.IngredientService;
import pl.teamxd.service.RecipeService;

@RestController
@RequestMapping("/api/v1/recipes")
@RequiredArgsConstructor
@CrossOrigin
public class RecipeController {
    private final RecipeService recipeService;

    @PostMapping public void postRecipe(@RequestBody RecipeRequest recipeRequest) {
        recipeService.addRecipe(recipeRequest);
    }


}
