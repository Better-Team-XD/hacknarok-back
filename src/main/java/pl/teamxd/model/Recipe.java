package pl.teamxd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Ingredient> ingredients = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id) &&
                Objects.equals(name, recipe.name) &&
                Objects.equals(category, recipe.category) &&
                Objects.equals(url, recipe.url) &&
                Objects.equals(imgUrl, recipe.imgUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, url, imgUrl);
    }
}
