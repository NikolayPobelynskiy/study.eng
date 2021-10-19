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

//    @OneToMany(mappedBy = "ruWord", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<RuWord> ruWords = new HashSet<>();
//    public void addBook(RuWord word){
//        ruWords.add(word);
////        book.setAuthor(this);
//    }
//    public void removeBook(RuWord word){
//        ruWords.remove(word);
////        book.setAuthor(null);
//    }

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