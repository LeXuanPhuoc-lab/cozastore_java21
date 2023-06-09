package cybersoft.example.cozastore_java21.entity2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name="country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="price_ship")
    private int price_ship;

    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private Set<OrderEntity> orders;

    public CountryEntity() {
    }

    public CountryEntity(int id, String name, int price_ship, Set<OrderEntity> orders) {
        this.id = id;
        this.name = name;
        this.price_ship = price_ship;
        this.orders = orders;
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

    public int getPrice_ship() {
        return price_ship;
    }

    public void setPrice_ship(int price_ship) {
        this.price_ship = price_ship;
    }

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }
}
