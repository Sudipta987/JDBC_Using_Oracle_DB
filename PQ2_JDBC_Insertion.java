//Q7 : W.A.P to Practice the JDBC [Insertion] concept using JDBC.
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class PQ2_JDBC_Insertion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
            PreparedStatement psmt=con.prepareStatement("insert into employee values(?,?,?)");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            do{
                System.out.println("Enter the Employee ID: ");
                int eno=Integer.parseInt(br.readLine());
                System.out.println("Enter the Employee Name: ");
                String ename=br.readLine();
                System.out.println("Enter the Employee Salary: ");
                double esalary=Double.parseDouble(br.readLine());
                psmt.setInt(1,eno);
                psmt.setString(2,ename);
                psmt.setDouble(3,esalary);
                int count=psmt.executeUpdate();
                if(count>0) {
                    System.out.println(count+" record is inserted in the Employee Table .....");
                }else{
                    System.out.println("No Record is inserted in the Employee Table");
                }
                System.out.println("Do you want to Insert More Records[YES/NO]: ");
                String ans=br.readLine();
                if(ans.equalsIgnoreCase("no")) {
                    break;
                }
            }while(true);


        }catch(Exception e) {
            e.printStackTrace();
        }
        sc.close();
        
        
    }
    
}
