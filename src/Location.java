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
		return unFilm.getmontant(this);
	}

	int getpointsfidelites() {
		return unFilm.getpointsfidelites(this);
	}
	
}