package platform.code;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeRepo extends JpaRepository<CodeEntity, Long> {
 List<CodeEntity> findFirst10ByIdAfterOrderByIdDesc(Long id);
}