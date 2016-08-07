package cn.pku.meizi.domain;

import cn.pku.meizi.enumer.OrderStatus;
import cn.pku.meizi.enumer.PayType;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunbo on 16/6/21.
 */

@Entity
@Table(name = "tps_order")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String uuid;   //订单编号
    private Date cDate;
    private Date mDate;
    private Integer  invoice_id;  //发票信息,抬头之类的
    private Integer status;   //购物车的状态  清空  结算
    private Float price;
    private PayType pay_type;      //
    private Integer valid_day;     //天数
    private String comment;
    @ManyToOne(targetEntity = User.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;


    public Order(){}

    public Order(String uuid, Date cDate, Date mDate, Integer invoice_id, Integer status, Float price, PayType pay_type, Integer valid_day, String comment,  User user) {
        this.uuid = uuid;
        this.cDate = cDate;
        this.mDate = mDate;
        this.invoice_id = invoice_id;
        this.status = status;
        this.price = price;
        this.pay_type = pay_type;
        this.valid_day = valid_day;
        this.comment = comment;
        //this.orderItems = orderItems;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public Integer getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Integer invoice_id) {
        this.invoice_id = invoice_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public PayType getPay_type() {
        return pay_type;
    }

    public void setPay_type(PayType pay_type) {
        this.pay_type = pay_type;
    }

    public Integer getValid_day() {
        return valid_day;
    }

    public void setValid_day(Integer valid_day) {
        this.valid_day = valid_day;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void update(Order order){
        if (order.uuid!=null)
            this.uuid = order.uuid;
        if(order.cDate!=null)
            this.cDate = order.cDate;
        if(order.mDate!=null)
            this.mDate = order.mDate;
        if(order.invoice_id!=null)
            this.invoice_id = order.invoice_id;
        if(order.status!=null)
            this.status = order.status;
        if(order.price!=null)
            this.price = order.price;
        if(order.pay_type!=null)
            this.pay_type = order.pay_type;
        if(order.valid_day!=null)
            this.valid_day = order.valid_day;
        if(order.user!=null)
            this.user = order.user;
        if(order.comment!=null)
            this.comment=order.comment;
    }


}
