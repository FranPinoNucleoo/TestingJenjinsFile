package com.guide.rest;

import com.guide.rest.models.Employee;
import com.guide.rest.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.Commit;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest -- Is if we dont want an embedded DDBB to work with
@DataJpaTest
public class EmployeeControllerTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Commit // Save data for the tests
    @Test
    void testCreateEmployeeTest() {
        long countEmployeeFirst = employeeRepository.count();
        Employee employee = new Employee("Juan", "ADMIN");
        employeeRepository.save(employee);
        long countEmployeeAfter = employeeRepository.count();
        assertThat(countEmployeeFirst).isLessThan(countEmployeeAfter);
    }

//    @Commit //Commit save the data for the next test
//    @Test
//    void testCreateEmployeeTestCopia() {
//        long countEmployeeFirst = employeeRepository.count();
//        Employee employee = new Employee("Juan", "ADMIN");
//        employeeRepository.save(employee);
//        long countEmployeeAfter = employeeRepository.count();
//        assertThat(countEmployeeFirst).isLessThan(countEmployeeAfter);
//    }

}
