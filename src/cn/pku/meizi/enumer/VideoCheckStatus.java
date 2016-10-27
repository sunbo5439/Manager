package cn.pku.meizi.enumer;

/**
 * Created by sunbo on 16/7/20.
 */
public enum VideoCheckStatus {
    unIssue("未发布"),
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

    public static VideoCheckStatus getFromInt(Integer type){
        VideoCheckStatus rs=null;
        switch (type){
            case 0:
                rs= VideoCheckStatus.unIssue;
                break;
            case 1:
                rs= VideoCheckStatus.unCheck;
                break;
            case 2:
                rs= VideoCheckStatus.legal;
                break;
            case 3:
                rs= VideoCheckStatus.illegal;
                break;
        }
        return rs;
    }
}
