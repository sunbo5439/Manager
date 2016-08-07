package cn.pku.meizi.enumer;


/**
 * Created by sunbo on 16/6/18.
 */
public enum Gender {
    MEN("男"),
    WOMEN("女");
    private String name;

    private Gender(String name){
        this.name=name;
    }

    public static Gender get(String str){
        for (Gender e : values()) {
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
