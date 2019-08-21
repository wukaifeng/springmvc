package com.banksteel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.banksteel.bean.User;

/**
 * 
 *   在以往我们需要SpringMVC为我们自动进行类型转换的时候都是用的PropertyEditor。通过PropertyEditor的setAsText()方法我们可以实现字符串向特定类型的转换。
 *   但是这里有一个限制是它只支持从String类型转为其他类型。在Spring3中引入了一个Converter接口，它支持从一个Object转为另一个Object。
 *   除了Converter接口之外，实现ConverterFactory接口和GenericConverter接口也可以实现我们自己的类型转换逻辑
 * @author wukaifeng
 *
 */
@Controller
public class ConverterController {

    @RequestMapping(value="/testConversionServiceConverer")
    public String testConverter(@RequestParam("user") User user){
        System.out.println("save: "+user);
        
        return "redirect:/hello";
    }

}
