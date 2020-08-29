package pl.teamxd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.teamxd.repository.RecipeRepository;
import pl.teamxd.service.RecipeService;

@RestController
@RequestMapping("/api/v1/ingredients")
@RequiredArgsConstructor
public class IngredientController {
    private final RecipeService recipeService;
}
