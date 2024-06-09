package com.app.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MyNote2Application {

		@Autowired
		private DatabaseConnector databaseConnector;

	private static final Logger LOG = LoggerFactory.getLogger(MyNote2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(MyNote2Application.class, args);
	}

	@GetMapping("/")
	@CrossOrigin
	public String index() {

		String reply = "Greetings from Spring Boot!";

		//		try (Connection connection = databaseConnector.getConnection()) {
		//
		//			String query = "SELECT * FROM t_content";
		//
		//			try (PreparedStatement statement = connection.prepareStatement(query)) {
		//
		//				try (ResultSet resultSet = statement.executeQuery()) {
		//
		//					while (resultSet.next()) {
		//
		//						reply = resultSet.getString("content_id");
		//						reply = resultSet.getString("content_type");
		//						reply = resultSet.getString("body");
		//
		//						System.out.println("body: " + reply);
		//
		//					}
		//
		//				}
		//
		//			}
		//
		//		} catch (SQLException e) {
		//
		//			e.printStackTrace();
		//
		//		}

		return reply;

	}
}
