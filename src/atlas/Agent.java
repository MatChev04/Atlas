package atlas;

import java.util.ArrayList;

public class Agent {

	/**
	 * Nom de l'agent
	 */
	public String nom;

	/**
	 * Pr�nom de l'agent
	 */
	public String prenom;

	/**
	 * Mission actuellement assign�e � l'agent
	 */
	public Mission missionEnCours;

	/**
	 * Agence employant l'agent
	 */
	public Agence agence;


	/**
	 * Missions d�ja effectu�es
	 */
	public ArrayList<Mission> missionReussies = new ArrayList<>();

	/**
	 * Niveau d'exp�rience l'agent
	 */
	public int niveau = 0;

	public void afficherMissionsDisponibles() {
		System.out.println("------------------------------");
		System.out.println("Missions disponibles:");
		if(agence!=null) {
			agence.afficherMissionsDisponibles(this);
		}
		else {
			System.out.println("Aucune, l'agent n'est pas employ� par une agence.");
		}
		System.out.println("------------------------------");
	}

	public void choisirMission(String code) {
		if(agence!=null) missionEnCours = agence.missionsMap.get(code.toLowerCase());
		afficherMissionEnCours();
	}

	public void afficherMissionEnCours() {
		if(missionEnCours!=null) {
			System.out.println("------------------------------");
			System.out.println("Mission assign�e : "+missionEnCours.code);
			System.out.println("Objectif : "+missionEnCours.objectif);
			System.out.println("------------------------------");

		}
		else {
			System.out.println("Aucune mission en cours.");
		}
	}

	public void afficherInformationsAgent() {
		System.out.println("------------------------------");
		System.out.println("Agent "+prenom+" "+nom);
		System.out.println("Agence actuelle : "+(agence!=null ? agence.nom : "Aucune"));
		System.out.println("Niveau d'exp�rience : "+niveau);
		System.out.println("Mission assign�e : "+(missionEnCours!=null ? missionEnCours.code : "Aucune"));
		System.out.println("------------------------------");
	}

	public void rejoindreAgence(String nomAgence) {
		agence = Agence.agences.get(nomAgence.toLowerCase());
	}

	public void accomplirMission(Solution solution) {
		if(missionEnCours!=null) {
			if(missionEnCours.testeSolution(solution)) {

				missionReussies.add(missionEnCours);
				missionEnCours = null;
			}
		} else {
			System.out.println("Aucune mission en cours.");
		}
	}
}
