package src;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Scenario {
	
	public String testSituation(String nomClient, String nomFilm, int codePrix, int nbJours, int codeStatement) {
		Client unClient = new Client(nomClient);
		Prix typePrix = Prix.setCodePrix(codePrix);
		Film unFilm = new Film(nomFilm, typePrix);
		Location uneLocation = new Location(unFilm, nbJours);
		Statement typeStatement = Statement.setCodeStatement(codeStatement);
		unClient.addLocation(uneLocation);
		return typeStatement.getSituation(unClient);
	}
	
	public void testSituationCumul(Client unClient, String nomFilm, int codePrix, int nbJours) {
		Prix typePrix = Prix.setCodePrix(codePrix);
		Film unFilm = new Film(nomFilm, typePrix);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
	}

	public String testSituationCumulResult(Client unClient, int codeStatement) {
		Statement typeStatement = Statement.setCodeStatement(codeStatement);
		return typeStatement.getSituation(unClient);
	}
	@Test
	// test location film normal d'une duree inferieure a 3 jours
	public void testlocationfilmnormalmoinsde3jours() {
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
						+ "\tTaxi Driver\t2.0\n"
						+ "Total du 2.0\n"
						+ "Vous gagnez 1 points de fidelite\n";
		String obtenu = sc.testSituation("un client","Taxi Driver",Prix.NORMAL,2,Statement.NORMAL);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film normal d'une duree d'au moins 3 jours
	public void testlocationfilmnormalplusde3jours() {
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
			+ "\tTaxi Driver\t3.5\n"
			+ "Total du 3.5\n"
			+ "Vous gagnez 1 points de fidelite\n";
		String obtenu = sc.testSituation("un client","Taxi Driver",Prix.NORMAL,3,Statement.NORMAL);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film nouveauté d'une duree inferieure à 2 jours
	public void testlocationfilmnouveautemoinsde2jours() {
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
		+ "\t11 heures 14\t3.0\n"
		+ "Total du 3.0\n"
		+ "Vous gagnez 1 points de fidelite\n";
		String obtenu = sc.testSituation("un client","11 heures 14",Prix.NOUVEAUTE,1,Statement.NORMAL);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film nouveaute d'une duree d'au moins 2 jours
	public void testlocationfilmnouveauteplusde2jours() {
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
		+ "\t11 heures 14\t12.0\n"
		+ "Total du 12.0\n"
		+ "Vous gagnez 2 points de fidelite\n";
		String obtenu = sc.testSituation("un client","11 heures 14",Prix.NOUVEAUTE,4,Statement.NORMAL);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film enfant d'une duree inf�rieure a 4 jours
	public void testlocationfilmenfantmoinsde4jours() {
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
		+ "\tCendrillon\t1.5\n"
		+ "Total du 1.5\n"
		+ "Vous gagnez 1 points de fidelite\n";
		String obtenu = sc.testSituation("un client","Cendrillon",Prix.ENFANT,3,Statement.NORMAL);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film enfant d'une duree d'au moins 4 jours
	public void testlocationfilmenfantplusde4jours() {
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
		+ "\tCendrillon\t3.0\n"
		+ "Total du 3.0\n"
		+ "Vous gagnez 1 points de fidelite\n";
		String obtenu = sc.testSituation("un client","Cendrillon",Prix.ENFANT,4,Statement.NORMAL);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location coffret séries TV d'une duree de 6 jours
	public void testlocationcoffretseriesTV() {
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
		+ "\tNarcos\t3.0\n"
		+ "Total du 3.0\n"
		+ "Vous gagnez 0 points de fidelite\n";
		String obtenu = sc.testSituation("un client","Narcos",Prix.COFFRETSERIESTV,6,Statement.NORMAL);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film cinéphile d'une duree d'un jour
	public void testlocationfilmcinephile1jour() {
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
		+ "\tLe Parrain\t2.0\n"
		+ "Total du 2.0\n"
		+ "Vous gagnez 3 points de fidelite\n";
		String obtenu = sc.testSituation("un client","Le Parrain",Prix.CINEPHILE,1,Statement.NORMAL);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film cinephile d'une duree d'au moins 2 jours
	public void testlocationfilmcinephileplusde2jours() {
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
		+ "\tLe Parrain\t10.0\n"
		+ "Total du 10.0\n"
		+ "Vous gagnez 3 points de fidelite\n";
		String obtenu = sc.testSituation("un client","Le Parrain",Prix.CINEPHILE,3,Statement.NORMAL);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test cumul de locations
	public void testcumullocations() {
		Scenario sc = new Scenario();
		Client unClient = new Client("client cumul");
		sc.testSituationCumul(unClient,"Taxi Driver",Prix.NORMAL,2);
		sc.testSituationCumul(unClient,"11 heures 14",Prix.NOUVEAUTE,1);
		sc.testSituationCumul(unClient,"Cendrillon",Prix.ENFANT,2);
		String attendu = "Situation du client: client cumul\n"
			+ "\tTaxi Driver\t2.0\n"
			+ "\t11 heures 14\t3.0\n"
			+ "\tCendrillon\t1.5\n"
			+ "Total du 6.5\n"
			+ "Vous gagnez 3 points de fidelite\n";
		String obtenu = sc.testSituationCumulResult(unClient,Statement.NORMAL);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film enfant d'une duree d'au moins 4 jours en format HTML
	public void testlocationfilmaffichagehtml() {
		Scenario sc = new Scenario();
		String attendu  = "<h1>Situation du client: un client</h1>\n"
		+ "<ul><li>\tCendrillon\t3.0</li>\n"
		+ "</ul><h3>Total du 3.0\n"
		+ "Vous gagnez 1 points de fidelite\n</h3>";
		String obtenu = sc.testSituation("un client","Cendrillon",Prix.ENFANT,4,Statement.HTML);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test cumul de locations format HTML
	public void testcumullocationsformathtml() {
		Scenario sc = new Scenario();
		Client unClient = new Client("client cumul");
		sc.testSituationCumul(unClient,"Taxi Driver",Prix.NORMAL,2);
		sc.testSituationCumul(unClient,"11 heures 14",Prix.NOUVEAUTE,1);
		sc.testSituationCumul(unClient,"Cendrillon",Prix.ENFANT,2);
		String attendu = "<h1>Situation du client: client cumul</h1>\n"
			+ "<ul><li>\tTaxi Driver\t2.0</li>\n"
			+ "<li>\t11 heures 14\t3.0</li>\n"
			+ "<li>\tCendrillon\t1.5</li>\n"
			+ "</ul><h3>Total du 6.5\n"
			+ "Vous gagnez 3 points de fidelite\n</h3>";
		String obtenu = sc.testSituationCumulResult(unClient,Statement.HTML);
		assertEquals(attendu, obtenu);
	}
}