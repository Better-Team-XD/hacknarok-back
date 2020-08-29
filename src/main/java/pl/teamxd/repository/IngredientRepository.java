package pl.teamxd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.teamxd.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> { }
