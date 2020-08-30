package pl.teamxd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.teamxd.model.request.MatchRequest;
import pl.teamxd.service.RecipeService;

@RestController
@RequestMapping("api/v1/matches")
@RequiredArgsConstructor
@CrossOrigin
public class MatchController {
    private final RecipeService recipeService;

    @PostMapping
    public ResponseEntity<Object> getMatches(@RequestBody MatchRequest request){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(recipeService.getRecipesMatching(request.getIngredients(), request.getCategory()));
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.toString());
        }
    }
}
