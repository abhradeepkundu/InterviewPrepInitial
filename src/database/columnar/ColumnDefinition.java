package database.columnar;



//Represents a column definition
public class ColumnDefinition {
 private String name;
 private String type; // E.g., "String", "Integer", etc.
 private boolean required;

 public ColumnDefinition(String name, String type, boolean required) {
     this.name = name;
     this.type = type;
     this.required = required;
 }

 public String getName() {
     return name;
 }

 public String getType() {
     return type;
 }

 public boolean isRequired() {
     return required;
 }
}