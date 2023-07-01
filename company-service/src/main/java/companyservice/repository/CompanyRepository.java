package companyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import companyservice.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

}
