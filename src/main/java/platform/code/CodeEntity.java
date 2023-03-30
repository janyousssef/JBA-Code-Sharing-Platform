package platform.code;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record CodeEntity(String code, @JsonProperty("date") String creationDate) {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Generates a new CodeEntity with the creation date set to LocalDateTime.now()
     *
     * @param code the code snippet
     */
    public CodeEntity(String code) {
        this(code, LocalDateTime.now().format(formatter));
    }
}

