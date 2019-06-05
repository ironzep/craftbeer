package com.beerhouse.services;

import com.beerhouse.exception.BeerNotFoundException;
import com.beerhouse.exception.FieldPatchParseException;
import com.beerhouse.models.Beer;
import com.beerhouse.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;

    public List<Beer> getAll(){

        return beerRepository.findAll();
    }

    public Beer getBeerById(Long id){
        Beer beer = beerRepository.findOne(id);

        if(beer == null){
            throw new BeerNotFoundException(id);
        }

        return beer;
    }

    public Beer createOrUpdateBeer(Beer beer){
        return beerRepository.save(beer);
    }

    public Beer updateSpecificFields(Map<String, Object> map, Long id){
        Beer beer = beerRepository.findOne(id);

        if(beer == null){
            throw new BeerNotFoundException(id);

        }else{
            map.forEach((key, value) -> {
                try {
                    //If id is passed in the body of requisition, it needs to be the same of the id in parammeter
                    if(key.equals("id") && !value.equals(id)){
                        throw new FieldPatchParseException(key);
                    }

                    Field field = Beer.class.getDeclaredField(key);
                    ReflectionUtils.setField(field, beer,value);
                } catch (NoSuchFieldException e) {
                    throw new FieldPatchParseException(key);
                }
            });

            beerRepository.save(beer);

            return beer;
        }
    }


    public void deleteBeerById(Long id){
        Beer beer = beerRepository.findOne(id);

        if(beer == null){
            throw new BeerNotFoundException(id);
        }

        beerRepository.delete(beer);
    }

}
