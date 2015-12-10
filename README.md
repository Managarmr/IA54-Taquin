# IA54-Taquin

Pour récupérer le projet:
1) Télécharger et installer git http://git-scm.com/downloads 
	une documentation très utile est disponible sur le site. 
	Je vous conseille de lire au moins les premiers chapitre pour comprendre comment fonctionne git

2) s'inscrire sur github https://github.com/ et me donner votre nom d'utilisateur

3) démarrer git_bash

4) se placer dans le dossier où vous souhaitez télécharger le projet

5) taper la commande : git clone [adresse https du projet github]

6) démarrer éclipse

7) importer le projet
	si des problèmes de build path apparaissent, faire un clic droit sur le projet, Build Path/configure Build Path
	dans l'onglet source, supprimer les source folders posant problème et les recréer/ajouter
	
8) clean le projet (Project/Clean)

9) vérifier que les classes java sont apparues dans le dossier src/main/generated-soucres/xtend
	si ce n'est pas le cas, click droit sur le projet, properties, SARL/compiler
		cocher Enable project specific settings et dasn output folder, mettre ./src/main/generated-sources/xtend
		
10) clic droit sur un fichier.sarl, run as/run configurations, SARL Application
	dans l'onglet main, entrer le chemin de l'agent dans Agent qualified name
	dans l'onglet, taper -R dans Arguments for the SARLruntime environment (SRE)
	dans l'onglet runtime environment, cocher Use a SRE et selectionner le Jar janus
	cliquer sur apply puis run
	
	
	
Pour upload des modification : 
	1) démarrer git_bash
	2) se placer à l'intérieur du dossier du projet
	3) taper git add . pour valider vos mofdifications
	4) taper git commit pour les commit
	5) entrer un descriptif de commit
	6) taper git fetch pour récupérer les modification upload depuis votre dernière récupération
	7) taper git rebase pour fusionner vos modifications avec celles récupérées
	8) taper git push et se logger pour envoyer vos modifications sur github
	
