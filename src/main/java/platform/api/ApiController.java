package platform.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platform.code.CodeEntity;
import platform.code.CodeRepo;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class ApiController {
    private final CodeRepo codeRepo;
    private final CodeService codeService;

    public ApiController(CodeRepo codeRepo, CodeService codeService) {
        this.codeRepo = codeRepo;
        this.codeService = codeService;
    }


    @GetMapping("/code/{id}")
    public ResponseEntity<?> getCode(@PathVariable Long id) {
        return new ResponseEntity<>(codeRepo.findById(id), HttpStatus.OK);
    }

    @GetMapping("/code/latest")
    public ResponseEntity<?> getCode() {
        List<CodeEntity> last10 = codeService.getLast10Codes();
        return new ResponseEntity<>(last10, HttpStatus.OK);
    }


    @PostMapping(value = "/code/new", consumes = "application/json")
    public ResponseEntity<?> newCode(@RequestBody CodeEntity code) {
        codeRepo.save(code);
        return new ResponseEntity<>(Map.of("id", String.valueOf(codeRepo.count())), HttpStatus.OK);
    }


}
