package platform.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platform.code.CodeEntity;
import platform.code.CodeRepo;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class ApiController {
    final CodeRepo codeRepo;

    public ApiController(CodeRepo codeRepo) {
        this.codeRepo = codeRepo;
    }


    @GetMapping("/code")
    public ResponseEntity<?> getCode() {
        return new ResponseEntity<>(codeRepo.getCode(), HttpStatus.OK);
    }

    @PostMapping(value = "/code/new", consumes = "application/json")
    public ResponseEntity<?> newCode(@RequestBody CodeEntity code) {
        codeRepo.setCode(code);
        return ResponseEntity.ok().build();
    }


}
