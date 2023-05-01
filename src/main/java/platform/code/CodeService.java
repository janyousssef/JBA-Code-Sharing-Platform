package platform.code;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Optional<CodeEntity> getCodeIfNotExpired(String id) {
        Optional<CodeEntity> code = codeRepo.findById(id);
        if (code.isEmpty()) {
            return Optional.empty();
        }

        CodeEntity codeEntity = code.get();
        if (!codeEntity.isStillValid()) {
            codeRepo.delete(codeEntity);
            return Optional.empty();
        }
        codeEntity.decrementViews();
        return Optional.of(codeRepo.save(codeEntity));
    }
}
