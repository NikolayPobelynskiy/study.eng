package study.eng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.eng.entity.EnWordCategory;

@Repository
public interface EnWordCategoryRepository extends JpaRepository<EnWordCategory, Long> { }