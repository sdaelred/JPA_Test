package fr.efrei.JPA_Test;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RentRepository extends CrudRepository<Rent, Long>{
	List<Rent> findById(long id);

}