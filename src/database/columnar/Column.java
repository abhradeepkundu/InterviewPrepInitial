package database.columnar;

import java.util.ArrayList;
import java.util.List;

//Represents a column in the database
public class Column {
 private String name;
 private List<Object> values;

 public Column(String name, String type) {
     this.name = name;
     this.values = new ArrayList<>();
 }

 public void addValue(Object value) {
     values.add(value);
 }

 public List<Object> getValues() {
     return values;
 }
}
