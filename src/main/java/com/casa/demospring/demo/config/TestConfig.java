package com.casa.demospring.demo.config;

import com.casa.demospring.demo.entities.Category;
import com.casa.demospring.demo.entities.Order;
import com.casa.demospring.demo.entities.Product;
import com.casa.demospring.demo.entities.User;
import com.casa.demospring.demo.entities.enums.OrderStatus;
import com.casa.demospring.demo.repositories.CategoryRepository;
import com.casa.demospring.demo.repositories.OrderRepository;
import com.casa.demospring.demo.repositories.ProductRepository;
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
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    TestConfig(UserRepository userRepository,
               OrderRepository orderRepository,
               CategoryRepository categoryRepository,
               ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Joao", "joao@joao.com", "999999999","2344");
        User user2 = new User(null, "Vitor", "vitor@joao.com", "98989898","35678");
        User user3 = new User(null, "Carlos", "carlos@joao.com", "2222222","45778");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        //Order
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.CANCELED, user1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, user2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user3);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        //Category
        Category cat1 = new Category(null, "Books");
        Category cat2 = new Category(null, "Electronics");

        categoryRepository.save(cat1);
        categoryRepository.save(cat2);

        //Product
        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    }
}
