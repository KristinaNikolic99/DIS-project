package healthcardservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import healthcardservice.model.Healthcard;

@Repository
public interface HealthcardRepository extends JpaRepository<Healthcard, Long> {

}
