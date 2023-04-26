package platform.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platform.code.CodeEntity;
import platform.code.CodeRepo;

import java.util.Map;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class ApiController {
    final CodeRepo codeRepo;

    public ApiController(CodeRepo codeRepo) {
        this.codeRepo = codeRepo;
    }


    @GetMapping("/code/{id}")
    public ResponseEntity<?> getCode(@PathVariable Long id) {
        return new ResponseEntity<>(codeRepo.findById(id), HttpStatus.OK);
    }

//    @GetMapping("/code/latest")
//    public ResponseEntity<?> getCode() {
//        return new ResponseEntity<>(codeRepo.getLastCodes(10), HttpStatus.OK);
//    }

    @PostMapping(value = "/code/new", consumes = "application/json")
    public ResponseEntity<?> newCode(@RequestBody CodeEntity code) {
        codeRepo.save(code);
        return new ResponseEntity<>(Map.of("id", String.valueOf(codeRepo.count())), HttpStatus.OK);
    }


}
