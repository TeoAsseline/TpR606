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
	
	public String situation() {
		double totalDu = 0;
		int pointsFidelites = 0;
		Iterator<Location> forEach = locations.iterator();
		String result = "<h1>Situation du client: " + getNom() + "</h1>\n<ul>";
		
		while (forEach.hasNext()) {
			double du = 0;
			Location each = (Location) forEach.next();
			
			//determine le montant de chaque location
			switch (each.getFilm().getCodePrix()) {
			case Film.NORMAL:
				du += 2;
				if (each.getNbJours() > 2) 
					du += (each.getNbJours() - 2) * 1.5;
				pointsFidelites++;
				break;
			case Film.NOUVEAUTE:
				du += each.getNbJours() * 3;
				pointsFidelites++;
				if (each.getNbJours() > 1)
					pointsFidelites++;
				break;
			case Film.ENFANT:
				du += 1.5;
				if (each.getNbJours() > 3)
					du += (each.getNbJours() - 3) * 1.5;
				pointsFidelites++;
				break;
			case Film.COFFRETSERIESTV:
				du += each.getNbJours() * 0.5;
				break;
			case Film.CINEPHILE:
				du += 2;
				if (each.getNbJours() > 1)
					du += (each.getNbJours() - 1) * 4;
				pointsFidelites += 3;
			}
			
			// mise en forme location
			result += "<li>\t" + each.getFilm().getTitre() + "\t" + String.valueOf(du) + "</li>\n";
			totalDu += du;
		}
		
		// ajout recapitulatif client
		result += "</ul><h3>Total du " + String.valueOf(totalDu) + "</h3>\n";
		result += "<h3>Vous gagnez " + String.valueOf(pointsFidelites) + " points de fidelite</h3>\n";
		
		return result;
	}

}
