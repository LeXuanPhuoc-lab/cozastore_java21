package cybersoft.example.cozastore_java21.entity2;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name="color")
public class ColorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "color")
    private Set<ProductEntity> products;

    public ColorEntity(int id, String name, Set<ProductEntity> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public ColorEntity() {
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

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }
}

