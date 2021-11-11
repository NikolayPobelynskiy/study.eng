package study.eng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.eng.entity.Dictionary;
import study.eng.entity.User;
import study.eng.repository.DictionaryRepository;

import java.util.Optional;

@Service
public class DictionaryService {
    @Autowired
    private DictionaryRepository dictionaryRepository;

    public DictionaryService(DictionaryRepository repository) {
        this.dictionaryRepository = repository;
    }

    public Optional<Dictionary> findById(Long id) {
        return this.dictionaryRepository.findById(id);
    }

    public Optional<Dictionary> findByUser(User user) {
        return this.dictionaryRepository.findByUser(user);
    }

    public void save(Dictionary dictionary) {
        this.dictionaryRepository.save(dictionary);
    }

    public void saveAndFlush(Dictionary dictionary) {
        this.dictionaryRepository.saveAndFlush(dictionary);
    }
}
