package fi.haagahelia.ohte.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.ohte.bookstore.domain.Book;
import fi.haagahelia.ohte.bookstore.domain.BookRepository;
import fi.haagahelia.ohte.bookstore.domain.User;
import fi.haagahelia.ohte.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, UserRepository userRepository) {
		return (args) -> {

			log.info("Add some books");
			bookRepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 10));
			bookRepository.save(new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 12));	

			log.info("Add normal user and admin user (passwords are also user and admin)");
			User user = new User("user", "$2a$10$AgqNUgRtE4bgj5g1.dnoB.CZ.ikGtAe34OQDwQcTlTfHCDgSc9IWO", "USER", "user@example.com");
			User admin = new User("admin", "$2a$10$Xps4BMNnQvlNV/UfXps35eGUDLqQdjM/fkwrrRCYTzPwFtY4Fxy52", "ADMIN", "admin@example.com");
			userRepository.save(user);
			userRepository.save(admin);

			log.info("Get all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
