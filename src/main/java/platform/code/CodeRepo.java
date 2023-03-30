package platform.code;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Repository
public class CodeRepo {
    private CodeEntity code = new CodeEntity("public static void main(String[] args) {}", getDate());

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