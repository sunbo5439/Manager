package cn.pku.meizi.formatter;

import cn.pku.meizi.enumer.Level;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by sunbo on 16/6/4.
 */
public class LevelFormatter implements Formatter<Level> {

    @Override
    public Level parse(String s, Locale locale) throws ParseException {
        return Level.get(s);
    }

    @Override
    public String print(Level level, Locale locale) {
        return level.getName();
    }
}
