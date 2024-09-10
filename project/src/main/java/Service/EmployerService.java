package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.Employer;
import Repository.EmployerRepository;

@Service
public class EmployerService {
	
	@Autowired
	private EmployerRepository employerRepository;
	
	public Employer registerEmployer(Employer employer) {
        return employerRepository.save(employer);
    }

    public Employer getEmployerById(Long id) {
        return employerRepository.findById(id).orElse(null);
    }

    public Employer getEmployerByEmail(String email) {
        return employerRepository.findByEmail(email);
    }

    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    public void deleteEmployer(Long id) {
        employerRepository.deleteById(id);
    }
	
}
