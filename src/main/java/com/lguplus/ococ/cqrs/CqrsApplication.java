package com.lguplus.ococ.cqrs;

import com.lguplus.ococ.cqrs.model.OrgEntity;
import com.lguplus.ococ.cqrs.model.OrgEntityHelper;
import com.lguplus.ococ.cqrs.model.UserEntity;
import com.lguplus.ococ.cqrs.model.UserEntityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CqrsApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrgRepository orgRepository;

    public static void main(String[] args) {
        SpringApplication.run(CqrsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<UserEntity> userEntityList = userRepository.findAll();
        System.out.println(UserEntityHelper.toDomains(userEntityList));
        System.out.println("--------------------------");
        List<OrgEntity> orgEntityList = orgRepository.findAll();
        System.out.println(OrgEntityHelper.toDomains(orgEntityList));
    }
}
