package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import Model.Employer;
import Service.EmployerService;

@RestController
public class EmployerController {

		@Autowired
		private EmployerService employerService;
		
		 @PostMapping("employer/register/")
		    public ResponseEntity<Employer> registerEmployer(@RequestBody Employer employer) {
		        Employer savedEmployer = employerService.registerEmployer(employer);
		        return ResponseEntity.ok(savedEmployer);
		    }

		    @GetMapping("/{id}")
		    public ResponseEntity<Employer> getEmployerById(@PathVariable Long id) {
		        Employer employer = employerService.getEmployerById(id);
		        return employer != null ? ResponseEntity.ok(employer) : ResponseEntity.notFound().build();
		    }

		    @GetMapping("/email/{email}")
		    public ResponseEntity<Employer> getEmployerByEmail(@PathVariable String email) {
		        Employer employer = employerService.getEmployerByEmail(email);
		        return employer != null ? ResponseEntity.ok(employer) : ResponseEntity.notFound().build();
		    }

		    @GetMapping
		    public ResponseEntity<List<Employer>> getAllEmployers() {
		        List<Employer> employers = employerService.getAllEmployers();
		        return ResponseEntity.ok(employers);
		    }

		    @DeleteMapping("/{id}")
		    public ResponseEntity<Void> deleteEmployer(@PathVariable Long id) {
		        employerService.deleteEmployer(id);
		        return ResponseEntity.noContent().build();
		    }
}
