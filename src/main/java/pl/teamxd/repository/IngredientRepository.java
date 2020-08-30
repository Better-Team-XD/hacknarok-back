package pl.teamxd.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.teamxd.model.Ingredient;
import pl.teamxd.model.Recipe;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findByName(String name);
}