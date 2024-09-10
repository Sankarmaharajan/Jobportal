package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.Employer;

public interface EmployerRepository  extends JpaRepository<Employer,Long>{
	Employer findByEmail(String email);
}
