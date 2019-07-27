package cdacteamproject.BussinessLayerHome;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDaoConnection extends JpaRepository<Orders, Integer>{

	@Query(value="select * from orders where empid=?1 and status=?2",nativeQuery=true)
	List<Orders> userOngoingOrders(int id, int i);

	@Query(value="select * from orders where empid=?1 and status=?2 order by date desc",nativeQuery=true)
	List<Orders> userPreviousOrders(int empid, int i);

	@Query(value="select * from orders where status=?1 order by date",nativeQuery=true)
	List<Orders> ongoingOrders(int status);
	

}
