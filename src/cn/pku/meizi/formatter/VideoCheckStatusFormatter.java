package cn.pku.meizi.formatter;

import cn.pku.meizi.enumer.VideoCheckStatus;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by sunbo on 16/7/20.
 */
public class VideoCheckStatusFormatter implements Formatter<VideoCheckStatus> {
    @Override
    public VideoCheckStatus parse(String s, Locale locale) throws ParseException {
        return VideoCheckStatus.get(s);
    }

    @Override
    public String print(VideoCheckStatus status, Locale locale) {
        return status.getName();
    }
}