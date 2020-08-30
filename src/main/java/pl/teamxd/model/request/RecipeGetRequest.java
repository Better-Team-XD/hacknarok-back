package pl.teamxd.model.request;

import lombok.*;
import pl.teamxd.model.Recipe;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeGetRequest {
    private String name;
    private String category;
    private String url;
    private String imgUrl;
    private Integer missing;

    public RecipeGetRequest(Recipe recipe, Integer missing){
        name = recipe.getName();
        category = recipe.getCategory();
        url = recipe.getUrl();
        imgUrl = recipe.getImgUrl();
        this.missing = missing;
    }
}
