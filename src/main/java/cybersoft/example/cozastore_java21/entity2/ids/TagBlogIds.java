package cybersoft.example.cozastore_java21.entity2.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TagBlogIds {
    @Column(name="tag_id")
    private int tag_id;

    @Column(name="blog_id")
    private int blog_id;

    public TagBlogIds() {
    }

    public TagBlogIds(int tag_id, int blog_id) {
        this.tag_id = tag_id;
        this.blog_id = blog_id;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }
}
