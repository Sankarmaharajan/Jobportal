package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.Admin;

public interface AdminRepository  extends JpaRepository<Admin,Long>{
	Admin findByUsername(String username);
}
