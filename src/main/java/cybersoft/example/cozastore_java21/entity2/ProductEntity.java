package cybersoft.example.cozastore_java21.entity2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name="product")
public class ProductEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="image")
    private String image;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private int price;

    @Column(name="description")
    private String description;

    @Column(name="quantity")
    private int quantity;

    @Column(name="image_detail")
    private String image_detail;

    @ManyToOne
    @JoinColumn(name="size_id")
    @JsonIgnore
    private SizeEntity sizeEntity;

    @ManyToOne
    @JoinColumn(name="color_id")
    @JsonIgnore
    private ColorEntity colorEntity;

    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonIgnore
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<OrderDetailEntity> orderDetailEntities;

    public ProductEntity() {
    }

    public ProductEntity(int id, String image, String name, int price, String description, int quantity, String image_detail, SizeEntity sizeEntity, ColorEntity colorEntity, CategoryEntity categoryEntity) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.image_detail = image_detail;
        this.sizeEntity = sizeEntity;
        this.colorEntity = colorEntity;
        this.categoryEntity = categoryEntity;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage_detail() {
        return image_detail;
    }

    public void setImage_detail(String image_detail) {
        this.image_detail = image_detail;
    }

    public SizeEntity getSizeEntity() {
        return sizeEntity;
    }

    public void setSizeEntity(SizeEntity sizeEntity) {
        this.sizeEntity = sizeEntity;
    }

    public ColorEntity getColorEntity() {
        return colorEntity;
    }

    public void setColorEntity(ColorEntity colorEntity) {
        this.colorEntity = colorEntity;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public Set<OrderDetailEntity> getOrderDetailEntities() {
        return orderDetailEntities;
    }

    public void setOrderDetailEntities(Set<OrderDetailEntity> orderDetailEntities) {
        this.orderDetailEntities = orderDetailEntities;
    }
}
