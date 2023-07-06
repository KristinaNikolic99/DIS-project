package identityservice.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import identityservice.model.UserCredential;

@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredential, Long>{

	Optional<UserCredential> findByName(String username);
}
