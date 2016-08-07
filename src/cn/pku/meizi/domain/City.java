package cn.pku.meizi.domain;

import javax.persistence.*;

/**
 * Created by sunbo on 16/8/2.
 */
@Entity
@Table(name = "tps_city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CITY_ID;
    private int CITY_CODE;
    private String CITY_NAME;
    private int CITY_FATHER_CODE;

    public City(){
    }

    public City(int CITY_CODE, String CITY_NAME, int CITY_FATHER_CODE) {
        this.CITY_CODE = CITY_CODE;
        this.CITY_NAME = CITY_NAME;
        this.CITY_FATHER_CODE = CITY_FATHER_CODE;
    }

    public int getCITY_ID() {
        return CITY_ID;
    }

    public void setCITY_ID(int CITY_ID) {
        this.CITY_ID = CITY_ID;
    }

    public int getCITY_CODE() {
        return CITY_CODE;
    }

    public void setCITY_CODE(int CITY_CODE) {
        this.CITY_CODE = CITY_CODE;
    }

    public String getCITY_NAME() {
        return CITY_NAME;
    }

    public void setCITY_NAME(String CITY_NAME) {
        this.CITY_NAME = CITY_NAME;
    }

    public int getCITY_FATHER_CODE() {
        return CITY_FATHER_CODE;
    }

    public void setCITY_FATHER_CODE(int CITY_FATHER_CODE) {
        this.CITY_FATHER_CODE = CITY_FATHER_CODE;
    }
}
