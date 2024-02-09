package src;

import java.util.Iterator;
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
	
	public double getTotalMontant() {
		double total=0;
		for(Location location:this.locations) {
			total+=location.getmontant();
		}
		return total;
	}
	
	public int getTotalpointsfidelites() {
		int total=0;
		for(Location location:this.locations) {
			total+=location.getpointsfidelites();
		}
		return total;
	}
	
	public String situation() {
		Iterator<Location> forEach = locations.iterator();
		String result = "Situation du client: " + getNom() + "\n";
		while (forEach.hasNext()) {
			Location each = (Location) forEach.next();
			// mise en forme location
			result += "\t" + each.getFilm().getTitre() + "\t" + String.valueOf(each.getmontant()) + "\n";
		}
		// ajout recapitulatif client
		result += "Total du " + String.valueOf(this.getTotalMontant()) + "\n";
		result += "Vous gagnez " + String.valueOf(this.getTotalpointsfidelites()) + " points de fidelite\n";
		
		return result;
	}

}
