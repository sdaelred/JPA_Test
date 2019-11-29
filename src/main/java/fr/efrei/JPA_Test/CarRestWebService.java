package fr.efrei.JPA_Test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

/*import receiver.ApplicationContext;
import receiver.ClassPathXmlApplicationContext;
import receiver.Message;
import receiver.Queue;
import receiver.QueueConnection;
import receiver.QueueConnectionFactory;
import receiver.QueueReceiver;
import receiver.QueueSession;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.QueueConnectionFactory;*/

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

@RestController
public class CarRestWebService{
	
	@Autowired
	private CarRepository carRepository;
	
	private List<Car> cars = new ArrayList<Car>();
	
	public CarRestWebService() {//Constructeur avec deux voitures de bases
		cars.add(new Car("11AA22", "Ferrari", 2, 1000, true));
		cars.add(new Car("33BB44", "Porshe", 2, 2222, false));
	}
	
	
	
	@RequestMapping(value="/cars", method=RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	public List<Car> getListOfCars(){//Renvoie simplement la liste des voitures de la classe
		carRepository.save(cars);
		return cars;
	}
	
	@RequestMapping(value = "/cars", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addCar(@RequestBody Car car) throws Exception{//Ajoute une voiture dans la liste
		System.out.println(car);
		cars.add(car);
	}
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	@ResponseBody
	public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception{ 
		//Cette fonctione renvoie la première voiture (supposée la seule...) avec la même
		//plaque d'immatriculation que celle donnée en paramètre : @PathVariable("plateNumber") String plateNumber
		for(Car car : cars) {
			if(car.getPlateNumber().equals(plateNumber)) {
				return car;
			}
		}
		return null;
	}
	
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.DELETE) 
	@ResponseStatus(HttpStatus.OK) 
	public void getBack(@PathVariable("plateNumber") String plateNumber) throws Exception{
		Car theCar = aCar(plateNumber);
		theCar.setRented(false);
		theCar.setBegin(null);
		theCar.setEnd(null);
	}
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT) 
	@ResponseStatus(HttpStatus.OK) 
	public void rent(@PathVariable("plateNumber") String plateNumber, @RequestBody(required = false) String dates) throws Exception{
		Car theCar = aCar(plateNumber);
		theCar.setRented(true);
		theCar.setBegin("29/11/2019");
		theCar.setEnd("Deux mois après le " + dates);//Location de deux mois
	}//Ne pouvant pas tester notre code, nous avons "simulé" une location de deux mois de base.
	//Dans la vraie vie, les dates entrées seraient de vraies dates proposées par l'utilisateur.

	
	
	//Nous pensons qu'il faille mettre ici les résultats du TP2 (message broker).
	//Le contenu de chaque message devrait être la génération json de nos voitures.
	//Nous avons des problèmes d'import que nous n'avons pas pu résoudre, 
	//d'où la mise en commentaire. Le TP a cependant fonctionné quand lancé seul.
	public void send() {
		/*try{
			
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
			QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");
			
			Queue queue = (Queue) applicationContext.getBean("queue");
			
			// Create a connection. See https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html	
			QueueConnection queueConnection = factory.createQueueConnection();
			// Open a session without transaction and acknowledge automatic
			QueueSession session = queueConnection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE); 
			// Start the connection
			queueConnection.start();
			// Create a sender
			QueueSender sender = session.createSender(queue); 
			// Create a message
			TextMessage message =session.createTextMessage("Hello message broker\n\n\n\n\n\n\n\ndddddddddddddddddddddd");
			// Send the message
			sender.send(message);
			// Close the session
			session.close();
			
			// Close the connection
			queueConnection.close();

		}catch(Exception e){
			e.printStackTrace();
		}*/
	}
	
	public void receive() {
		/*try{
			
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
			QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");
			
			Queue queue = (Queue) applicationContext.getBean("queue");
			
			// Create a connection. See https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html
			QueueConnection queueConnection = factory.createQueueConnection();
			// Open a session	
			QueueSession session = queueConnection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE); 
			// start the connection	
			queueConnection.start();
			// Create a receive	
			QueueReceiver receiver = session.createReceiver(queue); 
			// Receive the message
			Message m = receiver.receive();
			
			System.out.println(m + "rrrrrrrrrr\n\n\n\n\n\n\n\n\n");
			session.close();
			queueConnection.close();
		}catch(Exception e){
			e.printStackTrace();
		}*/
	}
}

