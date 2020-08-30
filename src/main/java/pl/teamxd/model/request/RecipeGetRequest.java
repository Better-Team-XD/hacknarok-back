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
    private Integer matches;
    private Integer total;

    public RecipeGetRequest(Recipe recipe, Integer matches, Integer total){
        name = recipe.getName();
        category = recipe.getCategory();
        url = recipe.getUrl();
        imgUrl = recipe.getImgUrl();
        this.matches = matches;
        this.total = total;
    }
}
