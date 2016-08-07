package cn.pku.meizi.domain;

import javax.persistence.*;

/**
 * Created by sunbo on 16/8/2.
 */
@Entity
@Table(name = "tps_area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AREA_ID;
    private int AREA_CODE;
    private String AREA_NAME;
    private int AREA_FATHER_CODE;

    public Area(){

    }
    public Area(int AREA_CODE, String AREA_NAME, int AREA_FATHER_CODE) {
        this.AREA_CODE = AREA_CODE;
        this.AREA_NAME = AREA_NAME;
        this.AREA_FATHER_CODE = AREA_FATHER_CODE;
    }

    public int getAREA_ID() {
        return AREA_ID;
    }

    public void setAREA_ID(int AREA_ID) {
        this.AREA_ID = AREA_ID;
    }

    public int getAREA_CODE() {
        return AREA_CODE;
    }

    public void setAREA_CODE(int AREA_CODE) {
        this.AREA_CODE = AREA_CODE;
    }

    public String getAREA_NAME() {
        return AREA_NAME;
    }

    public void setAREA_NAME(String AREA_NAME) {
        this.AREA_NAME = AREA_NAME;
    }

    public int getAREA_FATHER_CODE() {
        return AREA_FATHER_CODE;
    }

    public void setAREA_FATHER_CODE(int AREA_FATHER_CODE) {
        this.AREA_FATHER_CODE = AREA_FATHER_CODE;
    }
}
