package platform.code;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Repository
public class CodeRepo {
    String initialCode = "public static void main(String[] args) {}";
    private CodeEntity code = new CodeEntity(initialCode, getDate());

    public CodeRepo() {
    }

    private static String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    public CodeEntity getCode() {
        return code;
    }

    public void setCode(CodeEntity code) {
        this.code = code;
    }
}