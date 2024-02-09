package src;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ClientPART2 {
	private String nom;
	private List<LocationPART2> locations = new LinkedList<LocationPART2>();
	
	public ClientPART2(String nom) {
		this.nom = nom;
	}
	
	public void addLocation(LocationPART2 location) {
		this.locations.add(location);
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String situation() {
		double totalDu = 0;
		int pointsFidelites = 0;
		Iterator<LocationPART2> forEach = locations.iterator();
		String result = "<h1>Situation du client: " + getNom() + "</h1>\n<ul>";
		
		while (forEach.hasNext()) {
			double du = 0;
			LocationPART2 each = (LocationPART2) forEach.next();
			
			//determine le montant de chaque location
			switch (each.getFilm().getCodePrix()) {
			case FilmPART2.NORMAL:
				du += 2;
				if (each.getNbJours() > 2) 
					du += (each.getNbJours() - 2) * 1.5;
				pointsFidelites++;
				break;
			case FilmPART2.NOUVEAUTE:
				du += each.getNbJours() * 3;
				pointsFidelites++;
				if (each.getNbJours() > 1)
					pointsFidelites++;
				break;
			case FilmPART2.ENFANT:
				du += 1.5;
				if (each.getNbJours() > 3)
					du += (each.getNbJours() - 3) * 1.5;
				pointsFidelites++;
				break;
			case FilmPART2.COFFRETSERIESTV:
				du += each.getNbJours() * 0.5;
				break;
			case FilmPART2.CINEPHILE:
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
