package src;

public abstract class Prix {

	public static final int ENFANT = 2;
	public static final int NOUVEAUTE = 1;
	public static final int NORMAL = 0;

	public static int Type;

	public abstract int getType();

    public static Prix setCodePrix(int type) {
	
		switch(type) {
		case NORMAL:
			return new PrixNormal();
		case NOUVEAUTE:
			return new PrixNouveaute();
		case ENFANT:
			return new PrixEnfant();
		}
		throw new IllegalArgumentException("Type de film inconnu");
	}
	
	public abstract double getMontant(int nbJours);

	public abstract int getPointsFidelites(int nbJours);
}