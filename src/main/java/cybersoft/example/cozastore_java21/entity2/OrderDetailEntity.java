package cybersoft.example.cozastore_java21.entity2;

import cybersoft.example.cozastore_java21.entity2.ids.OrderDetailsIds;
import jakarta.persistence.*;

@Entity(name="order_detail")
public class OrderDetailEntity {
    @EmbeddedId
    private OrderDetailsIds orderDetailsIds;

    @Column(name="price")
    private int price;

    @Column(name="quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name="product_id", insertable = false, updatable = false)
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name="order_id", insertable = false, updatable = false)
    private OrderEntity orderEntity;


    public OrderDetailEntity(){}
    public OrderDetailEntity(OrderDetailsIds orderDetailsIds, int price, int quantity) {
        this.orderDetailsIds = orderDetailsIds;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderDetailsIds getOrderDetailsIds() {
        return orderDetailsIds;
    }

    public void setOrderDetailsIds(OrderDetailsIds orderDetailsIds) {
        this.orderDetailsIds = orderDetailsIds;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }
}
