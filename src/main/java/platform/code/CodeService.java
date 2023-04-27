package platform.code;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeService {
    private final CodeRepo codeRepo;

    public CodeService(CodeRepo codeRepo) {
        this.codeRepo = codeRepo;
    }

    public List<CodeEntity> getLast10Codes() {
        return codeRepo.findFirst10ByIdAfterOrderByIdDesc(0L);

    }
}