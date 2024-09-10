package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.Job;

public interface JobRepository extends JpaRepository<Job,Long>{
    List<Job> findByEmployerId(Long employerId);
    List<Job> findByLocationAndJobType(String location, String jobType);
}
