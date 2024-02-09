package src;
public class LocationPART2 {
	private FilmPART2 unFilm;
	private int nbJours;
	
	public LocationPART2(FilmPART2 unFilm, int nbJours) {
		this.unFilm = unFilm;
		this.nbJours = nbJours;
	}

	public int getNbJours() {
		return this.nbJours;
	}

	public FilmPART2 getFilm() {
		return this.unFilm;
	}
	
}