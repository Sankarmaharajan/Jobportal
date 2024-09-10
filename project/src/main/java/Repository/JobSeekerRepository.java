package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long>{
	JobSeeker findByEmail(String email);
}
