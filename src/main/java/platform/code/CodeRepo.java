package platform.code;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.max;

@Repository
public class CodeRepo {
    private final ArrayList<CodeEntity> codes = new ArrayList<>();

    public CodeRepo() {
    }

    public CodeEntity getLastCode() {
        return codes.get(codes.size() - 1);
    }

    public List<CodeEntity> getLastCodes(int n) {
        //sublist creates a view of the list, so we need to create a mutable copy to avoid modifying the original list
        List<CodeEntity> lastNCodes = codes.subList(max(0, codes.size() - n), codes.size());
        List<CodeEntity> mutableList = new ArrayList<>(lastNCodes);
        Collections.reverse((mutableList));
        return mutableList;
    }

    public CodeEntity findCodeById(int id) {
        return codes.get(id - 1);
    }

    public void addCode(CodeEntity code) {
        codes.add(code);
    }
}