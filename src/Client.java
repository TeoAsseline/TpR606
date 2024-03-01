package src;

import java.util.LinkedList;
import java.util.List;

public class Client {
	private String nom;
	private List<Location> locations = new LinkedList<Location>();
	
	public Client(String nom) {
		this.nom = nom;
	}
	
	public void addLocation(Location location) {
		this.locations.add(location);
	}
	
	public String getNom() {
		return this.nom;
	}

	public List<Location> getLocations() {
		return locations;
	}
	
	public double getTotalMontant() {
		double total=0;
		for(Location location:this.locations) {
			total+=location.getmontant();
		}
		return total;
	}
	
	public int getTotalPointsFidelites() {
		int total=0;
		for(Location location:this.locations) {
			total+=location.getpointsfidelites();
		}
		return total;
	}
}
