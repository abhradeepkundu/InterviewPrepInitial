package database.columnar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColumnOrientedDatabase {
	
	private String name;
    private Map<String, ColumnTable> tables;

    public ColumnOrientedDatabase(String name) {
        this.name = name;
        this.tables = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void createTable(String tableName, List<ColumnDefinition> columnDefinitions) {
        if (tables.containsKey(tableName)) {
            throw new IllegalArgumentException("Table already exists: " + tableName);
        }
        tables.put(tableName, new ColumnTable(tableName, columnDefinitions));
    }

    public ColumnTable getTable(String tableName) {
        return tables.get(tableName);
    }

    public void deleteTable(String tableName) {
        tables.remove(tableName);
    }
    

	public static void main(String[] args) {
		// Create a column-oriented database
        ColumnOrientedDatabase db = new ColumnOrientedDatabase("AnalyticsDB");

        // Define column definitions
        List<ColumnDefinition> columnDefinitions = Arrays.asList(
            new ColumnDefinition("id", "Integer", true),
            new ColumnDefinition("name", "String", true),
            new ColumnDefinition("age", "Integer", false),
            new ColumnDefinition("salary", "Double", false)
        );

        // Create a table
        db.createTable("Employees", columnDefinitions);

        // Insert rows
        ColumnTable employees = db.getTable("Employees");

        Map<String, Object> row1 = new HashMap<>();
        row1.put("id", 1);
        row1.put("name", "Alice");
        row1.put("age", 30);
        row1.put("salary", 80000.0);

        Map<String, Object> row2 = new HashMap<>();
        row2.put("id", 2);
        row2.put("name", "Bob");
        row2.put("age", 35);
        row2.put("salary", 90000.0);

        employees.insertRow(row1);
        employees.insertRow(row2);

        // Retrieve column data
        List<Object> ages = employees.getColumnData("age");
        System.out.println("Ages: " + ages);

        List<Object> salaries = employees.getColumnData("salary");
        System.out.println("Salaries: " + salaries);

	}

}
