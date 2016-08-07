package cn.pku.meizi.enumer;

/**
 * Created by sunbo on 16/7/20.
 */
public enum VideoCheckStatus {
    unCheck("未审核"),
    legal("通过"),
    illegal("未通过");

    private String name;

    private VideoCheckStatus(String name){
        this.name=name;
    }

    public static VideoCheckStatus get(String str) {
        for (VideoCheckStatus e : values()) {
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

    public static VideoCheckStatus getFromInt(Integer integer){
        if(integer==0) return VideoCheckStatus.unCheck;
        else if(integer==1) return VideoCheckStatus.legal;
        else return VideoCheckStatus.illegal;
    }
}
