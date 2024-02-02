package src;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Scenario {
	
	public String testSituation(String nomClient, String nomFilm, int typeFilm, int nbJours ) {
		Client unClient = new Client(nomClient);
		Film unFilm = new Film(nomFilm, typeFilm);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
		return unClient.situation();
	}
	
	public void testSituationCumul(Client unClient, String nomFilm, int typeFilm, int nbJours) {
		Film unFilm = new Film(nomFilm, typeFilm);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
	}
	@Test
	public void test1() {
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
						+ "\tTaxi Driver\t2.0\n"
						+ "Total du 2.0\n"
						+ "Vous gagnez 1 points de fidelite\n";
		String obtenu = sc.testSituation("un client","Taxi Driver",Film.NORMAL,2);
		assertEquals(attendu, obtenu);
	}
	@Test
	public void test2() {
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
			+ "\tTaxi Driver\t3.5\n"
			+ "Total du 3.5\n"
			+ "Vous gagnez 1 points de fidelite\n";
		String obtenu = sc.testSituation("un client","Taxi Driver",Film.NORMAL,3);
		assertEquals(attendu, obtenu);
	}
	@Test
	public void test3() {
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
		+ "\t11 heures 14\t3.0\n"
		+ "Total du 3.0\n"
		+ "Vous gagnez 1 points de fidelite\n";
		String obtenu = sc.testSituation("un client","11 heures 14",Film.NOUVEAUTE,1);
		assertEquals(attendu, obtenu);
	}
	@Test
	public void test4() {
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
		+ "\t11 heures 14\t12.0\n"
		+ "Total du 12.0\n"
		+ "Vous gagnez 2 points de fidelite\n";
		String obtenu = sc.testSituation("un client","11 heures 14",Film.NOUVEAUTE,4);
		assertEquals(attendu, obtenu);
	}
	@Test
	public void test5() {
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
		+ "\tCendrillon\t1.5\n"
		+ "Total du 1.5\n"
		+ "Vous gagnez 1 points de fidelite\n";
		String obtenu = sc.testSituation("un client","Cendrillon",Film.ENFANT,3);
		assertEquals(attendu, obtenu);
	}
	@Test
	public void test6() {
		Scenario sc = new Scenario();
		String attendu  = "Situation du client: un client\n"
		+ "\tCendrillon\t3.0\n"
		+ "Total du 3.0\n"
		+ "Vous gagnez 1 points de fidelite\n";
		String obtenu = sc.testSituation("un client","Cendrillon",Film.ENFANT,4);
		assertEquals(attendu, obtenu);
	}
	@Test
	public void test7() {
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