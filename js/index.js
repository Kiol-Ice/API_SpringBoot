const axios = require('axios');

const apiUrl = 'http://localhost:9000';

// Fonction pour gérer les erreurs
const handleError = (error) => {
  console.error('Erreur:', error.message);
  if (error.response) {
    console.error('Réponse de l\'API:', error.response.data);
  }
};

const newPlayerWithTeam = {
    "team": {
        "name": "PSG",
        "currentTournament": "ligue 1",
        "level": 2
    },
    "firstName": "kylian",
    "lastName": "mbappe",
    "position": "attaquant"
};

const updatedPlayerAndTeam = {
    "team": {
        "name": "ASSE",
        "currentTournament": "ligue 2",
        "level": 1
    },
    "firstName": "kylian",
    "lastName": "mbappe",
    "position": "milieu"
};

const newPlayerToDelete = {
    "team": null,
    "firstName": "zinedine",
    "lastName": "zidane",
    "position": "milieu"
};

const performCrudOperationsForPlayer = async () => {
    try {
    // Requête POST (Create)
        const postResponse = await axios.post(`${apiUrl}/player`, newPlayerWithTeam);
        console.log('\nRésultat de la requête POST, création d\'un nouveau joueur :', postResponse.data);
        var idNewPlayer = postResponse.data.id;

        // Requête GET (Read)
        const getResponse = await axios.get(`${apiUrl}/players`);
        console.log('\nRésultat de la requête GET:', getResponse.data);
    
        // Requête PUT (Update)
        const putResponse = await axios.put(`${apiUrl}/player/${idNewPlayer}`, updatedPlayerAndTeam);
        console.log('\nRésultat de la requête PUT, modification du joueurs et de son équipe:', putResponse.data);
    
        // Requête GET (Read) de l'équipe du joueur par son id
        const getResponseTeamFromPlayer = await axios.get(`${apiUrl}/player/${idNewPlayer}/team`);
        console.log('\nRésultat de la requête GET, de l\'équipe du joueur par son id :', getResponseTeamFromPlayer.data);

        // Requête DELETE (Delete)
        const postResponseToDelete = await axios.post(`${apiUrl}/player`, newPlayerToDelete);
        console.log('\nRésultat de la requête POST:', postResponseToDelete.data);
        var idNewPlayerToDelete = postResponseToDelete.data.id;

        await axios.delete(`${apiUrl}/player/${idNewPlayerToDelete}`);
        console.log('\nPlayer', idNewPlayerToDelete ,' supprimée avec succès.');

    } catch (error) {
        handleError(error);
    }
};

const newTeamWithPlayer = {
    "playerList": [
        {
            "firstName": "pablo",
            "lastName": "neussaint",
            "position": "attaquant"
        },
        {
            "firstName": "jeremy",
            "lastName": "morel",
            "position": "millieu"
        },
        {
            "firstName": "loick",
            "lastName": "ramadier",
            "position": "defenseur"
        }
    ],
    "name": "Foo'Tse",
    "currentTournament": "aucun",
    "level": 0
};

const newTeamToDelete = {
    "playerList": [],
    "name": "FootLegends",
    "currentTournament": "aucun",
    "level": 2
};

const performCrudOperationsForTeam = async () => {
    try {
    // Requête POST (Create)
        const postResponse = await axios.post(`${apiUrl}/team`, newTeamWithPlayer);
        console.log('\nRésultat de la requête POST, création nouvelle équipe :', postResponse.data);
        var idNewteam = postResponse.data.id;

        // Requête GET (Read)
        const getResponse = await axios.get(`${apiUrl}/team/${idNewteam}`);
        console.log('\nRésultat de la requête GET de la nouvelle équipe :', getResponse.data);
    
        // Requête PUT (Update)
        const updatedTeamTournament = {
            "id": postResponse.data.id,
            "level": postResponse.data.level,
            "name": postResponse.data.name,
            "currentTournament": "tournoi BDE"
        };
        const putResponse = await axios.put(`${apiUrl}/team/${idNewteam}`, updatedTeamTournament);
        console.log('\nRésultat de la requête PUT, modification team:', putResponse.data);
    
        // Requête DELETE (Delete)
        const postResponseToDelete = await axios.post(`${apiUrl}/team`, newTeamToDelete);
        console.log('\nRésultat de la requête POST:', postResponseToDelete.data);
        var idNewteamToDelete = postResponseToDelete.data.id;
        
        await axios.delete(`${apiUrl}/team/${idNewteamToDelete}`);
        console.log('\nTeam ', idNewteamToDelete, ' supprimée avec succès.');

        // Requête GET (Read)
        const getResponsePlayers = await axios.get(`${apiUrl}/players`);
        console.log('\nRésultat de la requête GET de tous les joueurs:', getResponsePlayers.data);
        
        // Requête GET (Read) des joueurs d'une équipe
        const getResponsePlayerFromTeam = await axios.get(`${apiUrl}/team/${idNewteam}/players`);
        console.log('\nRésultat de la requête GET des joueurs de l\'équipe:', getResponsePlayerFromTeam.data);

    } catch (error) {
        handleError(error);
    }
};

// ----------------- Exec --------------------

const ApiTest = async () => {
    console.log("Test API Player")

    await performCrudOperationsForPlayer();

    console.log("Test API Team")

    await performCrudOperationsForTeam();
}

ApiTest();
