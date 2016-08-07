package cn.pku.meizi.domain;

import javax.persistence.*;

/**
 * Created by sunbo on 16/8/2.
 */
@Entity
@Table(name = "tps_province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PROVINCE_ID;
    private int PROVINCE_CODE;
    private String PROVINCE_NAME;

    public Province(){

    }

    public Province(int PROVINCE_CODE, String PROVINCE_NAME) {
        this.PROVINCE_CODE = PROVINCE_CODE;
        this.PROVINCE_NAME = PROVINCE_NAME;
    }

    public int getPROVINCE_ID() {
        return PROVINCE_ID;
    }

    public void setPROVINCE_ID(int PROVINCE_ID) {
        this.PROVINCE_ID = PROVINCE_ID;
    }

    public int getPROVINCE_CODE() {
        return PROVINCE_CODE;
    }

    public void setPROVINCE_CODE(int PROVINCE_CODE) {
        this.PROVINCE_CODE = PROVINCE_CODE;
    }

    public String getPROVINCE_NAME() {
        return PROVINCE_NAME;
    }

    public void setPROVINCE_NAME(String PROVINCE_NAME) {
        this.PROVINCE_NAME = PROVINCE_NAME;
    }
}
