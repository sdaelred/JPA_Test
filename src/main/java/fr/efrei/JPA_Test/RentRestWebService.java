package fr.efrei.JPA_Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentRestWebService {

	RentRepository rentRepository;
	
	@Autowired
	public RentRestWebService(RentRepository rentRepository) {
		super();
		this.rentRepository = rentRepository;
	}
	
	@GetMapping("/rents")
	public Iterable<Rent> getRents(){
		return rentRepository.findAll();
	}
}