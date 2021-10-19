package study.eng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.eng.entity.Phrases;

@Repository
public interface PhrasesRepository extends JpaRepository<Phrases, Long> {}
