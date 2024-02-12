package com.navod.dependancyinjections.learndependancyinjections.practical01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class YourBusinessClass{
    Dependency1 dependency1;
    Dependency2 dependency2;

    public String toString(){
        return "Using "+dependency1+" and "+dependency2;
    }

    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Constructor Injection here");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }
}
@Component
class Dependency1{

}
@Component
class Dependency2{

}


@Configuration
@ComponentScan
public class DependencyInjections {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DependencyInjections.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(YourBusinessClass.class));
        }

    }
}
