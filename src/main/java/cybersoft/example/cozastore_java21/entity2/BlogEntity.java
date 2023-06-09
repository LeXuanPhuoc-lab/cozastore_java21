package cybersoft.example.cozastore_java21.entity2;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name="blog")
public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="image")
    private String image;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity userEntity;

    @Column(name="content")
    private String content;

    @Column(name="create_date")
    private Date create_date;

    @OneToMany(mappedBy = "blog")
    private Set<TagBlogEntity> tagBlogEntities;

    @OneToMany(mappedBy = "blog")
    private Set<CommentEntity> commentEntities;


    public BlogEntity(int id, String image, String title, String description, UserEntity userEntity, String content, Date create_date, Set<TagBlogEntity> tagBlogEntities, Set<CommentEntity> commentEntities) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
        this.userEntity = userEntity;
        this.content = content;
        this.create_date = create_date;
        this.tagBlogEntities = tagBlogEntities;
        this.commentEntities = commentEntities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Set<TagBlogEntity> getTagBlogEntities() {
        return tagBlogEntities;
    }

    public void setTagBlogEntities(Set<TagBlogEntity> tagBlogEntities) {
        this.tagBlogEntities = tagBlogEntities;
    }

    public Set<CommentEntity> getCommentEntities() {
        return commentEntities;
    }

    public void setCommentEntities(Set<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }
}
