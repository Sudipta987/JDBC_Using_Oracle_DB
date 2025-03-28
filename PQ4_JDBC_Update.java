//Q9 : W.A.P to Practice the JDBC [Update] concept using JDBC.
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
//Update the database Records 
public class PQ4_JDBC_Update {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
            Statement smt=con.createStatement();
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            //Table print
            ResultSet rs=smt.executeQuery("select * from employee ");
            System.out.println("Before Updation of the Table....");
            System.out.println("|ENO\t|\t|ENAME\t|\t|ESALARY\t|");
            while(rs.next()) {
                int eid=rs.getInt(1);
                String name=rs.getString(2);
                double salary=rs.getDouble(3);
                System.out.println(eid+"\t\t"+name+"\t\t"+salary);
            }
            System.out.println("Enter the Employee ID ,Which record you want to update: ");
            int eno=Integer.parseInt(br.readLine());
            System.out.println("Enter the new Salary ,which you want to update: ");
            double esalary=Double.parseDouble(br.readLine());
            int count=smt.executeUpdate("update employee set esalary="+esalary+"where eno="+eno);
            if(count>0) {
                System.out.println(count+" records are updated .....");
            }else{
                System.out.println("No records are updated...");
            }
            ResultSet rs1=smt.executeQuery("select * from employee where eno="+eno);
            System.out.println("After  Updating the concerning Records are....");
            while(rs1.next()) {
                int eid=rs1.getInt(1);
                String name=rs1.getString(2);
                double salary=rs1.getDouble(3);
                System.out.println("|ENO\t|\t|ENAME\t|\t|ESALARY\t|");
                System.out.println(eid+"\t\t"+name+"\t\t"+salary);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
