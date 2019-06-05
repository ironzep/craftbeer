package com.beerhouse.controllers;

import com.beerhouse.exception.BeerNotFoundException;
import com.beerhouse.exception.FieldPatchParseException;
import com.beerhouse.models.Beer;
import com.beerhouse.repositories.BeerRepository;
import com.beerhouse.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RestController
public class BeerController {


    @Autowired
    private BeerService beerService;


    @GetMapping("/beers")
    public List<Beer> getBeers() {

        return beerService.getAll();
    }

    @PostMapping("/beers")
    @ResponseStatus(HttpStatus.CREATED)
    public Beer createBeer(@RequestBody Beer beer) {

        return beerService.createOrUpdateBeer(beer);
    }

    @GetMapping("/beers/{id}")
    public Beer getBeerById(@PathVariable Long id) {


        return beerService.getBeerById(id);
    }

    @PutMapping("/beers/{id}")
    public Beer saveOrUpdateBeer(@RequestBody Beer beer, @PathVariable Long id){
        return beerService.createOrUpdateBeer(beer);

    }

    @PatchMapping("beers/{id}")
    public Beer patchBeer(@RequestBody Map<String, Object> map, @PathVariable Long id) {

        return beerService.updateSpecificFields(map, id);
    }

    @DeleteMapping("/beers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable Long id) {
        beerService.deleteBeerById(id);
    }
}
