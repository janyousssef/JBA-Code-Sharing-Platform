package platform.code;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CodeRepo extends JpaRepository<CodeEntity, String> {
    List<CodeEntity> findTop10ByisLimitedAndCreationDateAfterOrderByCreationDateDesc(boolean limited, LocalDateTime creationDate);
}