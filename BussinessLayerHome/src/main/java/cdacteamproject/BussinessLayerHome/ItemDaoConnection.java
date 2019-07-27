package cdacteamproject.BussinessLayerHome;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDaoConnection extends JpaRepository<Item, Integer>{

	@Query("select i from Item i where i.status=true")
	List<Item> getAllActiveItems();

	@Query("select i from Item i where i.status=false")
	List<Item> getAllInactiveItems();

}
