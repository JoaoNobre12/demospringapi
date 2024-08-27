package com.casa.demospring.demo.config;

import com.casa.demospring.demo.entities.Order;
import com.casa.demospring.demo.entities.User;
import com.casa.demospring.demo.entities.enums.OrderStatus;
import com.casa.demospring.demo.repositories.OrderRepository;
import com.casa.demospring.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Autowired
    TestConfig(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Joao", "joao@joao.com", "999999999","2344");
        User user2 = new User(null, "Vitor", "vitor@joao.com", "98989898","35678");
        User user3 = new User(null, "Carlos", "carlos@joao.com", "2222222","45778");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.CANCELED, user1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, user2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user3);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
