package study.eng.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "en_word")
public class EnWord {
    public void EnWord() {}

    @Id
    @Column(name = "en_word_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long enWordId;

    @Column(name = "word")
    private String word;

    @Column(name = "category_id")
    private String categoryId;

    @ManyToMany
    Set<Dictionary> dictionary;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false, insertable=false, updatable=false)
    private EnWordCategory category;

    public EnWordCategory getCategory() {
        return category;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "enWordId", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<RuWord> ruWords = new ArrayList<RuWord>();

    public List<RuWord> getRuWords() {
        return ruWords;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "enWordId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phrases> phrases = new ArrayList<Phrases>();

    public Set<Dictionary> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Set<Dictionary> dictionary) {
        this.dictionary = dictionary;
    }

    public List<Phrases> getPhrases() {
        return phrases;
    }

    public void setRuWords(List<RuWord> ruWords) {
        this.ruWords = ruWords;
    }

    public Long getEnWordId() {
        return enWordId;
    }

    public void setEnWordId(Long enWordId) {
        this.enWordId = enWordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}