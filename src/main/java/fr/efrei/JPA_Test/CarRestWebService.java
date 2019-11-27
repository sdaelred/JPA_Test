package fr.efrei.JPA_Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarRestWebService {

	CarRepository carRepository;
	
	@Autowired
	public CarRestWebService(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}
	
	@GetMapping("/cars")
	public Iterable<Car> getCars(){
		return carRepository.findAll();
	}
}