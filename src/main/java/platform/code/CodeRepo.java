package platform.code;

import org.springframework.stereotype.Repository;

@Repository
public class CodeRepo {
    private final String initialCode = "public static void main(String[] args) {}";
    private CodeEntity code;

    public CodeRepo() {
        code = new CodeEntity(initialCode);
    }

    public CodeEntity getCode() {
        return code;
    }

    public void setCode(CodeEntity code) {
        this.code = code;
    }
}