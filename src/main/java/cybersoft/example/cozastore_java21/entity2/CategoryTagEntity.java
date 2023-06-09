package cybersoft.example.cozastore_java21.entity2;

import cybersoft.example.cozastore_java21.entity2.ids.CategoryTagIds;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="category_tag")
public class CategoryTagEntity {
    @EmbeddedId
    private CategoryTagIds categoryTagIds;

    @ManyToOne
    @JoinColumn(name="category_id", insertable = false, updatable = false)
    private CategoryEntity categoryEntity;

    @ManyToOne
    @JoinColumn(name="tag_id",insertable = false, updatable = false)
    private TagEntity tagEntity;

    public CategoryTagEntity(CategoryTagIds categoryTagIds, CategoryEntity categoryEntity, TagEntity tagEntity) {
        this.categoryTagIds = categoryTagIds;
        this.categoryEntity = categoryEntity;
        this.tagEntity = tagEntity;
    }

    public CategoryTagIds getCategoryTagIds() {
        return categoryTagIds;
    }

    public void setCategoryTagIds(CategoryTagIds categoryTagIds) {
        this.categoryTagIds = categoryTagIds;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public TagEntity getTagEntity() {
        return tagEntity;
    }

    public void setTagEntity(TagEntity tagEntity) {
        this.tagEntity = tagEntity;
    }
}
