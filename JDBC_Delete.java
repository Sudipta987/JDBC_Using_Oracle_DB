//Q5 : W.A.P to implement how we can Delete Records or data from  a Table or Database using JDBC.
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_Delete {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
            Statement smt=con.createStatement();
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            while(true) {
                System.out.print("Enter Deletion eno: ");
                int eno=Integer.parseInt(br.readLine());

                int count=smt.executeUpdate("delete from employee where eno="+eno);
                if(count==1) {
                    System.out.println(count+"record deleted");
                }else{
                    System.out.println("No record deleted");
                }
                System.out.println("Do you want to Delete More Records[Yes/No]");
                String ch=br.readLine();
                if(ch.equalsIgnoreCase("no")) {
                    break;
                }
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        sc.close();
    }
    
}
