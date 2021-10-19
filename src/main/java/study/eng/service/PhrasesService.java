package study.eng.service;

import org.springframework.stereotype.Service;
import study.eng.entity.Phrases;
import study.eng.repository.PhrasesRepository;

@Service
public class PhrasesService {
    private PhrasesRepository phrasesRepository;

    public PhrasesService(PhrasesRepository repository) {
        this.phrasesRepository = repository;
    }

    public void save(Phrases phrase) {
        this.phrasesRepository.save(phrase);
    }
}
