package src;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Scenario {
	
	public String testSituation(String nomClient, String nomFilm, int typeFilm, int nbJours ) {
		Client unClient = new Client(nomClient);
		Film unFilm = new Film(nomFilm, typeFilm);
		unFilm.setCodePrix(typeFilm);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
		return unClient.situation();
	}
	
	public void testSituationCumul(Client unClient, String nomFilm, int typeFilm, int nbJours) {
		Film unFilm = new Film(nomFilm, typeFilm);
		unFilm.setCodePrix(typeFilm);
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
		String obtenu = sc.testSituation("un client","Taxi Driver",Film.NORMAL,2);
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
		String obtenu = sc.testSituation("un client","Taxi Driver",Film.NORMAL,3);
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
		String obtenu = sc.testSituation("un client","11 heures 14",Film.NOUVEAUTE,1);
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
		String obtenu = sc.testSituation("un client","11 heures 14",Film.NOUVEAUTE,4);
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
		String obtenu = sc.testSituation("un client","Cendrillon",Film.ENFANT,3);
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
		String obtenu = sc.testSituation("un client","Cendrillon",Film.ENFANT,4);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film coffretseriestv
	public void testlocationfilmcoffretseriestv(){
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
		+ "\tCoffret series TV\t1.5\n"
		+ "Total du 1.5\n"
		+ "Vous gagnez 0 points de fidelite\n";
		String obtenu = sc.testSituation("un client","Coffret series TV",Film.COFFRETSERIESTV,3);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film cinephile d'une duree inferieure a 2 jours
	public void testlocationfilmcinephilemoinsde2jours() {
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
		+ "\tCinephile\t2.0\n"
		+ "Total du 2.0\n"
		+ "Vous gagnez 3 points de fidelite\n";
		String obtenu = sc.testSituation("un client","Cinephile",Film.CINEPHILE,1);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film cinephile d'une duree d'au moins 2 jours
	public void testlocationfilmcinephileplusde2jours() {
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
		+ "\tCinephile\t10.0\n"
		+ "Total du 10.0\n"
		+ "Vous gagnez 3 points de fidelite\n";
		String obtenu = sc.testSituation("un client","Cinephile",Film.CINEPHILE,3);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test cumul de locations
	public void testcumullocations() {
		Scenario sc = new Scenario();
		Client unClient = new Client("client cumul");
		sc.testSituationCumul(unClient,"Taxi Driver",Film.NORMAL,2);
		sc.testSituationCumul(unClient,"11 heures 14",Film.NOUVEAUTE,1);
		sc.testSituationCumul(unClient,"Cendrillon",Film.ENFANT,2);
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