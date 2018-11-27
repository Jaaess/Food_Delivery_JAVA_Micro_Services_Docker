package com.ensi.ilsi.foodDelivery.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;


/**
 * A Customer.
 */
@SuppressWarnings("serial")
@Entity
public class Customer extends AbstractEntity {


private String name;
private String adresse;
private int number;

@Column(name = "enabled", nullable = false)
private Boolean enabled;

public Boolean getEnabled() {
	return enabled;
}

public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
}

public Customer() {
    // JPA
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
	return "Customer [name=" + name + ", adresse=" + adresse + ", number=" + number + ", enabled=" + enabled + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
	result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
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
	if (enabled == null) {
		if (other.enabled != null)
			return false;
	} else if (!enabled.equals(other.enabled))
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
