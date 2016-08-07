package cn.pku.meizi.enumer;

/**
 * Created by sunbo on 16/6/21.
 */
public enum PayType {
    wechat("微信支付"),
    zhifubao("支付宝支付"),
    payunion("银联支付");

    private String name;
    private PayType(String name){
        this.name=name;
    }


    public static PayType get(String str) {
        for (PayType e : values()) {
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
