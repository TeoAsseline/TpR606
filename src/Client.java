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
	
	public String situation() {
		int pointsFidelites = 0;
		Iterator<Location> forEach = locations.iterator();
		String result = "Situation du client: " + getNom() + "\n";
		
		while (forEach.hasNext()) {
			Location each = (Location) forEach.next();
			// ajout des points de fidelite
			pointsFidelites++;
			// ajout d'un bonus pour les nouveautes louees depuis au moins deux jours
			if ((each.getFilm().getCodePrix() == Film.NOUVEAUTE) && each.getNbJours() > 1) 
				pointsFidelites++;
			
			// mise en forme location
			result += "\t" + each.getFilm().getTitre() + "\t" + String.valueOf(each.getmontant()) + "\n";
		}
		
		// ajout recapitulatif client
		result += "Total du " + String.valueOf(this.getTotalMontant()) + "\n";
		result += "Vous gagnez " + String.valueOf(pointsFidelites) + " points de fidelite\n";
		
		return result;
	}

}
