package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import Model.JobSeeker;
import Service.JobSeekerService;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {

    @Autowired
    private JobSeekerService jobSeekerService;

    @PostMapping("/register")
    public ResponseEntity<JobSeeker> registerJobSeeker(@RequestBody JobSeeker jobSeeker) {
        JobSeeker savedJobSeeker = jobSeekerService.registerJobSeeker(jobSeeker);
        return ResponseEntity.ok(savedJobSeeker);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobSeeker> getJobSeekerById(@PathVariable Long id) {
        JobSeeker jobSeeker = jobSeekerService.getJobSeekerById(id);
        return jobSeeker != null ? ResponseEntity.ok(jobSeeker) : ResponseEntity.notFound().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<JobSeeker> getJobSeekerByEmail(@PathVariable String email) {
        JobSeeker jobSeeker = jobSeekerService.getJobSeekerByEmail(email);
        return jobSeeker != null ? ResponseEntity.ok(jobSeeker) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<JobSeeker>> getAllJobSeekers() {
        List<JobSeeker> jobSeekers = jobSeekerService.getAllJobSeekers();
        return ResponseEntity.ok(jobSeekers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobSeeker(@PathVariable Long id) {
        jobSeekerService.deleteJobSeeker(id);
        return ResponseEntity.noContent().build();
    }
}
