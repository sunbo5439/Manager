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
    private String use_target;
    private String use_way;
    private String use_format;
    private Integer use_period;
    private Integer vendor_id;
    private Integer media_id;
    private String level;

    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "order_id", nullable = false)
    @Cascade(CascadeType.DETACH)
    private Order order;

    public OrderItem() {
    }

    public OrderItem(int raw_id, int status, double price, String use_target, String use_way, String use_format, Integer use_period, Integer vendor_id, Integer media_id, String level, Order order) {
        this.raw_id = raw_id;
        this.status = status;
        this.price = price;
        this.use_target = use_target;
        this.use_way = use_way;
        this.use_format = use_format;
        this.use_period = use_period;
        this.vendor_id = vendor_id;
        this.media_id = media_id;
        this.level = level;
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

    public String getUse_target() {
        return use_target;
    }

    public void setUse_target(String use_target) {
        this.use_target = use_target;
    }

    public String getUse_way() {
        return use_way;
    }

    public void setUse_way(String use_way) {
        this.use_way = use_way;
    }

    public String getUse_format() {
        return use_format;
    }

    public void setUse_format(String use_format) {
        this.use_format = use_format;
    }

    public Integer getUse_period() {
        return use_period;
    }

    public void setUse_period(Integer use_period) {
        this.use_period = use_period;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}