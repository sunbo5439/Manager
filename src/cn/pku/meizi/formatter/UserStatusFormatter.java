package cn.pku.meizi.formatter;

import cn.pku.meizi.enumer.UserStatus;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by sunbo on 16/6/4.
 */
public class UserStatusFormatter implements Formatter<UserStatus>  {
    @Override
    public UserStatus parse(String s, Locale locale) throws ParseException {
        return UserStatus.get(s);
    }

    @Override
    public String print(UserStatus status, Locale locale) {
        return status.getName();
    }
}
