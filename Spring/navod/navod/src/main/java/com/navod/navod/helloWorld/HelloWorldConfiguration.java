package com.navod.navod.helloWorld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age, Address address){}
record Address(String firstLain, String city){}

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name(){
        return "Mike";
    }
    @Bean
    public int age(){
        return 23;
    }
    @Bean
    public Person person(){
        Person person = new Person("Navod", 24, address());
        return person;
    }
    @Bean
    public Address address(){
        return new Address("Mahakanda", "Kandy");
    }
    @Bean(name = "person2")
    public Person person2MethodCall(){
        return new Person(name(),age(), new Address("Bakes Street", "London"));
    }
}
