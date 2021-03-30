package com.mak.springbootemployermanagementapi.bootstrap;

import com.mak.springbootemployermanagementapi.EmployerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@Component
@Profile("default")
public class BootstrapInMem implements ApplicationListener<ContextRefreshedEvent> {

    private final EmployerRepository employerRepository;

    public BootstrapInMem(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("Loading Bootstrap Data");


    }
}
