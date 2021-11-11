package study.eng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import study.eng.entity.Dictionary;
import study.eng.entity.EnWordCategory;
import study.eng.entity.User;

import java.util.Optional;

@Repository
public interface DictionaryRepository extends JpaRepository <Dictionary, Long> {
    Optional<Dictionary> findByUser(User user);
}
