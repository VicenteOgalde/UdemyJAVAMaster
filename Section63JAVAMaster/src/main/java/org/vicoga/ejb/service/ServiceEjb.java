package org.vicoga.ejb.service;

import jakarta.ejb.Stateless;

@Stateless
public class ServiceEjb {

public String greet(String name){
    return"hello "+name;
}

}
