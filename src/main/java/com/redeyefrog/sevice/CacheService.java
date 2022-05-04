package com.redeyefrog.sevice;

import com.redeyefrog.model.FruitInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class CacheService {

    @Cacheable(cacheNames = "fruits", cacheManager = "fruitCacheManager")
    public List<String> findFruits() {
        log.info("execute findFruits...");

        return Stream.of("Apple", "Banana", "Orange").collect(Collectors.toList());
    }

    @Cacheable(cacheNames = "fruitsInfo")
    public List<FruitInfo> findFruitsInfo() {
        log.info("execute findFruitsInfo...");
        FruitInfo fruitInfo1 = new FruitInfo();
        fruitInfo1.setName("Apple");
        fruitInfo1.setPrice(10);
        fruitInfo1.setSize("Big");

        FruitInfo fruitInfo2 = new FruitInfo();
        fruitInfo2.setName("Apple");
        fruitInfo2.setPrice(3);
        fruitInfo2.setSize("small");

        FruitInfo fruitInfo3 = new FruitInfo();
        fruitInfo3.setName("Banana");
        fruitInfo3.setPrice(20);
        fruitInfo3.setSize("big");

        FruitInfo fruitInfo4 = new FruitInfo();
        fruitInfo4.setName("Banana");
        fruitInfo4.setPrice(10);
        fruitInfo4.setSize("small");

        FruitInfo fruitInfo5 = new FruitInfo();
        fruitInfo5.setName("Orange");
        fruitInfo5.setPrice(30);
        fruitInfo5.setSize("big");

        FruitInfo fruitInfo6 = new FruitInfo();
        fruitInfo6.setName("Orange");
        fruitInfo6.setPrice(3);
        fruitInfo6.setSize("small");

        return Stream.of(fruitInfo1, fruitInfo2, fruitInfo3, fruitInfo4, fruitInfo5, fruitInfo6).collect(Collectors.toList());
    }

}
