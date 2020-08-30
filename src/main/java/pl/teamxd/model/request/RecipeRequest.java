package pl.teamxd.model.request;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeRequest {
    private String name;
    private String category;
    private String url;
    private String imgUrl;
    private List<String> ingredients;
}
