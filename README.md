# IA54-Taquin

installer git : 
	1) télécharger et installer git http://git-scm.com/downloads 
		une documentation est disponible sur le site.
		Je vous conseille de lire au moins les 3 premiers chapitre pour comprendre comment fonctionne git
	2) démarrer git_bash
	3) entrer les paramètres personnels pour vous identifer lors d'un commit
		git config --global user.name [votre nom]
		git config --global user.email [votre adresse]
	4) (facultatif) vous pouvez aussi choisir votre éditeur de texte par défaut (il sert à entrer les notes de commit et à réaliser les merge)
		git config --global core.editor "'[chemin complet de votre editeur]' -multiInst -nosession"
	5) modifier le paramètre de push par défaut : 
		git config --global push.default matching

récupérer le projet : 
	1) démarrer git bash et vous placer dans le dossier dans lequel vous voulez récupérer le projet
		par exemple 'eclipse\ SARL/workspace'
	2) récupérer le lien https du projet github
	3) taper la commande git clone [adresse https]

ouvrir le projet avec eclipse SARL : 
	1) démarer eclipse SARL
	2) file/import/existing project into workspace
		sélectionner le dossier du projet et valider
	3) project/clean
	4) si des erreurs de build path apparaissent
		click droit sur le projet, Build Path/configure Build Path...
		dans l'onglet source, supprimer les folders posant problème et les recréer/ajouter
	5) project/clean
	6) vérifier que les classes java sont apparues dans le dossier src/main/generated-sources/xtend
		Si ce n'est pas le cas, clic droit sur le projet, properties, SARL/compiler
			Cocher Enable Project specific settings et dans output folder, mettre ./src/main/generated-sources/xtend
	
Lancer le projet SARL : 
	1) clic droit sur le ficher SARL à lancer, run as/run configurations... , SARL Application
	2) dans l'onglet main, entrer le chemin de l'agent dans AAgent qualified name
	3) dans l'onglet argument, taper -R dans Argument for the SARL runtime environment (SRE)
	4) dans l'onglet runtime environment, cocher Use a SRE et selectionner le jar Janus
	5) cliquer sur apply puis run

récupérer les modification : 
	1) démarrer git_bash
	2) se placer à l'intérieur le dossier du projet
	Si vous n'avez rien modifié depuis votre dernière récupération : 
		Taper git pull 
		ou 
		git fetch suivi de git rebase
	Si vous avez fait des modification entre temps, si vos modifications sont commit,
		Taper git fetch suivi de git rebase
		
Upload des modification : 
	1) s'inscrire sur github https://github.com/ et me donner votre nom d'utilisateur pour que je vous ajoute aux collaborateurs
	2) démarrer git_bash
	3) se placer à l'intérieur du dossier du projet
	4) taper 'git add .' pour valider vos modifications
	5) taper git commit pour commit les modifications
	6) entrer un descriptif de commit
	7) INMPORTANT !!!!! taper git fetch pour récupérer les modification upload depuis votre dernière récupération
	8) TOUT AUSSI IMPORTANT !!! taper git rebase pour fusionner vos modification avec celles récupérées
	9) si besoin résoudre les conflits remontés par git
	10) taper git push et se logger pour envoyer vos modifications sur github

	
Lien vers la cheatsheet git qui résume les commande git : 
http://ndpsoftware.com/git-cheatsheet.html#loc=stash;