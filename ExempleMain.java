import atlas.Agent;
import atlas.Solution;


public class ExempleMain {
	public static void main(String args[]) {

		// on cr�� d'abord son objet Agent avec son nom et pr�nom
		Agent agent = new Agent();
		agent.nom = "Smith";
		agent.prenom = "John";


		// puis on rejoint une agence, il y en a actuellement 2, Atlas pour les premi�res missions et DGSE pour des missions plus complexes
		agent.rejoindreAgence("Atlas");

		agent.afficherInformationsAgent();

		// par cette commande on voit la liste des missions disponible
		agent.afficherMissionsDisponibles();


		// on en choisit une par son nom, cela a pour effet d'afficher le briefing
		agent.choisirMission("Cible prioritaire");
		// toutes les missions sont des probl�mes qui demandent de travailler sur un tableau d'objets Cible donn� en entr�, pour retourner un r�sultat pr�cis


		// on doit alors r�soudre la mission en cr�ant une classe qui implement Solution
		Solution solution = new ExempleSolutionMission1();
		agent.accomplirMission(solution);



		agent.afficherMissionsDisponibles();



		agent.choisirMission("Argent facile");

		solution = new ExempleSolutionMission2();
		agent.accomplirMission(solution);





		agent.afficherMissionsDisponibles();



		agent.choisirMission(3); // on peut aussi s�lectionner la mission par son num�ro

		solution = new ExempleSolutionMission3();
		agent.accomplirMission(solution);





	}
}
