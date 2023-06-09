package cybersoft.example.cozastore_java21.entity2.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CategoryTagIds {
    @Column(name="category_id")
    private int category_id;

    @Column(name="tag_id")
    private int tag_id;

    public CategoryTagIds(int category_id, int tag_id) {
        this.category_id = category_id;
        this.tag_id = tag_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }
}
