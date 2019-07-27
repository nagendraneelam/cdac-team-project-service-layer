package cdacteamproject.BussinessLayerHome;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDaoConnection extends JpaRepository<Employee, Integer>{

	@Query("select emp from Employee emp where emp.status=?1 and emp.blocked=?2")
	List<Employee> findAllNotApprovedUsers(int status,Boolean bstatus);

	@Query("select emp from Employee emp where emp.blocked=true")
	List<Employee> getAllBlockedUsers();

}
