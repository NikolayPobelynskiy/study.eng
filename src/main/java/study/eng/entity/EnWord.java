package study.eng.entity;

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

//    //@OneToOne(fetch = FetchType.LAZY)
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "category_id")

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false, insertable=false, updatable=false)
    private EnWordCategory category;

    public EnWordCategory getCategory() {
        return category;
    }

//    public void setCategory(EnWordCategory category) {
//        this.category = category;
//    }

    @OneToMany(mappedBy = "enWordId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RuWord> ruWords = new HashSet<>();

    public Set<RuWord> getRuWords() {
        return ruWords;
    }

    @OneToMany(mappedBy = "enWordId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Phrases> phrases = new HashSet<>();

    public Set<Phrases> getPhrases() {
        return phrases;
    }

    public void setRuWords(Set<RuWord> ruWords) {
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