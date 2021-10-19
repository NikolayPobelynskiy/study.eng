package study.eng.entity;

import javax.persistence.*;

@Entity(name = "ru_word")
public class RuWord {
    public void RuWord() {}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private EnWord enWord;

    @Column(name = "word")
    private String word;

    @Column(name = "en_word_id")
    private Long enWordId;

    public Long getId() {
        return id;
    }

    public void setId(Long ruWordId) {
        this.id = ruWordId;
    }
//    public EnWord getEnWord() {
//        return enWord;
//    }
//
//    public void setEnWord(EnWord enWord) {
//        this.enWord = enWord;
//    }
//

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Long getEnWordId() {
        return enWordId;
    }

    public void setEnWordId(Long enWordId) {
        this.enWordId = enWordId;
    }
}
