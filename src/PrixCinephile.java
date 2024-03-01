package src;

public class PrixCinephile extends Prix{

	@Override
	public int getType() {
		return COFFRETSERIESTV;
	}

	@Override
	public double getMontant(int nbJours) {
		double montant = 2;
		if (nbJours > 1) {
			montant += (nbJours - 1) * 4;
		}
		return montant;
	}

	@Override
	public int getPointsFidelites(int nbJours) {
		return 3;
	}
}
