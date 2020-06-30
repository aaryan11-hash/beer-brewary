package aaryan.microservices.beerbrewary.services;

import aaryan.microservices.beerbrewary.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.logging.Logger;

@Slf4j
@Service
@Component
public class beerServiceimpl implements BeerService {
    private Logger logger=Logger.getLogger(getClass().getName());
    @Override
    public BeerDto getbeerbyId() {
        return BeerDto.builder().id(UUID.randomUUID())
                .beername("Galaxy cat")
                .beerstyle("bohemian").build();
    }

    @Override
    public BeerDto savenewBeer() {
        return BeerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerid, BeerDto beerdto) {
        //todo impl-would add a real impl to implement beer
    }

    @Override
    public void deletebeer(UUID beerid) {
        log.debug("deleting a beer");
    }
}
