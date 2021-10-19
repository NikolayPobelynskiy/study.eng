package study.eng.service;

import org.springframework.stereotype.Service;
import study.eng.entity.EnWord;
import study.eng.entity.RuWord;
import study.eng.repository.RuWordRepository;

import java.util.List;

@Service
public class RuWordService {

    private RuWordRepository ruWordRepository;

    public RuWordService(RuWordRepository repository) {
        this.ruWordRepository = repository;
    }

    public void save(RuWord word) {
        this.ruWordRepository.save(word);
    }

    public List<RuWord> findAll() { return this.ruWordRepository.findAll(); }
}
