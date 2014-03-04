package custom;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class ResultConverter {
    static public List<List<String>> convert(ResultSet resultSet) {
        List<List<String>> result = new ArrayList<>();  // List of list, one per row

        try {
            ResultSetMetaData metadata = resultSet.getMetaData();
            int numCols = metadata.getColumnCount();
            while (resultSet.next()) {
                List<String> row = new ArrayList<>(numCols); // new list per row
                int i = 1;
                while (i <= numCols) {  // don't skip the last column, use <=
                    row.add(resultSet.getString(i++));
                }
                result.add(row); // add it to the result
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }

        return result;
    }
}
