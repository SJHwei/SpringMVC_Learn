package cn.itcast.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ShiWei
 * @date 2021/4/13 - 21:36
 * <p>
 * 把字符串转换成日期
 */
public class StringToDateConverter implements Converter<String, Date> {
    /**
     * @param source 传进来的字符串
     * @return
     */
    @Override
    public Date convert(String source) {
        //判断
        if (source == null) {
            throw new RuntimeException("请您传入数据");
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //把字符串转换成日期
            return df.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换出现错误");
        }
    }
}
