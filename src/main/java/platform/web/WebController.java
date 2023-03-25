package platform.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

@Controller
@RequestMapping(path = "/",produces = "text/html")
public class WebController {
    @GetMapping("/code")
    public String hello(){
        return "code.html";
    }
}
