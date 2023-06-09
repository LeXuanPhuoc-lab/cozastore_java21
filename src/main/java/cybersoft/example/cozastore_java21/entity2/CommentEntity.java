package cybersoft.example.cozastore_java21.entity2;

import jakarta.persistence.*;

@Entity(name="u_comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="blog_id")
    private BlogEntity blogEntity;

    public CommentEntity(int id, BlogEntity blogEntity) {
        this.id = id;
        this.blogEntity = blogEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BlogEntity getBlogEntity() {
        return blogEntity;
    }

    public void setBlogEntity(BlogEntity blogEntity) {
        this.blogEntity = blogEntity;
    }
}
