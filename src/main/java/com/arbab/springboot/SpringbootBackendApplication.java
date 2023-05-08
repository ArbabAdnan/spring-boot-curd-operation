package com.arbab.springboot;

import com.arbab.springboot.model.Employee;
import com.arbab.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void run(String... args) throws Exception {
		Employee employee= new Employee();
		employee.setFirstname("arbab");
		employee.setLastname("adnan");
		employee.setEmailId("arbabadnan@gamil.com");
		employeeRepository.save(employee);

		Employee employee1= new Employee();
		employee1.setFirstname("arbab");
		employee1.setLastname("farhan");
		employee1.setEmailId("arbabfarhan@gamil.com");
		employeeRepository.save(employee1);

	}
}
