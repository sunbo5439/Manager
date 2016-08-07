package cn.pku.meizi.formatter;

import cn.pku.meizi.enumer.Gender;
import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by sunbo on 16/6/18.
 */
public class GenderFormatter implements Formatter<Gender> {
    @Override
    public Gender parse(String s, Locale locale) throws ParseException {
        return Gender.get(s);
    }

    @Override
    public String print(Gender gender, Locale locale) {
        return gender.getName();
    }
}
