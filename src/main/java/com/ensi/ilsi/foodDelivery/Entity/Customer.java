package com.ensi.ilsi.foodDelivery.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String name;
private String adresse;
private int number;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", adresse=" + adresse + ", number=" + number + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
	result = prime * result + id;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + number;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Customer other = (Customer) obj;
	if (adresse == null) {
		if (other.adresse != null)
			return false;
	} else if (!adresse.equals(other.adresse))
		return false;
	if (id != other.id)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (number != other.number)
		return false;
	return true;
}




}
