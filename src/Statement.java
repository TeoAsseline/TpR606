package src;

public abstract class Statement {

    public static final int NORMAL = 0;
    public static final int HTML = 1;

    public static Statement setCodeStatement(int type) {
        switch (type) {
            case NORMAL:
                return new TextStatement();
            case HTML:
                return new HtmlStatement();
        }
        throw new IllegalArgumentException("Type de statement inconnu");
    }

    public String getSituation(Client client) {
        String result = getSituationEntete(client);
        result += getSituationLocation(client);
        result += getSituationRecap(client);
        return result;
    }

    protected String getSituationEnteteCommon(Client client) {
        return "Situation du client: " + client.getNom();
    }

    protected String getSituationRecapCommon(Client client) {
        return "Total du " + String.valueOf(client.getTotalMontant()) + "\n" + "Vous gagnez " + String.valueOf(client.getTotalPointsFidelites()) + " points de fidelite\n";

    }

    public abstract String getSituationEntete(Client client);
	public abstract String getSituationLocation(Client client);
    public abstract String getSituationRecap(Client client);
}