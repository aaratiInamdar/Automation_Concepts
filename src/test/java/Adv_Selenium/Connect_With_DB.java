package Adv_Selenium;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import org.testng.annotations.Test;

public class Connect_With_DB {
	String url = "jdbc:mysql://49.249.28.218:3333/tp29";
    String username = "root@%";
    String password = "root";
	@Test
	public void connectWith_DB()
	{
		  try {
	            Connection con = DriverManager.getConnection(url, username, password);
	            System.out.println("✅ Connected to CRM database successfully!");
	            ResultSet executeQuery = con.createStatement().executeQuery("SELECT * FROM students");
	           
	            while (executeQuery.next()) {
  System.out.println(executeQuery.getInt("id") + " | " +
	                				executeQuery.getString("name") + " | " +
	                				executeQuery.getString("date_of_birth")  );  
  }
	            con.close();
	        }
	            catch (Exception e) {
	            e.printStackTrace();
	        }
		System.out.println("---FINISHED-------");
	}
}