package cn.pku.meizi.domain;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sunbo on 16/5/26.
 */
@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String password;
    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role_id",nullable = false)
    @Cascade(CascadeType.DETACH)
    private Role role;

    public Manager(){
    }

    public Manager(String name, String password, Role role) {
        this.name=name;
        this.password=password;
        this.role=role;
    }

    public int getId(){return id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
