package pl.teamxd.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.teamxd.model.Ingredient;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MatchRequest {
    private List<Ingredient> ingredients;
    private String category;

}
