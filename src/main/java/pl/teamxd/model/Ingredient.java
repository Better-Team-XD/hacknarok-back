package pl.teamxd.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @NotNull
    private String name;

    @ManyToMany
    private Set<Recipe> recipes = new HashSet<>();

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
