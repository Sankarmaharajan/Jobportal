package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.Job;
import Repository.JobRepository;

@Service
public class JobService {
	@Autowired
    private JobRepository jobRepository;

    public Job postJob(Job job) {
        return jobRepository.save(job);
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    public List<Job> getJobsByEmployerId(Long employerId) {
        return jobRepository.findByEmployerId(employerId);
    }

    public List<Job> getJobsByLocationAndType(String location, String jobType) {
        return jobRepository.findByLocationAndJobType(location, jobType);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
