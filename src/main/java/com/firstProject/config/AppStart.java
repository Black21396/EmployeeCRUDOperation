package com.firstProject.config;

import com.firstProject.model.Employee;
import com.firstProject.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppStart implements CommandLineRunner {

    private final EmployeeService employeeService;
    @Override
    public void run(String... args) throws Exception {

        if(employeeService.getAllEmployees().isEmpty()){

            employeeService.saveEmployee
                    (new Employee(0,
                            "fadi",
                            "salameh",
                            "fadi@gmail.com"));
            employeeService.saveEmployee
                    (new Employee(0,
                            "eman",
                            "salameh",
                            "eman@gmail.com"));
            employeeService.saveEmployee
                    (new Employee(0,
                            "nada",
                            "alhaj",
                            "nada@gmail.com"));
        }
    }
}
