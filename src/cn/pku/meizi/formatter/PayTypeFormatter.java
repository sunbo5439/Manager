package cn.pku.meizi.formatter;

import cn.pku.meizi.enumer.PayType;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by sunbo on 16/6/24.
 */
public class PayTypeFormatter implements Formatter<PayType> {
    @Override
    public PayType parse(String s, Locale locale) throws ParseException {
        return PayType.get(s);
    }

    @Override
    public String print(PayType payType, Locale locale) {
        return payType.getName();
    }
}
