//Q2 : W.A.P to implement how we can Insert Data in a Table or Database using JDBC.
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JDBC_insert {
    public static void main(String[] args) throws ClassNotFoundException,SQLException,IOException{
        Scanner sc=new Scanner(System.in);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
        PreparedStatement psmt=con.prepareStatement("insert into employee values(?,?,?)");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.print("Enter eno: ");
            int eno=Integer.parseInt(br.readLine());
            System.out.print("Enter ename: ");
            String ename=br.readLine();
            System.out.print("Enter esalary: ");
            double esalary=Double.parseDouble(br.readLine());
            psmt.setInt(1,eno);
            psmt.setString(2,ename);
            psmt.setDouble(3,esalary);
            int count=psmt.executeUpdate();
            if(count>=0) {
                System.out.println(count+"record inserted");
            }else{
                System.out.print("No record inserted");
            }
            System.out.println("Do you want to insert more Records[Yes/No]");
            String ch=br.readLine();
            if(ch.equalsIgnoreCase("no")){
                break;
            }
        }
        sc.close();
        
    }
    
}
