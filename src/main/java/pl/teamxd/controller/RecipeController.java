package pl.teamxd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.teamxd.model.request.RecipeRequest;
import pl.teamxd.service.RecipeService;

@RestController
@RequestMapping("/api/v1/recipes")
@RequiredArgsConstructor
@CrossOrigin
public class RecipeController {
    private final RecipeService recipeService;

    @PostMapping
    public ResponseEntity<Object> postRecipe(@RequestBody RecipeRequest recipeRequest) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(recipeService.addRecipe(recipeRequest));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.toString());
        }
    }
}
