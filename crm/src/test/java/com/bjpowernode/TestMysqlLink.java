package com.bjpowernode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMysqlLink {
    String url = "jdbc:mysql://localhost:3306/crm";
    String username = "java";
    String password = "password";

//System.out.println("Connecting database...");

public void main(){
    System.out.println("Connecting database...");
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
    System.out.println("Database connected!");
} catch (SQLException e) {
    throw new IllegalStateException("Cannot connect the database!", e);
}
}
}

