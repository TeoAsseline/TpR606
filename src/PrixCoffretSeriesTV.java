package src;

public class PrixCoffretSeriesTV extends Prix{

	@Override
	public int getType() {
		return COFFRETSERIESTV;
	}

	@Override
	public double getMontant(int nbJours) {
		double montant = 0.5*nbJours;
		return montant;
	}

	@Override
	public int getPointsFidelites(int nbJours) {
		return 0;
	}
}
