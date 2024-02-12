package com.navod.navod.helloWorld;

import com.navod.navod.helloWorld.HelloWorldConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;


public class HelloWorldSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("address"));
        System.out.println(context.getBean("person2"));
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
