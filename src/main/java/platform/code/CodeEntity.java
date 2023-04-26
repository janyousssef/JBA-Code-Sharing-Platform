package platform.code;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
public final class CodeEntity {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @CreatedDate
    @CreationTimestamp
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

