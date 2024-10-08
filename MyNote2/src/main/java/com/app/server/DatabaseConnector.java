package com.app.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;

//@Component

public class DatabaseConnector {

	private static final String URL = "jdbc:postgresql://localhost:5433/NoteAppDB";

	private static final String USER = "postgres";

	private static final String PASSWORD = "Yoshito4410";

	public Connection getConnection() throws SQLException {

		return DriverManager.getConnection(URL, USER, PASSWORD);

	}
    @Bean
    public DatabaseConnector databaseConnector() {
        // Beanの実装を返す
        return new DatabaseConnector();
    }

}
