package study.eng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.eng.entity.RuWord;

@Repository
public interface RuWordRepository extends JpaRepository<RuWord, Long> { }