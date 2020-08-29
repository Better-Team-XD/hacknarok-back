package pl.teamxd.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
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

    @ElementCollection
    private Set<String> ingredients = new HashSet<>();

    public void addIngredients(Collection<String> ingredients) {
        this.ingredients.addAll(ingredients);
    }

}
