package aaryan.microservices.beerbrewary.web.Controller;

import java.util.UUID;
import aaryan.microservices.beerbrewary.services.*;
import aaryan.microservices.beerbrewary.services.BeerService;
import aaryan.microservices.beerbrewary.web.Customerservice.CustomerService;
import aaryan.microservices.beerbrewary.web.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import aaryan.microservices.beerbrewary.web.model.BeerDto;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

	@Autowired
	private BeerService beerservice;





	@GetMapping("/{beerid}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerid){


		return new ResponseEntity<>(beerservice.getbeerbyId(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity handlePost(@RequestBody BeerDto beerDto){
		BeerDto beerdto=beerservice.savenewBeer();

		HttpHeaders headers=new HttpHeaders();
		//todo add hostname to url
		headers.add("Location","/api/v1/beer"+beerdto.getId().toString());

		return new ResponseEntity(headers,HttpStatus.CREATED);
	}

	@PutMapping("/{beerid}")
	public ResponseEntity handleUpdate(@PathVariable UUID beerid,@RequestBody BeerDto beerdto){

		beerservice.updateBeer(beerid,beerdto);

		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping({"/{beerid}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerid){
		beerservice.deletebeer(beerid);
	}

}
