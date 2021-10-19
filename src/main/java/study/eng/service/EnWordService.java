package study.eng.service;

import org.springframework.stereotype.Service;
import study.eng.entity.EnWord;
import study.eng.repository.EnWordRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnWordService {
    private EnWordRepository enWordRepository;

    public EnWordService(EnWordRepository repository) {
        this.enWordRepository = repository;
    }

    public List<EnWord> findAll() { return this.enWordRepository.findAll(); }

    public void save(EnWord word) {
        this.enWordRepository.save(word);
    }

    public Optional<EnWord> findById(Long enWordId) throws Exception {
        Optional<EnWord> word = this.enWordRepository.findById(enWordId);
        return word;
    }
}
