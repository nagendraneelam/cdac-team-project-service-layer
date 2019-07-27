package cdacteamproject.BussinessLayerHome;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class Controller {

	@Autowired
	private ServiceLayer s;
	@Autowired
	private EmployeeService es;
	
	@PostMapping("/elogin")
	public int employeeLogin(@RequestBody Employee e)
	{
		return es.employeecredentials(e);
	}
	
	@PostMapping("/alogin")
	public int adminLogin(@RequestBody Admin a)
	{
		return s.adminCredentials(a);
	}
	
	@PostMapping("/eregister")
	public int employeeRegister(@RequestBody Employee e)
	{
		return es.register(e);
	}
	
	@PostMapping("/notapprovedusers")
	public List<Employee> getAllNotAprovedUsers()
	{
		return s.getAllNotApprovedUsers();
	}
	
	@PostMapping("/approveuser")
	public int approveUser(@RequestBody Employee e)
	{
		return s.approveUser(e);
	}
	
	@PostMapping("/unblockuser")
	public int unblockUser(@RequestBody Employee e)
	{
		return s.unblockUser(e);
	}
	
	@PostMapping("/blockuser")
	public int blockUser(@RequestBody Employee e)
	{
		return s.blockUser(e);
	}
	
	@PostMapping("/removeuser")
	public int removeUser(@RequestBody Employee e)
	{
		return s.removeUser(e);
	}
	@PostMapping("/getallblockedusers")
	public List<Employee> getAllBlockedUsers()
	{
		return s.getAllBlockedUsers();
	}
	
	@PostMapping("/addmoney")
	public int addMoney(@RequestBody Employee e)
	{
		return s.addMoney(e);
	}
	
	@PostMapping("/addnewitem")
	public int addNewItem(@RequestBody Item i)
	{
		return s.addNewItem(i);
	}
	
	@PostMapping("/removeitem")
	public int removeItem(@RequestBody Item i)
	{
		return s.removeItem(i);
	}
	
	@PostMapping("/updateitem")
	public int updateItem(@RequestBody Item i)
	{
		return s.updateItem(i);
	}
	
	@PostMapping("/getallactiveitems")
	public List<Item> getAllActiveItems()
	{
		return s.getAllActiveItems();
	}
	
	@PostMapping("/getallinactiveitems")
	public List<Item> getAllInactiveItems()
	{
		return s.getAllInactiveItems();
	}
	
	@PostMapping("/addtomenu")
	public int addToMenu(@RequestBody Item i)
	{
		return s.addToMenu(i);
	}
	
	@PostMapping("/removefrommenu")
	public int removeFromMenu(@RequestBody Item i)
	{
		return s.removeFromMenu(i);
	}
	
	@PostMapping("/checkbalance")
	public int checkBalance(@RequestBody Employee e)
	{
		return es.checkBalance(e);
	}
	
	@PostMapping("/order")
	public int order(@RequestBody Orders o)
	{
		return es.order(o);
	}
	
	@PostMapping("/userongoingorders")
	public List<Orders> userOngoingOrders(@RequestBody Employee e)
	{
		return es.userOngoingOrders(e);
	}
	
	@PostMapping("/userpreviousorders")
	public List<Orders> userPreviousOrders(@RequestBody Employee e)
	{
		return es.userPreviousOrders(e.getEmpid());
	}
	
	@PostMapping("/ongoingorders")
	public List<Orders> ongoingOrders()
	{
		return s.ongoingOrders();
	}
	
	@PostMapping("/completeorder")
	public int completeorder(@RequestBody Orders o)
	{
		return s.completeOrder(o);
	}
	
	@PostMapping("/cancelorder")
	public int cancelorder(@RequestBody Orders o)
	{
		return s.cancelOrder(o);
	}
	@PostMapping("/getanitem")
	public Item getAnItem(@RequestBody Item i)
	{
		return es.getAnItem(i);
	}
}
