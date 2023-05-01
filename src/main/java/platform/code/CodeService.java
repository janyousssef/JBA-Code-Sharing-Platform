package platform.code;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeService {
    private final CodeRepo codeRepo;

    public CodeService(CodeRepo codeRepo) {
        this.codeRepo = codeRepo;
    }

    public List<CodeEntity> getLastNCodes(int n) {
        Pageable pageable = PageRequest.of((int) Math.max(0,((codeRepo.count() / n) - 1)),
            n,
            Sort.by(Sort.Direction.DESC,
                    "id"));

        return codeRepo.findAll(pageable)
                .toList();

    }
}