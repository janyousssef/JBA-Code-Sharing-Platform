package platform.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import platform.code.CodeEntity;

@Controller
@RequestMapping(path = "/",produces = "text/html")
public class WebController {
    @GetMapping("/code")
    public ModelAndView getCode(){
        CodeEntity codeSnippet = new CodeEntity("public static void main(String[] args) {}");
        ModelAndView mv = new ModelAndView();
        mv.addObject("codeEntity",codeSnippet);
        mv.setViewName("code");
        return mv;
    }
}
