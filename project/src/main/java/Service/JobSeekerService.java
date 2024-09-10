package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.JobSeeker;
import Repository.JobSeekerRepository;

@Service
public class JobSeekerService {
	
	@Autowired
	private JobSeekerRepository jobSeekerRepository;
	
	public JobSeeker registerJobSeeker(JobSeeker jobSeeker) {
        return jobSeekerRepository.save(jobSeeker);
    }

    public JobSeeker getJobSeekerById(Long id) {
        return jobSeekerRepository.findById(id).orElse(null);
    }

    public JobSeeker getJobSeekerByEmail(String email) {
        return jobSeekerRepository.findByEmail(email);
    }

    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerRepository.findAll();
    }

    public void deleteJobSeeker(Long id) {
        jobSeekerRepository.deleteById(id);
    }
	
}
