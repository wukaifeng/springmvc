package com.banksteel.converter;

import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
import com.banksteel.bean.User;

/**
 * 类型转换器
 * @author wukaifeng
 *
 */
public class UserFormatter implements Formatter<User> {

    public String print(User object, Locale locale) {
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbb");
        return null;
    }

    public User parse(String text, Locale locale) throws ParseException {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
        return new User();
    }
    
    
}
