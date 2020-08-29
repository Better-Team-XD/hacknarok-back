package pl.teamxd.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NonNull
    private String name;

    @NotNull
    @NonNull
    private String category;

    @NotNull
    @NonNull
    private String url;

    @NotNull
    @NonNull
    private String imgUrl;

    @ElementCollection(fetch = FetchType.EAGER)
    private final Set<String> ingredients = new HashSet<>();

    public void addIngredients(Collection<String> ingredients) {
        this.ingredients.addAll(ingredients);
    }

}
