package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/test")
public class TestController {
    @RequestMapping(value = "/shan/", method = RequestMethod.POST)
    public String test() {
        return "ss";
    }
}
