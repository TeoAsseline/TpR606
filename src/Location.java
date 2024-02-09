package src;
public class Location {
	private Film unFilm;
	private int nbJours;
	
	public Location(Film unFilm, int nbJours) {
		this.unFilm = unFilm;
		this.nbJours = nbJours;
	}

	public int getNbJours() {
		return this.nbJours;
	}

	public Film getFilm() {
		return this.unFilm;
	}
	
	double getmontant() {
		double montant=0;
		switch (getFilm().getCodePrix()) {
		case Film.NORMAL:
			montant += 2;
			if (getNbJours() > 2) 
				montant += (getNbJours() - 2) * 1.5;
			break;
		case Film.NOUVEAUTE:
			montant += getNbJours() * 3;
			break;
		case Film.ENFANT:
			montant += 1.5;
			if (getNbJours() > 3)
				montant += (getNbJours() - 3) * 1.5;
			break;
		}
		return montant;
	}
	
}