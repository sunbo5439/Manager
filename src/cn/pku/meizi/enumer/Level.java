package cn.pku.meizi.enumer;

/**
 * Created by sunbo on 16/5/31.
 */
public enum Level {
    COMPANY("企业用户"),
    PERSON("个人用户"),
    GUEST("游客");


    private String name;

    private Level(String name){
        this.name=name;
    }


    public static Level get(String str) {
        for (Level e : values()) {
            if(e.name.equals(str)) {
                return e;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
