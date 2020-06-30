package aaryan.microservices.beerbrewary.services;

import aaryan.microservices.beerbrewary.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getbeerbyId();

    BeerDto savenewBeer();

    void updateBeer(UUID beerid, BeerDto beerdto);

    void deletebeer(UUID beerid);
}
