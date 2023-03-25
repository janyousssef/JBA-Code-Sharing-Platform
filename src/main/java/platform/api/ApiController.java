package platform.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import platform.code.CodeEntity;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class ApiController {
    @GetMapping("/code")
    public ResponseEntity<?> getCode() {
        CodeEntity codeSnippet = new CodeEntity("public static void main(String[] args) {}");
        return new ResponseEntity<>(codeSnippet, HttpStatus.OK);
    }


}
