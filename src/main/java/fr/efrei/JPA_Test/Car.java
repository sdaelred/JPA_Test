package fr.efrei.JPA_Test;

import java.util.ArrayList;//Certains imports sont innutilisés, nous les laissons pour
import java.util.List;     // quand nous pourrons les utiliser, 
                           //lorsque nous aurons la correction des TPs.

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Car {//Par cohésion avec les autres TP, nous n'avons gardé que la classe "Car".
public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private int plateNumber;


public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public int getPlateNumber() {
	return plateNumber;
}

public void setPlateNumber(int plateNumber) {
	this.plateNumber = plateNumber;
}
@Override
public String toString() {
	return "Car [plateNumber=" + plateNumber + "]";
}

}
