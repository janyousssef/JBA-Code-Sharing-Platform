package platform.code;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.max;

@Repository
public interface CodeRepo extends JpaRepository<CodeEntity, Long> {

}