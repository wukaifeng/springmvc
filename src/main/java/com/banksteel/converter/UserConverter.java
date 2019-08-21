package com.banksteel.converter;

import org.springframework.core.convert.converter.Converter;
import com.banksteel.bean.User;

/**
 * 类型转换器
 * @author wukaifeng
 *
 */
public class UserConverter implements Converter<String, User> {

    public User convert(String source) {
        if (source != null) {
            String[] vals = source.split("-");
            if (vals != null && vals.length == 3) {
                String userName = vals[0];
                Integer age = Integer.parseInt(vals[1]);
                Double salary = Double.parseDouble(vals[2]);
                User user = new User(userName, age, salary);

                System.out.println(source + "-convert-" + user);
                return user;
            }
        }
        return null;
    }

}
