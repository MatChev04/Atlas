# Atlas

Il y a des Agent, qui peuvent rejoindre des Agence, qui proposent une liste de Mission, qui sont des actions à faire sur une liste de Cible. Pour cela il faut coder une Solution qui donne le résultat attendu pour la liste de Cible de la Mission. A chaque fois le problème est basé sur les données des Cible : elle contiennent leur nom, leur distance, leur connaissances des autres Cible, leur age, leur dangerosité.


Il faut créer une classe avec une méthode main.

Ensuite pour commencer, créez un Agent:
```
Agent agent = new Agent();
agent.nom = "Smith";
agent.prenom = "John";
```

Faites le rejoindre une agence:
```
agent.rejoindreAgence("Atlas");
```
Les agences correspondent au niveau de difficulté: chaque agence propose une liste de mission dans son niveau, et quand suffisament de ces missions ont été réussies on peut rejoindre l'agence suivante.

Pour afficher les missions proposées, faire:
```
agent.afficherMissionsDisponibles();
```

Puis en choisir une avec 
```
agent.choisirMission("Cible prioritaire");
```

Cela affichera l'objectif de la mission choisit. Par exemple, "Pour cette mission, il y a deux cibles. Renvoyer le nom de la cible la plus proche des deux."

Il faut donc coder une solution à cette mission, pour cela créer une classe SolutionMission1 qui implémente Solution, puis faire:

    Solution solution = new SolutionMission1();

    agent.accomplirMission(solution);
    
La solution doit implémenter une méthode public Object resoudre(Mission mission) qui retourne sous forme de String, int ou autre selon la mission, le resultat:

	@Override
	public Object resoudre(Mission mission) {
		if(mission.cibles[0].distance<mission.cibles[1].distance) {
			return mission.cibles[0].nom;
		}
		else {
			return mission.cibles[1].nom;
		}
	}

