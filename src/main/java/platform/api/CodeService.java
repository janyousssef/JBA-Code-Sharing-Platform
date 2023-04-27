package platform.api;

import org.springframework.stereotype.Service;
import platform.code.CodeEntity;
import platform.code.CodeRepo;

import java.util.Collections;
import java.util.List;
@Service
public class CodeService {
    private final CodeRepo codeRepo;
    public CodeService(CodeRepo codeRepo) {
        this.codeRepo = codeRepo;
    }

    public List<CodeEntity> getLast10Codes() {
        List<CodeEntity> codes = codeRepo.findAll();
        Collections.reverse(codes);
        return codes.subList(0, Math.min(codes.size(), 10));
    }
}