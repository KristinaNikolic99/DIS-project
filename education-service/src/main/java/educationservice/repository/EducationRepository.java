package educationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import educationservice.model.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long>{

}
