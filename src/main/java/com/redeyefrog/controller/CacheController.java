package com.redeyefrog.controller;

import com.redeyefrog.model.FruitInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.redeyefrog.sevice.CacheService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/findFruits")
    public List<String> findFruits() {
        return cacheService.findFruits();
    }

    @GetMapping("/find/{fruit}")
    public List<FruitInfo> findFruitInfo(@PathVariable String fruit) {
        List<FruitInfo> fruitInfoList = cacheService.findFruitsInfo();

        return fruitInfoList.stream().filter(info -> "All".equals(fruit) || info.getName().equals(fruit)).collect(Collectors.toList());
    }

}
