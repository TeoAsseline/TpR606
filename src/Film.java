package src;
public class Film{
	
	private String titre;
	private Prix prix;
	
	public Film(String titre,Prix prix) {
		this.titre = titre;
		this.prix = prix;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setPrix(Prix prix) {
		this.prix = prix;
	}

	public Prix getPrix() {
		return this.prix;
	}

	double getmontant(Integer nbJours) {
		return prix.getMontant(nbJours);
	}

	int getpointsfidelites(Integer nbJours) {
		return prix.getPointsFidelites(nbJours);
	}
	
}