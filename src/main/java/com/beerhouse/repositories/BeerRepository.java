package com.beerhouse.repositories;

import com.beerhouse.models.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {


}
