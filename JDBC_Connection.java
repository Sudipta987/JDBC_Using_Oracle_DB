//Q1 : W.A.P to implement how we can connect a Java program to an Oracle database using JDBC.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_Connection{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection com=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
            Statement smt=com.createStatement();
            smt.executeUpdate("create table employee(eno number,ename varchar2(50),esalary number)");
            System.out.println("Table Successfully Created...");
            com.close();
        }catch(Exception e) {
            System.out.println(e);
        }
        sc.close();
    }
}