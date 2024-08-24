package com.casa.demospring.demo.config;

import com.casa.demospring.demo.entities.User;
import com.casa.demospring.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Joao", "joao@joao.com", "999999999","2344");
        User user2 = new User(null, "Vitor", "vitor@joao.com", "98989898","45678");

        userRepository.save(user1);
        userRepository.save(user2);
    }
}
