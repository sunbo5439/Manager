package cn.pku.meizi.enumer;

import cn.pku.meizi.service.OrderService;

/**
 * Created by sunbo on 16/6/21.
 */
public enum OrderStatus {
    DELETE("删除",-2),
    CANCEL("取消",-1),
    GENERATE("已生成",1),
    PAYED("已支付",2),
    APPLYINVOICE("已生成发票",3),
    ISSUEINVOICE("发票已开",4);

    private String name;
    private int value ;
    private OrderStatus(String name,int value){
        this.value=value;
        this.name=name;
    }

    public static OrderStatus valueOf(int value) {
        switch (value){
            case -2:return DELETE;
            case -1:return CANCEL;
            case 1:return GENERATE;
            case 2:return PAYED;
            case 3:return APPLYINVOICE;
            case 4:return ISSUEINVOICE;
            default:return null;
        }
    }

    public static OrderStatus get(String str) {
        for (OrderStatus e : values()) {
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
