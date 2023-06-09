package cybersoft.example.cozastore_java21.entity2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name="tag")
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "tag")
    private Set<TagBlogEntity> tagBlogEntities;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<CategoryEntity> categoryEntities;

    public TagEntity() {
    }

    public TagEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TagBlogEntity> getTagBlogEntities() {
        return tagBlogEntities;
    }

    public void setTagBlogEntities(Set<TagBlogEntity> tagBlogEntities) {
        this.tagBlogEntities = tagBlogEntities;
    }

    public Set<CategoryEntity> getCategoryEntities() {
        return categoryEntities;
    }

    public void setCategoryEntities(Set<CategoryEntity> categoryEntities) {
        this.categoryEntities = categoryEntities;
    }
}
