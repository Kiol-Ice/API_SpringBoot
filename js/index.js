console.log("Test API")

const axios = require('axios');

const apiUrl = 'http://localhost:9000';

// Fonction pour gérer les erreurs
const handleError = (error) => {
  console.error('Erreur:', error.message);
  if (error.response) {
    console.error('Réponse de l\'API:', error.response.data);
  }
};

// Exemple de requête POST (Create)
const newData = {
    "team": {
        "name": "PSG",
        "currentTournament": "ligue 1",
        "level": 2
    },
    "firstName": "loick",
    "lastName": "ramadier",
    "position": "attaquant"
};

const resourceIdToUpdate = '1';
const updatedData = {
    "team": {
        "id":1,
        "name": "ASSE",
        "currentTournament": "ligue 1",
        "level": 2
    },
    "firstName": "loick",
    "lastName": "ramadier",
    "position": "defenseur"
};

const resourceIdToDelete = '1';

  // Fonction asynchrone pour effectuer toutes les opérations CRUD
const performCrudOperations = async () => {
    try {
    // Requête POST (Create)
        const postResponse = await axios.post(`${apiUrl}/player`, newData);
        console.log('Résultat de la requête POST:', postResponse.data);

        // Requête GET (Read)
        const getResponse = await axios.get(`${apiUrl}/players`);
        console.log('Résultat de la requête GET:', getResponse.data);
    
        // Requête PUT (Update)
        const resourceIdToUpdate = '1';
        const putResponse = await axios.put(`${apiUrl}/player/${resourceIdToUpdate}`, updatedData);
        console.log('Résultat de la requête PUT:', putResponse.data);
    
        // Requête DELETE (Delete)
        const resourceIdToDelete = '1';
        // await axios.delete(`${apiUrl}/player/${resourceIdToDelete}`);
        // console.log('Ressource supprimée avec succès.');

    } catch (error) {
        handleError(error);
    }
};
  
// Appel de la fonction principale
performCrudOperations();
