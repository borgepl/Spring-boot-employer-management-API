package com.mak.springbootemployermanagementapi.bootstrap;

import com.mak.springbootemployermanagementapi.Employer;
import com.mak.springbootemployermanagementapi.EmployerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("test")
public class BootstrapMySQL implements ApplicationListener<ContextRefreshedEvent> {

    private final EmployerRepository employerRepository;

    public BootstrapMySQL(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (employerRepository.count() == 0L) {
            log.debug("Loading Employers");
            loadEmployers();
        }
    }

    private void loadEmployers() {
        //  'Willie', 'Bull', 15000
        Employer employer1 = new Employer();
        employer1.setFirstName("Willie");
        employer1.setLastName("Bull");
        employer1.setSalary(Double.valueOf(15000));
        employerRepository.save(employer1);

    }
}
