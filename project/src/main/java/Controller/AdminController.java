package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import Model.Admin;
import Service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	 @Autowired
	    private AdminService adminService;

	    @PostMapping("/register")
	    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
	        Admin savedAdmin = adminService.registerAdmin(admin);
	        return ResponseEntity.ok(savedAdmin);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
	        Admin admin = adminService.getAdminById(id);
	        return admin != null ? ResponseEntity.ok(admin) : ResponseEntity.notFound().build();
	    }

	    @GetMapping("/username/{username}")
	    public ResponseEntity<Admin> getAdminByUsername(@PathVariable String username) {
	        Admin admin = adminService.getAdminByUsername(username);
	        return admin != null ? ResponseEntity.ok(admin) : ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
	        adminService.deleteAdmin(id);
	        return ResponseEntity.noContent().build();
	    }
	
}
