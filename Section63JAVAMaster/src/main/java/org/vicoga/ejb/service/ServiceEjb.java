package org.vicoga.ejb.service;

import jakarta.ejb.Stateless;

@Stateless
public class ServiceEjb {

    private int count;

public String greet(String name){
    count++;
    System.out.println(count);
    return"hello "+name;
}

}
