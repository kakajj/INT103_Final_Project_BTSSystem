package dataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class StationDataBase {
    private int count;
    public static void main(String[] args) {
        StationDataBase m1 = new StationDataBase();
        String temp[] = m1.testSelectFromCustomerTable();
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
            
        }
//        testSelectFromCustomerTable();
    }
        private void insertDB(int sta_id,String Sta_name,int sta_distance) {
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/INT103_Project","lengleng0909", "0869788258");
                Statement stm = conn.createStatement();) {
              
           int row = stm.executeUpdate("INSERT INTO STATION VALUES("+sta_id+",'"+Sta_name+"',"+sta_distance+")");
            System.out.println(row);
            count++;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        private String[] testSelectFromCustomerTable() {
         try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/INT103_Project","lengleng0909", "0869788258");
                Statement stm = conn.createStatement();) {
             ResultSet stationName =stm.executeQuery("SELECT * FROM STATION");
            ResultSet count = stm.executeQuery("SELECT count(sta_id) FROM STATION");
//           String Station_name[] = new String[count];
//           int i = 0;
//           while(stationName.next()){
//               Station_name[i++] = stationName.getString("sta_name");
//           }
//             return Station_name;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return null;
    }    
}