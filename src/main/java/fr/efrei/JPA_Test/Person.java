//Pour faire simple, nous avons rassembl� des classes. Celle-ci est donc en commentaire jusqu'� nouvel ordre.


/*package fr.efrei.JPA_Test;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Person {
	
	private String name;
	
	public Person() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy="person", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Rent> rents = new ArrayList<Rent>();

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Rent> getRent() {
		return rents;
	}

}
*/