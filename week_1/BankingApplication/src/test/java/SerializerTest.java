import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

import com.revature.bankingapp.entities.account.CheckingAccount;
import com.revature.bankingapp.entities.account.SavingsAccount;
import com.revature.bankingapp.entities.person.Administrator;
import com.revature.bankingapp.entities.person.Customer;
import com.revature.bankingapp.entities.person.Employee;
import com.revature.bankingapp.utils.Serializer;

public class SerializerTest {

	public void serializeTest() throws FileNotFoundException, ClassNotFoundException, IOException {
		Customer c = new Customer("Martin", "Delira", "mdelira", "popochas", "07-08-1990", "123 7th");
		Employee e = new Employee("John", "Delira","johnD","tkt" ,"07-08-1987", "123 8th");
		Administrator a = new Administrator("Martin", "Admin", "adminMartin", "adminrules", "01-01-1990", "123 10th");
				
		
		ArrayList<Customer> customerDB = new ArrayList<Customer>();
		ArrayList<Employee> employeeDB = new ArrayList<Employee>();
		ArrayList<Administrator> adminDB = new ArrayList<Administrator>();
		ArrayList<SavingsAccount> savingsDB = new ArrayList<SavingsAccount>();
		ArrayList<CheckingAccount> checkingsDB = new ArrayList<CheckingAccount>();
		
		String testCustomerDB = "src/main/java/com/revature/bankingapp/resources/database/test/customer.txt";
		String testEmployeeDB = "src/main/java/com/revature/bankingapp/resources/database/test/employee.txt";
		String testAdminDB = "src/main/java/com/revature/bankingapp/resources/database/test/admin.txt";
		String testSavingsDB = "src/main/java/com/revature/bankingapp/resources/database/test/savings.txt";
		String testCheckingDB = "src/main/java/com/revature/bankingapp/resources/database/test/checking.txt";
		
		
		Serializer serializer = new Serializer<>();
		
		serializer.persist(c);
		
		System.out.println("Sucesss");
		

	}
	
}
