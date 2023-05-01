package platform.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import platform.code.CodeEntity;
import platform.code.CodeRepo;
import platform.code.CodeService;

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
    public ResponseEntity<?> getCode(@PathVariable String id) {
        CodeEntity code = codeRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "no entity with id =" + id));
        return new ResponseEntity<>(code, HttpStatus.OK);
    }

    @GetMapping("/code/latest")
    public ResponseEntity<?> getCode() {
        List<CodeEntity> last10 = codeService.getLastNCodes(10);
        return new ResponseEntity<>(last10, HttpStatus.OK);
    }


    @PostMapping(value = "/code/new", consumes = "application/json")
    synchronized public ResponseEntity<?> newCode(@RequestBody CodeEntity code) {
        code = codeRepo.save(code);
        return new ResponseEntity<>(Map.of("id", code.getId()), HttpStatus.OK);
    }


}
