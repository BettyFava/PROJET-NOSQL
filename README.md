# Projet-I4-NoSQL
##Introduction
###Objectif

Vous avez réalisé un site de blogging pour une société X, cette société peut décider de vous confier l'installation et la maintenance dudit site ou son exploitation, mais elle pourrait également décider de confier tout ou partie de ces tâche à une autre équipe et dans ce cas cette nouvelle équipe aurait besoin d'un minimum d'information pour assurer le bon fonctionnement de votre site.  

Ce site de blogging peut être accompagné d’une partie e-commerce, d’une plateforme d’échange entre utilisateurs, d’une bibliothèque… Il respecte en tout cas la description ci-dessous:  
Un blog est un type de site web – ou une partie d'un site web – utilisé pour la publication périodique et régulière d'articles, généralement succincts, et rendant compte d'une actualité autour d'un sujet donné ou d'une profession. À la manière d'un journal de bord, ces articles ou « billets » sont typiquement datés, signés et se succèdent dans un ordre antéchronologique, c'est-à-dire du plus récent au plus ancien. Les articles peuvent recevoir des commentaires et être triés selon des mots-clefs.  

Le dossier de réalisation de votre site de blogging doit comporter les 6 points d’analyse présentés dans le présent document.  

Dans le cadre du cours NoSQL, vous devez davantage insister sur la gestion des données avec MongoDB.

###Remarque
Votre dossier de réalisation doit être clair et structuré, il ne doit pas comporter de fautes d'orthographe : Si une société vous demandait d'installer ou d'administrer un site, accepteriez vous un brouillon pour tout document de travail ?

###Bibliographie
Après de courtes recherches vous constaterez que le sujet est intégralement traité dans la bibliographie accessible gratuitement sur internet (consulté le 31/03/2014).
Vous pouvez vous inspirez des exemples ci-après:
- MongoDB et Python : http://docs.mongodb.org/ecosystem/tutorial/write-a-tumblelog-application-with-flask-mongoengine/
- MongoDB et Node.js : http://veebdev.wordpress.com/2012/03/08/creating-simple-blog-with-node-js-express-and-mongodb/ ou http://howtonode.org/express-mongodb 
- MongoDB et PHP : http://www.sitepoint.com/building-simple-blog-app-mongodb-php/

##Points d’analyse
###Le Contexte 
Le cadre du projet, le besoin en général. 
Vous expliquerez quel sujet couvre votre blog et la dimension sociale que vous souhaitez lui donner. Vous expliciterez comment les visiteurs du blog peuvent participer à l’animation du site. (Articles, commentaires d’articles, votes (« like ») partie e-commerce …)
 Vous devez imaginer un site ouvert et participatif.

###Les fonctionnalités attendues 
Le besoin de façon plus détaillé.

###Les différentes technologies utilisées 
MongoDB sera votre mode de stockage de données. Vous détaillerez comment l’interfacer avec les autres langages utiles à la création de votre blog. Vous êtes libres de choisir les technologies employées.
- PHP, 
- JavaScript, 
- CSS, 
- Python
- Ruby
- Node.js  ... 

###L'architecture des données et les requêtes
- Comment allez-vous organiser votre ou vos fichiers JSON pour permettre la consultation du site, blog ou autre, en permettant de sélectionner et d’afficher le contenu désiré, filtré de telle ou telle manière, par un visiteur connu (enregistré) ou non ?
- Vous expliciterez vos choix et vous détaillerez les requêtes associées.

###Les sauvegardes/restaurations 
- Quelles données faut-il sauvegarder, à quelle cadence et avec quels outils ? 
- Avec quels outils restaure-t-on les données sauvegardées. 

###Le manuel d'administration 
Comment effectuer les tâches d'administration ou d'exploitation fonctionnelle du site et en particulier de la base de données, par exemple : 
- Mise à jour du contenu du site 
- Monitoring général de la base de données
- Supervision du Forum 
- Etc. 
