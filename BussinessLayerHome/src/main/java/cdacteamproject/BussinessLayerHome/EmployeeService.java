package cdacteamproject.BussinessLayerHome;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDaoConnection edc;
	
	@Autowired
	private OrderDaoConnection odc;
	
	@Autowired
	private ItemDaoConnection idc;
	
	public int register(Employee e) {
		// TODO Auto-generated method stub
		int val=0;
		if(edc.findById(e.getEmpid()).isPresent())
			return 2;
		try
		{
		if(edc.save(e) != null)
			val=1;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return val;
		}
		return val;
	}
	public int employeecredentials(Employee e) {
		// TODO Auto-generated method stub
		try
		{
		Employee dbref=edc.findById(e.getEmpid()).get();
		if(dbref!=null)
			if(dbref.getPwd().equals(e.getPwd()))
				if(dbref.getStatus()==1 && dbref.getBlocked()==false)
					return 1;
				else if(dbref.getBlocked()==true)
					return 3;
				else
					return 2;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return 0;
		}
		return 0;
	}
	public int checkBalance(Employee e) {
		// TODO Auto-generated method stub
		Employee emp;
		try
		{
			emp=edc.findById(e.getEmpid()).get();
		}
		catch(Exception ex)
		{
			return -1;
		}
		return emp.getMoney();
	}
	public int order(Orders o) {
		// TODO Auto-generated method stub
		if(edc.findById(o.getEmpid()).isPresent())
		{
			Employee e=edc.findById(o.getEmpid()).get();
			if(e.getMoney()<o.getOrderprice())
				return 0;
			else
			{
				e.setMoney(e.getMoney()-o.getOrderprice());
				edc.save(e);
				o.setEmpname(e.getEmpname());
				o.setDate(new Date());
				Orders dbref=odc.save(o);
				return dbref.getOrderid();
			}
		}
		return 0;
	}
	public List<Orders> userOngoingOrders(Employee e) {
		// TODO Auto-generated method stub
		int id=e.getEmpid();
		return odc.userOngoingOrders(id,0);
	}
	public List<Orders> userPreviousOrders(int empid) {
		// TODO Auto-generated method stub
		return odc.userPreviousOrders(empid,1);
	}
	public Item getAnItem(Item i) {
		// TODO Auto-generated method stub
		if(idc.findById(i.getItemno()).isPresent())
		{
			return idc.findById(i.getItemno()).get();
		}
		return null;
	}

}
