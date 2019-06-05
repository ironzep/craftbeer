package com.beerhouse.bootstrap;

import com.beerhouse.models.Beer;
import com.beerhouse.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private BeerRepository beerRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.initData();
    }

    private void initData(){

        this.beerRepository.save(new Beer("Colonial", "Água, Malte e Lúpulo", "6%", 15, "IPA"));
        this.beerRepository.save(new Beer("Brahma", "Água e Milho", "4%", 5, "Pilsen"));
        this.beerRepository.save(new Beer("Paulaner", "Água, Trigo e Lúpulo", "6%", 5, "Weiss"));
        this.beerRepository.save(new Beer("Heineken", "Água, Malte e Lúpulo", "5%", 5, "Lager"));

    }
}
