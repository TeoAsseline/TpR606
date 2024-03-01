package src;

public class PrixNormal extends Prix {

	@Override
	public int getType() {
		return NORMAL;
	}

	@Override
	public double getMontant(int nbJours) {
		double montant = 0;
		montant += 2;
		if (nbJours > 2) {
			montant += (nbJours - 2) * 1.5;
		}
		return montant;
	}

	@Override
	public int getPointsFidelites(int nbJours) {
		return 1;
	}

}
