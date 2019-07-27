package cdacteamproject.BussinessLayerHome;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {
	
	@Autowired
	private AdminDaoConnection ad;
	
	@Autowired
	private EmployeeDaoConnection edc;
	
	@Autowired
	private ItemDaoConnection idc;
	
	@Autowired
	private OrderDaoConnection odc;
	
	
	public int adminCredentials(Admin a) {
		// TODO Auto-generated method stub
		int val=0;
		try
		{
		Admin ref=ad.findById(a.getAdminid()).get();
		if(ref==null)
			val= 0;
		else if(ref.getPwd().equals(a.getPwd()))
			val=1;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return 0;
		}
		return val;
	}
	

	public List<Employee> getAllNotApprovedUsers() {
		// TODO Auto-generated method stub
		return edc.findAllNotApprovedUsers(0,false);
	}


	public int unblockUser(Employee e) {
		// TODO Auto-generated method stub
		Employee dbref=edc.findById(e.getEmpid()).get();
		dbref.setBlocked(false);
		if(edc.save(dbref)!=null)
			return 1;
		return 0;
	}


	public int removeUser(Employee e) {
		// TODO Auto-generated method stub
		if(edc.findById(e.getEmpid()).isPresent())
		{
			edc.deleteById(e.getEmpid());
			return 1;
		}
		return 0;
	}
	
	
	public int approveUser(Employee e) {
		// TODO Auto-generated method stub
		Employee dbref=edc.findById(e.getEmpid()).get();
		dbref.setStatus(1);
		if(edc.save(dbref)!=null)
			return 1;
		return 0;
	}


	public int blockUser(Employee e) {
		// TODO Auto-generated method stub
		Employee dbref=edc.findById(e.getEmpid()).get();
		dbref.setBlocked(true);
		if(edc.save(dbref)!=null)
			return 1;
		return 0;
	}


	public List<Employee> getAllBlockedUsers() {
		// TODO Auto-generated method stub
		
		return edc.getAllBlockedUsers();
	}


	public int addMoney(Employee e) {
		// TODO Auto-generated method stub
		try
		{
		Employee dbref=edc.findById(e.getEmpid()).get();
		dbref.setMoney(dbref.getMoney()+e.getMoney());
		if(edc.save(dbref)!=null)
			return 1;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return 0;
		}
		return 0;
	}


	public int addNewItem(Item i) {
		// TODO Auto-generated method stub
		if(idc.findById(i.getItemno()).isPresent())
			return 2;
		try
		{
		if(idc.save(i)!=null)
			return 1;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return 0;
		}
		return 0;
	}


	public int removeItem(Item i) {
		// TODO Auto-generated method stub
		if(idc.findById(i.getItemno()).isPresent())
		{
			idc.delete(i);
			return 1;
		}
		return 0;
	}


	public int updateItem(Item i) {
		// TODO Auto-generated method stub
		if(idc.findById(i.getItemno()).isPresent())
		{
			Item dbref=idc.findById(i.getItemno()).get();
			dbref.setItemname(i.getItemname());
			dbref.setPrice(i.getPrice());
			idc.save(dbref);
			return 1;
		}
		return 0;
	}


	public List<Item> getAllActiveItems() {
		// TODO Auto-generated method stu
		return idc.getAllActiveItems();
	}


	public List<Item> getAllInactiveItems() {
		// TODO Auto-generated method stub
		return idc.getAllInactiveItems();
	}


	public int addToMenu(Item i) {
		// TODO Auto-generated method stub
		if(idc.findById(i.getItemno()).isPresent())
		{
			Item dbref=idc.findById(i.getItemno()).get();
			dbref.setStatus(true);
			idc.save(dbref);
			return 1;
		}
		return 0;
	}


	public int removeFromMenu(Item i) {
		// TODO Auto-generated method stub
		if(idc.findById(i.getItemno()).isPresent())
		{
			Item dbref=idc.findById(i.getItemno()).get();
			dbref.setStatus(false);
			idc.save(dbref);
			return 1;
		}
		return 0;
	}


	public List<Orders> ongoingOrders() {
		return odc.ongoingOrders(0);
	}


	public int completeOrder(Orders o) {
		// TODO Auto-generated method stub
		if(odc.findById(o.getOrderid()).isPresent())
		{
			Orders dbref=odc.findById(o.getOrderid()).get();
			dbref.setStatus(1);
			odc.save(dbref);
			return 1;
		}
		return 0;
	}


	public int cancelOrder(Orders o) {
		// TODO Auto-generated method stub
		if(odc.findById(o.getOrderid()).isPresent())
		{
			odc.delete(o);
			return 1;
		}
		return 0;
	}

	
	

}
