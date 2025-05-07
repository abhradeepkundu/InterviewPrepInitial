package database.inmemory;

import java.util.HashMap;
import java.util.Map;

//Represents a row in a table
public class Row {
 private Map<String, Object> data;

 public Row() {
     this.data = new HashMap<>();
 }

 public void addColumnValue(String columnName, Object value) {
     data.put(columnName, value);
 }

 public Object getColumnValue(String columnName) {
     return data.get(columnName);
 }

 public Map<String, Object> getAllValues() {
     return data;
 }
}
