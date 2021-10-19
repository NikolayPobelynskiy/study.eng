package study.eng.entity;

import javax.persistence.*;

@Entity(name = "ru_word")
public class RuWord {
    public void RuWord() {}

    @Id
    @Column(name = "ru_word_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long ruWordId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private EnWord enWord;

    @Column(name = "word")
    private String word;

    @Column(name = "en_word_id")
    private String enWordId;

    public Long getRuWordId() {
        return ruWordId;
    }

    public void setRuWordId(Long ruWordId) {
        this.ruWordId = ruWordId;
    }

//    public EnWord getEnWord() {
//        return enWord;
//    }
//
//    public void setEnWord(EnWord enWord) {
//        this.enWord = enWord;
//    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getEnWordId() {
        return enWordId;
    }

    public void setEnWordId(String enWordId) {
        this.enWordId = enWordId;
    }
}
