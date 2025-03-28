//Q8 : W.A.P to Practice the JDBC [Select] concept using JDBC.
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PQ3_JDBC_Select {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
            Statement smt=con.createStatement();
            ResultSet rs=smt.executeQuery("select * from employee");
            System.out.println("|ENO\t|\t|ENAME\t|\t|ESALARY\t|");
            while(rs.next()) {
                int eno=rs.getInt(1);
                String ename=rs.getString(2);
                double esalary=rs.getDouble(3);
                System.out.println(eno+"\t\t"+ename+"\t\t"+esalary);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
