package src;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ScenarioPART2 {
	
	public String testSituation(String nomClient, String nomFilm, int typeFilm, int nbJours ) {
		ClientPART2 unClient = new ClientPART2(nomClient);
		FilmPART2 unFilm = new FilmPART2(nomFilm, typeFilm);
		unFilm.setCodePrix(typeFilm);
		LocationPART2 uneLocation = new LocationPART2(unFilm, nbJours);
		unClient.addLocation(uneLocation);
		return unClient.situation();
	}
	
	public void testSituationCumul(ClientPART2 unClient, String nomFilm, int typeFilm, int nbJours) {
		FilmPART2 unFilm = new FilmPART2(nomFilm, typeFilm);
		unFilm.setCodePrix(typeFilm);
		LocationPART2 uneLocation = new LocationPART2(unFilm, nbJours);
		unClient.addLocation(uneLocation);
	}
	@Test
	// test location film normal d'une duree inferieure a 3 jours
	public void testlocationfilmnormalmoinsde3jours() {
		ScenarioPART2 sc = new ScenarioPART2();
		String attendu  = "<h1>Situation du client: un client</h1>\n"
						+ "<ul><li>\tTaxi Driver\t2.0</li>\n"
						+ "</ul><h3>Total du 2.0</h3>\n"
						+ "<h3>Vous gagnez 1 points de fidelite</h3>\n";
		String obtenu = sc.testSituation("un client","Taxi Driver",FilmPART2.NORMAL,2);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film normal d'une duree d'au moins 3 jours
	public void testlocationfilmnormalplusde3jours() {
		ScenarioPART2 sc = new ScenarioPART2();
		String attendu  = "<h1>Situation du client: un client</h1>\n"
			+ "<ul><li>\tTaxi Driver\t3.5</li>\n"
			+ "</ul><h3>Total du 3.5</h3>\n"
			+ "<h3>Vous gagnez 1 points de fidelite</h3>\n";
		String obtenu = sc.testSituation("un client","Taxi Driver",FilmPART2.NORMAL,3);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film nouveauté d'une duree inferieure à 2 jours
	public void testlocationfilmnouveautemoinsde2jours() {
		ScenarioPART2 sc = new ScenarioPART2();
		String attendu  = "<h1>Situation du client: un client</h1>\n"
		+ "<ul><li>\t11 heures 14\t3.0</li>\n"
		+ "</ul><h3>Total du 3.0</h3>\n"
		+ "<h3>Vous gagnez 1 points de fidelite</h3>\n";
		String obtenu = sc.testSituation("un client","11 heures 14",FilmPART2.NOUVEAUTE,1);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film nouveaute d'une duree d'au moins 2 jours
	public void testlocationfilmnouveauteplusde2jours() {
		ScenarioPART2 sc = new ScenarioPART2();
		String attendu  = "<h1>Situation du client: un client</h1>\n"
		+ "<ul><li>\t11 heures 14\t12.0</li>\n"
		+ "</ul><h3>Total du 12.0</h3>\n"
		+ "<h3>Vous gagnez 2 points de fidelite</h3>\n";
		String obtenu = sc.testSituation("un client","11 heures 14",FilmPART2.NOUVEAUTE,4);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film enfant d'une duree inf�rieure a 4 jours
	public void testlocationfilmenfantmoinsde4jours() {
		ScenarioPART2 sc = new ScenarioPART2();
		String attendu  = "<h1>Situation du client: un client</h1>\n"
		+ "<ul><li>\tCendrillon\t1.5</li>\n"
		+ "</ul><h3>Total du 1.5</h3>\n"
		+ "<h3>Vous gagnez 1 points de fidelite</h3>\n";
		String obtenu = sc.testSituation("un client","Cendrillon",FilmPART2.ENFANT,3);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film enfant d'une duree d'au moins 4 jours
	public void testlocationfilmenfantplusde4jours() {
		ScenarioPART2 sc = new ScenarioPART2();
		String attendu  = "<h1>Situation du client: un client</h1>\n"
		+ "<ul><li>\tCendrillon\t3.0</li>\n"
		+ "</ul><h3>Total du 3.0</h3>\n"
		+ "<h3>Vous gagnez 1 points de fidelite</h3>\n";
		String obtenu = sc.testSituation("un client","Cendrillon",FilmPART2.ENFANT,4);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film coffretseriestv
	public void testlocationfilmcoffretseriestv(){
		ScenarioPART2 sc = new ScenarioPART2();
		String attendu  = "<h1>Situation du client: un client</h1>\n"
		+ "<ul><li>\tCoffret series TV\t1.5</li>\n"
		+ "</ul><h3>Total du 1.5</h3>\n"
		+ "<h3>Vous gagnez 0 points de fidelite</h3>\n";
		String obtenu = sc.testSituation("un client","Coffret series TV",FilmPART2.COFFRETSERIESTV,3);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film cinephile d'une duree inferieure a 2 jours
	public void testlocationfilmcinephilemoinsde2jours() {
		ScenarioPART2 sc = new ScenarioPART2();
		String attendu  = "<h1>Situation du client: un client</h1>\n"
		+ "<ul><li>\tCinephile\t2.0</li>\n"
		+ "</ul><h3>Total du 2.0</h3>\n"
		+ "<h3>Vous gagnez 3 points de fidelite</h3>\n";
		String obtenu = sc.testSituation("un client","Cinephile",FilmPART2.CINEPHILE,1);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test location film cinephile d'une duree d'au moins 2 jours
	public void testlocationfilmcinephileplusde2jours() {
		ScenarioPART2 sc = new ScenarioPART2();
		String attendu  = "<h1>Situation du client: un client</h1>\n"
		+ "<ul><li>\tCinephile\t10.0</li>\n"
		+ "</ul><h3>Total du 10.0</h3>\n"
		+ "<h3>Vous gagnez 3 points de fidelite</h3>\n";
		String obtenu = sc.testSituation("un client","Cinephile",FilmPART2.CINEPHILE,3);
		assertEquals(attendu, obtenu);
	}
	@Test
	// test cumul de locations
	public void testcumullocations() {
		ScenarioPART2 sc = new ScenarioPART2();
		ClientPART2 unClient = new ClientPART2("client cumul");
		sc.testSituationCumul(unClient,"Taxi Driver",FilmPART2.NORMAL,2);
		sc.testSituationCumul(unClient,"11 heures 14",FilmPART2.NOUVEAUTE,1);
		sc.testSituationCumul(unClient,"Cendrillon",FilmPART2.ENFANT,2);
		String attendu = "<h1>Situation du client: client cumul</h1>\n"
			+ "<ul><li>\tTaxi Driver\t2.0</li>\n"
			+ "<li>\t11 heures 14\t3.0</li>\n"
			+ "<li>\tCendrillon\t1.5</li>\n"
			+ "</ul><h3>Total du 6.5</h3>\n"
			+ "<h3>Vous gagnez 3 points de fidelite</h3>\n";
		String obtenu = unClient.situation();
		assertEquals(attendu, obtenu);
	}
}