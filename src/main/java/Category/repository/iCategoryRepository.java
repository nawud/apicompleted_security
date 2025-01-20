package Category.repository;

import Category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iCategoryRepository extends JpaRepository<Category, Long> {}
