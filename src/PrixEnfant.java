package src;

public class PrixEnfant extends Prix{

	@Override
	public int getType() {
		return ENFANT;
	}

	@Override
	public double getMontant(int nbJours) {
		double montant = 0;
		montant += 1.5;
		if (nbJours > 3) {
			montant += (nbJours - 3) * 1.5;
		}
		return montant;
	}

	@Override
	public int getPointsFidelites(int nbJours) {
		return 1;
	}
}
