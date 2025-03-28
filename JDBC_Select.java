//Q3 : W.A.P to implement how we can Retrive and Process data from  a Table or Database using JDBC.
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBC_Select {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
            Statement smt=con.createStatement();
            ResultSet rs=smt.executeQuery("select * from employee");
            while(rs.next()) { //rs.next() returns true if there is another row in the ResultSet and moves the cursor to that next row.
                int eno=rs.getInt(1);
                String ename=rs.getString(2);
                double esalary =rs.getDouble(3);
                System.out.print("Employee Id: "+eno+"\t");
                System.out.print("Employee Name: "+ename+"\t");
                System.out.print("Employee Salary: "+esalary+"\t");
                System.out.println();
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        sc.close();
    }
}
