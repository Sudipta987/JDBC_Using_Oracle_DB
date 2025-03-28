//Q6 : W.A.P to Practice the JDBC [Connection] concept using JDBC.
import java.sql.Connection;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.DriverManager;
public class PQ1_JDBC_Connection {
   
        public static void main(String[] args)  {
            Scanner sc=new Scanner(System.in);
            try{
                //Establish an Oracle DataBase Connection
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
                Statement smt=con.createStatement();
                //Creating an Table named Employee
                smt.executeUpdate("create table employee (eno number,ename varchar(50),esalary number)");
                System.out.println("The Table Employee is Created Successfully...........");
                con.close();
                smt.close();
            }catch(Exception e){
                e.printStackTrace();
            }
          
            sc.close();
        }
    }    