package cn.pku.meizi.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Parent;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by sunbo on 16/6/21.
 */
@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int raw_id;
    private int status;
    private double price;
    /*private String use_target;
    private String use_way;
    private String use_format;
    private Integer use_period;*/
    private Integer vendor_id;
    private Integer media_id;
    private String level;
    private Integer media_usage_id;
    /*private Integer download_count;*/

    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "order_id", nullable = false)
    @Cascade(CascadeType.DETACH)
    private Order order;

    public OrderItem() {
    }

    public OrderItem(int raw_id, int status, double price, Integer vendor_id, Integer media_id, String level, Integer media_usage_id, Order order) {
        this.raw_id = raw_id;
        this.status = status;
        this.price = price;
        this.vendor_id = vendor_id;
        this.media_id = media_id;
        this.level = level;
        this.media_usage_id = media_usage_id;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRaw_id() {
        return raw_id;
    }

    public void setRaw_id(int raw_id) {
        this.raw_id = raw_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(Integer vendor_id) {
        this.vendor_id = vendor_id;
    }

    public Integer getMedia_id() {
        return media_id;
    }

    public void setMedia_id(Integer media_id) {
        this.media_id = media_id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getMedia_usage_id() {
        return media_usage_id;
    }

    public void setMedia_usage_id(Integer media_usage_id) {
        this.media_usage_id = media_usage_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}