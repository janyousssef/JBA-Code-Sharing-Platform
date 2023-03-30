package platform.code;

import org.springframework.stereotype.Repository;

@Repository
public class CodeRepo {
    private final String initialCode = "public static void main(String[] args) {}";
    private CodeEntity code = new CodeEntity(initialCode);

    public CodeRepo() {
    }

    public CodeEntity getCode() {
        return code;
    }

    public void setCode(CodeEntity code) {
        this.code = code;
    }
}