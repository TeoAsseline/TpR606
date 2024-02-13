package src;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Scenario {
	
	public String testSituation(String nomClient, String nomFilm, int codePrix, int nbJours ) {
		Client unClient = new Client(nomClient);
		Prix TypePrix = Prix.setCodePrix(codePrix);
		Film unFilm = new Film(nomFilm, TypePrix);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
		return unClient.situation();
	}
	
	public void testSituationCumul(Client unClient, String nomFilm, int codePrix, int nbJours) {
		Prix typePrix = Prix.setCodePrix(codePrix);
		Film unFilm = new Film(nomFilm, typePrix);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
	}
	@Test
	// test location film normal d'une duree inferieure a 3 jours
	public void testlocationfilmnormalmoinsde3jours() {
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
						+ "\tTaxi Driver\t2.0\n"
						+ "Total du 2.0\n"
						+ "Vous gagnez 1 points de fidelite\n";
		String obtenu = sc.testSituation("un client","Taxi Driver",Prix.NORMAL,2);
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
		String obtenu = sc.testSituation("un client","Taxi Driver",Prix.NORMAL,3);
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
		String obtenu = sc.testSituation("un client","11 heures 14",Prix.NOUVEAUTE,1);
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
		String obtenu = sc.testSituation("un client","11 heures 14",Prix.NOUVEAUTE,4);
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
		String obtenu = sc.testSituation("un client","Cendrillon",Prix.ENFANT,3);
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
		String obtenu = sc.testSituation("un client","Cendrillon",Prix.ENFANT,4);
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
		String obtenu = unClient.situation();
		assertEquals(attendu, obtenu);
	}
}