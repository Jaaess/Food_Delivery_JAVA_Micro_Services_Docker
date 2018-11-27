package com.ensi.ilsi.foodDelivery.Entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;


/**
 * Food.
 */


@SuppressWarnings("serial")
@Entity
public class Food extends AbstractEntity  {
	
    private String name;
    private double price;
    @ElementCollection
    private List<String> ingredients; 
	
    

    	public Food() {
    			// JPA
    		}
    
   


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<String> getIngredients() {
		return ingredients;
	}


	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Food [name=" + name + ", price=" + price + ", ingredients=" + ingredients + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Food other = (Food) obj;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	
    
    

}
