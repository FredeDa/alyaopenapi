package fr.alya.alyaopenapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.alya.alyaopenapi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
