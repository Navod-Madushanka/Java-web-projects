package com.navod.dependancyinjections.learndependancyinjections.practical02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;
interface DataService{
    int[] retrieveData();
}

@Component
class MySQLData implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[] {1,2,3,4,5};
    }
}

@Component
@Primary
class MongoDBData implements DataService{

    @Override
    public int[] retrieveData() {
        return new int[] {11,22,33,44,55};
    }
}

@Component
class BusinessCalculator {
    private DataService dataService;
    public BusinessCalculator(DataService dataService){
        this.dataService = dataService;
    }
    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}

