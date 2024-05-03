package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@EnableTransactionManagement
@SpringBootApplication
public class BookStoreApplication {

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    @Transactional
    public CommandLineRunner initData() {
        return args -> {
            Book book1 = new Book("Тестова книга 1", "Автор 1", "1234567890",
                    BigDecimal.valueOf(19.99), "Опис 1", "cover1.jpg");
            Book book2 = new Book("Тестова книга 2", "Автор 2", "0987654321",
                    BigDecimal.valueOf(29.99), "Опис 2", "cover2.jpg");
            bookRepository.save(book1);
            bookRepository.save(book2);
            bookRepository.findAll().forEach(System.out::println);
        };
    }
}
