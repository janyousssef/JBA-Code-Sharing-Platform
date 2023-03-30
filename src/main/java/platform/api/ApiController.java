package platform.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
        return new ResponseEntity<>(new ReallyJBA(),HttpStatus.OK);
    }
    //I am forced to use this class because I need a JSON response to look like this ->'{}' not like this ''
    @JsonSerialize
    class ReallyJBA {

    }

}
