package database.inmemory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//Represents a table in the database
public class Table {
 private String name;
 private List<ColumnDefinition> columns;
 private List<Row> rows;

 public Table(String name, List<ColumnDefinition> columns) {
     this.name = name;
     this.columns = columns;
     this.rows = new ArrayList<>();
 }

 public String getName() {
     return name;
 }

 public List<ColumnDefinition> getColumns() {
     return columns;
 }

 public void insertRow(Map<String, Object> data) {
     Row row = new Row();
     for (ColumnDefinition column : columns) {
         Object value = data.get(column.getName());
         if (value == null && column.isRequired()) {
             throw new IllegalArgumentException("Missing required column: " + column.getName());
         }
         row.addColumnValue(column.getName(), value);
     }
     rows.add(row);
 }

 public List<Row> getRows() {
     return rows;
 }
}
