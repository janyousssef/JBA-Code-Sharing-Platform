package platform.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import platform.code.CodeEntity;
import platform.code.CodeRepo;

@Controller
@RequestMapping(path = "/", produces = "text/html")
public class WebController {
    final CodeRepo codeRepo;

    public WebController(CodeRepo codeRepo) {
        this.codeRepo = codeRepo;
    }

    @GetMapping("/code")
    public ModelAndView getCode() {
        CodeEntity codeSnippet = codeRepo.getCode();
        ModelAndView mv = new ModelAndView();
        mv.addObject("codeEntity", codeSnippet);
        mv.setViewName("code");
        return mv;
    }

    @GetMapping("/code/new")
    public ModelAndView newCode() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("create");
        return mv;
    }

}
