package database.columnar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Represents a table in a column-oriented database
public class ColumnTable {
    private String name;
    private List<ColumnDefinition> columnDefinitions;
    private Map<String, Column> columns;

    public ColumnTable(String name, List<ColumnDefinition> columnDefinitions) {
        this.name = name;
        this.columnDefinitions = columnDefinitions;
        this.columns = new HashMap<>();

        // Initialize columns
        for (ColumnDefinition definition : columnDefinitions) {
            columns.put(definition.getName(), new Column(definition.getName(), definition.getType()));
        }
    }

    public String getName() {
        return name;
    }

    public List<ColumnDefinition> getColumnDefinitions() {
        return columnDefinitions;
    }

    public void insertRow(Map<String, Object> rowData) {
        for (ColumnDefinition definition : columnDefinitions) {
            String columnName = definition.getName();
            Object value = rowData.get(columnName);

            if (value == null && definition.isRequired()) {
                throw new IllegalArgumentException("Missing required column: " + columnName);
            }

            Column column = columns.get(columnName);
            column.addValue(value);
        }
    }

    public List<Object> getColumnData(String columnName) {
        Column column = columns.get(columnName);
        if (column == null) {
            throw new IllegalArgumentException("Column does not exist: " + columnName);
        }
        return column.getValues();
    }
}