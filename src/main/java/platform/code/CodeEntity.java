package platform.code;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
public final class CodeEntity {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 1000)
    private String code;
    @CreationTimestamp
    @JsonProperty("date")
    private LocalDateTime creationDate;

    /**
     * Generates a new CodeEntity with the creation date set to LocalDateTime.now()
     *
     * @param code         the code snippet
     * @param creationDate the date the code was created
     */
    public CodeEntity(String code, LocalDateTime creationDate) {
        this.code = code;
        this.creationDate = creationDate == null ? LocalDateTime.now() : creationDate;
    }

    public CodeEntity() {

    }
    @JsonIgnore
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeEntity that = (CodeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(code, that.code) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, creationDate);
    }

    @Override
    public String toString() {
        return "CodeEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}

