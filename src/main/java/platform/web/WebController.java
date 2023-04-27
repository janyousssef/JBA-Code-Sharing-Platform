package platform.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import platform.code.CodeService;
import platform.code.CodeEntity;
import platform.code.CodeRepo;

import java.util.List;

@Controller
@RequestMapping(path = "/", produces = "text/html")
public class WebController {
    private final CodeRepo codeRepo;
    private final CodeService codeService;

    public WebController(CodeRepo codeRepo, CodeService codeService) {
        this.codeRepo = codeRepo;
        this.codeService = codeService;
    }

    @GetMapping("/code/{id}")
    public ModelAndView getCode(@PathVariable Long id) {
        CodeEntity codeSnippet = codeRepo.findById(id).get();
        ModelAndView mv = new ModelAndView();
        mv.addObject("code", codeSnippet);
        mv.setViewName("code");
        return mv;
    }

    @GetMapping("/code/new")
    public ModelAndView newCode() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("create");
        return mv;
    }
    @GetMapping("/code/latest")
    public ModelAndView viewLatestCodes() {
        ModelAndView mv = new ModelAndView();
        List<CodeEntity> lastCodes = codeService.getLast10Codes();
        mv.addObject("codes", lastCodes);
        mv.setViewName("latest_codes");
        return mv;
    }

}
