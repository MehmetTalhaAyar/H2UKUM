package com.H2UKUM.Hukum.Services.concretes;

import org.springframework.stereotype.Service;

import com.H2UKUM.Hukum.DataAccess.GameTypeRepository;
import com.H2UKUM.Hukum.Models.GameType;
import com.H2UKUM.Hukum.Models.User;
import com.H2UKUM.Hukum.Models.requests.PostCreateGameTypeRequest;

@Service
public class GameTypeService {
    
    private GameTypeRepository gameTypeRepository;

    public GameTypeService(GameTypeRepository gameTypeRepository) {
        this.gameTypeRepository = gameTypeRepository;
    }

    public GameType findById(long id){
        return gameTypeRepository.findById(id).orElse(null);
    }



    public GameType createGameType(User user,PostCreateGameTypeRequest postCreateGameTypeRequest){

        GameType newGameType = new GameType();

        newGameType.setCreatedById(user);
        newGameType.setName(postCreateGameTypeRequest.getName());

        return gameTypeRepository.save(newGameType);

    }

    



}
