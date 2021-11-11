package study.eng.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity(name = "dictionary")
public class Dictionary {
    public void Dictionary() {}

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<EnWord> enWords;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Id
    @Column(name = "dictionary_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long dictionaryId;

    public User getUser() {
        return user;
    }

    public Long getUserId() {
        return user.getId();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<EnWord> getEnWords() {
        return enWords;
    }

    public void setEnWords(Set<EnWord> enWords) {
        this.enWords = enWords;
    }

    public void addEnWord(EnWord enWord) {
        this.enWords.add(enWord);
    }

    public void removeEnWord(EnWord enWord) {
        this.enWords.remove(enWord);
    }

    public boolean findEnWord(EnWord enWord) {
        EnWord resultWord = this.enWords.stream().filter(word -> word.getEnWordId().equals(enWord.getEnWordId()))
                .findFirst().orElse(null);

        return Objects.isNull(resultWord) ? false : true;
    }

    public Long getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(Long dictionaryId) {
        this.dictionaryId = dictionaryId;
    }
}
