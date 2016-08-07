package cn.pku.meizi.enumer;

/**
 * Created by sunbo on 16/6/2.
 */
public enum UserStatus {
    active("激活"),
    locked("锁定");


    private String name;

    private UserStatus(String name){
        this.name=name;
    }

    public static UserStatus get(String str) {
        for (UserStatus e : values()) {
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
