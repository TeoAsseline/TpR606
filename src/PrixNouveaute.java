package src;

public class PrixNouveaute extends Prix {

	@Override
	public int getType() {
		return NOUVEAUTE;
	}

	@Override
	public double getMontant(int nbJours) {
		double montant = 0;
		montant += 3 * nbJours;
		return montant;
	}

	@Override
	public int getPointsFidelites(int nbJours) {
		if (nbJours > 1) 
			return 2;
		return 1;
	}
}
