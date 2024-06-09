package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pageDomain.DatabaseConnector;
import com.example.demo.pageDomain.Page;

@RestController
@SpringBootApplication
public class MyNoteAppApplication {

	@Autowired
	private DatabaseConnector databaseConnector;
//	

	
	
	private static final Logger LOG = LoggerFactory.getLogger(MyNoteAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MyNoteAppApplication.class, args);
	}

	@GetMapping("/{pageId}")
	@CrossOrigin
	public Page index(@PathVariable String pageId) {
		Page page = new Page();
		return page.setup(pageId);

	}

	//	@PostMapping("/add-user")
	//	@CrossOrigin
	//	public ResponseEntity<String> addUser(@RequestBody TContent tContent)
	//	{
	//
	//		try (Connection connection = DatabaseConnector.getConnection()) {
	//
	//			String query = "INSERT INTO users(user_id, username, password_hash, created_at, updated_at) VALUES (?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
	//
	//			try (PreparedStatement statement = connection.prepareStatement(query)) {
	//
	//				System.out.println(tContent.getUserId());
	//
	//				statement.setString(1, tContent.getUserId());
	//
	//				statement.setString(2, user.getUsername());
	//
	//				statement.setString(3, user.getPasswordHash());
	//
	//				statement.executeUpdate();
	//
	//			}
	//
	//			return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully.");
	//
	//		} catch (SQLException e) {
	//
	//			e.printStackTrace();
	//
	//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add user.");
	//
	//		}
	//
	//	}
	//
	//	private static final String template = "Hello, %s!";
	//
	//	private final AtomicLong counter = new AtomicLong();
	//
	//	@GetMapping("/greeting")
	//
	//	@CrossOrigin
	//
	//	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name)
	//	{
	//
	//		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	//
	//	}
	//
	//	@Bean
	//
	//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	//
	//		return builder.build();
	//
	//	}
	//
	//	@Bean
	//
	//	@Profile("!test")
	//
	//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
	//
	//		return args -> {
	//
	//			//				Quote quote = restTemplate.getForObject(
	//
	//			//						"http://localhost:8080/api/random", Quote.class);
	//
	//			//				log.info(quote.toString());
	//
	//		};
	//
	//	}

}
