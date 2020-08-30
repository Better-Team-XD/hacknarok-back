package pl.teamxd.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.teamxd.model.Ingredient;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findByName(String name);
}