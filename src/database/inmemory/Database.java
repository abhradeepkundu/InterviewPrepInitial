package database.inmemory;

import java.util.*;

//Represents an in-memory database
public class Database {
 private String name;
 private Map<String, Table> tables;

 public Database(String name) {
     this.name = name;
     this.tables = new HashMap<>();
 }

 public String getName() {
     return name;
 }

 public void createTable(String tableName, List<ColumnDefinition> columns) {
     if (tables.containsKey(tableName)) {
         throw new IllegalArgumentException("Table already exists: " + tableName);
     }
     tables.put(tableName, new Table(tableName, columns));
 }

 public Table getTable(String tableName) {
     return tables.get(tableName);
 }

 public void deleteTable(String tableName) {
     tables.remove(tableName);
 }
 public static void main(String[] args) {
	// Create a database
     Database database = new Database("InMemoryDB");

     // Define columns
     List<ColumnDefinition> userColumns = Arrays.asList(
         new ColumnDefinition("id", "Integer", true),
         new ColumnDefinition("name", "String", true),
         new ColumnDefinition("email", "String", false)
     );

     // Create a table
     database.createTable("Users", userColumns);

     // Insert a row
     Table usersTable = database.getTable("Users");
     Map<String, Object> userData = new HashMap<>();
     userData.put("id", 1);
     userData.put("name", "John Doe");
     userData.put("email", "john.doe@example.com");

     usersTable.insertRow(userData);

     // Retrieve rows
     for (Row row : usersTable.getRows()) {
         System.out.println(row.getAllValues());
     }
}
}
