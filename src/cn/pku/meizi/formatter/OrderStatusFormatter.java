package cn.pku.meizi.formatter;

import cn.pku.meizi.enumer.OrderStatus;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by sunbo on 16/6/24.
 */
public class OrderStatusFormatter implements Formatter<OrderStatus> {
    @Override
    public OrderStatus parse(String s, Locale locale) throws ParseException {
        return OrderStatus.get(s);
    }

    @Override
    public String print(OrderStatus orderStatus, Locale locale) {
        return orderStatus.getName();
    }
}
