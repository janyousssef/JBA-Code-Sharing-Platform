package platform.code;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CodeService {
    private final CodeRepo codeRepo;

    public CodeService(CodeRepo codeRepo) {
        this.codeRepo = codeRepo;
    }

    public List<CodeEntity> getLast10Codes() {

        return codeRepo.findTop10ByisLimitedAndCreationDateAfterOrderByCreationDateDesc(false,
                LocalDateTime.of(2000, 1, 1, 1, 1));
    }
}