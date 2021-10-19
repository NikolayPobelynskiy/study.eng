package study.eng.entity;

import javax.persistence.*;

@Entity(name = "phrases")
public class Phrases {

    public void Phrases() {}

    @Id
    @Column(name = "phrase_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long phraseId;

    @Column(name = "text")
    private String text;

    @Column(name = "translation")
    private String translation;

    @Column(name = "en_word_id")
    private Long enWordId;

    public Long getPhraseId() {
        return phraseId;
    }

    public void setPhraseId(Long phraseId) {
        this.phraseId = phraseId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Long getEnWordId() {
        return enWordId;
    }

    public void setEnWordId(Long enWordId) {
        this.enWordId = enWordId;
    }
}
