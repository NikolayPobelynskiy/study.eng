package study.eng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.eng.entity.EnWord;

import java.util.Optional;

@Repository
public interface EnWordRepository extends JpaRepository<EnWord, Long> {
    Optional<EnWord> findById(Long id);
}