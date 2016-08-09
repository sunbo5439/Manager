package cn.pku.meizi.domain;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.pku.meizi.enumer.*;
import com.sun.istack.internal.Nullable;
import org.hibernate.annotations.*;

/**
 * Created by sunbo on 16/5/31.
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username")
    private String userName;
    private String password;
    @Enumerated(EnumType.ORDINAL)
    private UserStatus status;
    private Date cDate;
    private Date mDate;
    private String email;
    private String mobile;
    private String company;
    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role",nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private Role role;
    @ManyToOne(targetEntity = Province.class)
    @JoinColumn(name = "province_code",nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private Province province_code;
    @ManyToOne(targetEntity = City.class)
    @JoinColumn(name = "city_code",nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private City city_code;
    @ManyToOne(targetEntity = Area.class)
    @JoinColumn(name = "area_code",nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private Area area_code;
    private String address;
    private String qq;
    private String realname;
    private Integer vendor_id;
    private String id_card_no;
    private Integer username_change_times;
    private boolean email_activated;
    private boolean mobile_activated;

    public User(){
        cDate=new Date();
        mDate=new Date();
    }

    public User(String userName, String password, UserStatus status, Date cDate, Date mDate, String email, String mobile, String company, Role role, Province province_code, City city_code, Area area_code, String address, String qq, String realname, Integer vendor_id, String id_card_no, Integer username_change_times, boolean email_activated, boolean mobile_activated) {
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.cDate = cDate;
        this.mDate = mDate;
        this.email = email;
        this.mobile = mobile;
        this.company = company;
        this.role = role;
        this.province_code = province_code;
        this.city_code = city_code;
        this.area_code = area_code;
        this.address = address;
        this.qq = qq;
        this.realname = realname;
        this.vendor_id = vendor_id;
        this.id_card_no = id_card_no;
        this.username_change_times = username_change_times;
        this.email_activated = email_activated;
        this.mobile_activated = mobile_activated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Province getProvince_code() {
        return province_code;
    }

    public void setProvince_code(Province province_code) {
        this.province_code = province_code;
    }

    public City getCity_code() {
        return city_code;
    }

    public void setCity_code(City city_code) {
        this.city_code = city_code;
    }

    public Area getArea_code() {
        return area_code;
    }

    public void setArea_code(Area area_code) {
        this.area_code = area_code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(Integer vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getId_card_no() {
        return id_card_no;
    }

    public void setId_card_no(String id_card_no) {
        this.id_card_no = id_card_no;
    }

    public Integer getUsername_change_times() {
        return username_change_times;
    }

    public void setUsername_change_times(Integer username_change_times) {
        this.username_change_times = username_change_times;
    }

    public boolean isEmail_activated() {
        return email_activated;
    }

    public void setEmail_activated(boolean email_activated) {
        this.email_activated = email_activated;
    }

    public boolean isMobile_activated() {
        return mobile_activated;
    }

    public void setMobile_activated(boolean mobile_activated) {
        this.mobile_activated = mobile_activated;
    }
}
