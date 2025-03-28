//Q4 : W.A.P to implement how we can Update Records or data from  a Table or Database using JDBC.
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_Update {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String value;int eid;double esal;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
            Statement smt=con.createStatement();
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter eno: ");
            value=br.readLine();
            eid=Integer.parseInt(value);
            System.out.print("Enter Employee New esalary: ");
            value=br.readLine();
            esal=Double.parseDouble(value);
            int count=smt.executeUpdate("update employee set esalary ="+esal+"where eno="+eid);
            if(count>=0) {
                System.out.println(count+"record updated");
            }else{
                System.out.println("No record found");
            }

        }catch(Exception e) {
            System.out.println(e);
        }
        sc.close();
    }
}
