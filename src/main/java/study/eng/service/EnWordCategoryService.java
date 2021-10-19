package study.eng.service;

import org.springframework.stereotype.Service;
import study.eng.entity.EnWordCategory;
import study.eng.repository.EnWordCategoryRepository;
import study.eng.repository.EnWordRepository;

import java.util.List;

@Service
public class EnWordCategoryService {
    private EnWordCategoryRepository enWordCategoryRepository;

    public EnWordCategoryService(EnWordCategoryRepository repository) {
        this.enWordCategoryRepository = repository;
    }

    public List<EnWordCategory> findAll() { return this.enWordCategoryRepository.findAll(); }

    public void save(EnWordCategory category) {
        this.enWordCategoryRepository.save(category);
    }
}