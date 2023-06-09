package cybersoft.example.cozastore_java21.entity2;

import cybersoft.example.cozastore_java21.entity2.ids.TagBlogIds;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="tag_blog")
public class TagBlogEntity {
    @EmbeddedId
    private TagBlogIds tagBlogIds;

    @ManyToOne
    @JoinColumn(name="tag_id" ,insertable = false, updatable = false)
    private TagEntity tagEntity;

    @ManyToOne
    @JoinColumn(name="blog_id", insertable = false, updatable = false)
    private BlogEntity blogEntity;

    public TagBlogEntity() {
    }

    public TagBlogEntity(TagBlogIds tagBlogIds) {
        this.tagBlogIds = tagBlogIds;
    }

    public TagBlogIds getTagBlogIds() {
        return tagBlogIds;
    }

    public void setTagBlogIds(TagBlogIds tagBlogIds) {
        this.tagBlogIds = tagBlogIds;
    }
}
