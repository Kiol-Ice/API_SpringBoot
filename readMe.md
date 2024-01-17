# Projet API Spring Boot 

## API
- Lancement de l'api lors de l'éxecution du projet sur le port 9000
- console de la base de donnée H2 : http://localhost:9000/h2-console
- renseigner la clé présente dans la sortie pour se connecter
- L'API expose les routes basique du CRUD pour les entités Player et Team.

## Test PostMan
- Les exports de mes collections postMan pour les tests CRUD basique (Player et Team), sont disponible dans le dossier exportPostMan

## Test NodeJS
- le script index.js permet de lancer une série de requête à l'aide d'axios. Ces requêtes couvrent presques toutes les routes disponibles de l'API

- lancement du script :  
placement dans le dossier  
`cd js`  
installation des dépendances  
`npm i`  
execution  
`npm run-script test-api`  
execution bis  
`node ./index.js`  
