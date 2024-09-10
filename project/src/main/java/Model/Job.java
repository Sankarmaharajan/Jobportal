package Model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String description;
	private String location;
	private String jobType;
	private String requiredSkills;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	
	@ManyToMany
    @JoinTable(
        name = "job_applications",
        joinColumns = @JoinColumn(name = "job_id"),
        inverseJoinColumns = @JoinColumn(name = "job_seeker_id")
    )
    private List<JobSeeker> applicants;


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getJobType() {
		return jobType;
	}


	public void setJobType(String jobType) {
		this.jobType = jobType;
	}


	public String getRequiredSkills() {
		return requiredSkills;
	}


	public void setRequiredSkills(String requiredSkills) {
		this.requiredSkills = requiredSkills;
	}


	public Employer getEmployer() {
		return employer;
	}


	public void setEmployer(Employer employer) {
		this.employer = employer;
	}


	public List<JobSeeker> getApplicants() {
		return applicants;
	}


	public void setApplicants(List<JobSeeker> applicants) {
		this.applicants = applicants;
	}
	
	
}
