package src;
public class Film{
	
	public static final int ENFANT = 2;
	public static final int NOUVEAUTE = 1;
	public static final int NORMAL = 0;
	
	private String titre;
	private int codePrix;
	
	public Film(String titre,int codePrix) {
		this.titre = titre;
		this.codePrix = codePrix;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setCodePrix(int typeprix) {
		this.codePrix = new Prix(typeprix);
	}

	public int getCodePrix() {
		return this.codePrix;
	}

	double getmontant(Location location) {
		double montant=0;
		switch (location.getFilm().getCodePrix()) {
		case Film.NORMAL:
			montant += 2;
			if (location.getNbJours() > 2) 
				montant += (location.getNbJours() - 2) * 1.5;
			break;
		case Film.NOUVEAUTE:
			montant += location.getNbJours() * 3;
			break;
		case Film.ENFANT:
			montant += 1.5;
			if (location.getNbJours() > 3)
				montant += (location.getNbJours() - 3) * 1.5;
			break;
		}
		return montant;
	}

	int getpointsfidelites(Location location) {
		int pointsFidelites=0;
		// ajout des points de fidelite
		pointsFidelites++;
		// ajout d'un bonus pour les nouveautes louees depuis au moins deux jours
		if ((location.getFilm().getCodePrix() == Film.NOUVEAUTE) && location.getNbJours() > 1) 
			pointsFidelites++;
		return pointsFidelites;
	}
	
}