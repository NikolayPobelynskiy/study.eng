package study.eng.entity;

import javax.persistence.*;

@Entity(name = "en_word_category")
public class EnWordCategory {
    public void EnWordCategory() {}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long categoryId;

    @Column(name= "category_name")
    private String categoryName;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
