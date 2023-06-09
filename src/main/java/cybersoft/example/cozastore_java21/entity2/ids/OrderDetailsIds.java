package cybersoft.example.cozastore_java21.entity2.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderDetailsIds implements Serializable {
    @Column(name="product_id")
    private int product_id;

    @Column(name="user_id")
    private int user_id;

    public OrderDetailsIds() {
    }

    public OrderDetailsIds(int product_id, int user_id) {
        this.product_id = product_id;
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
