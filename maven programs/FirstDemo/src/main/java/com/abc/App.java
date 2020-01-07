package com.abc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
    	HelloWorld helloWorld = (HelloWorld)factory.getBean("helloWorld");
    	helloWorld.greet();
    	System.out.println(helloWorld.getCitiesList());
    	System.out.println(helloWorld.getFruitsSet());
    	System.out.println(helloWorld.getFoodMap());
    }
}
