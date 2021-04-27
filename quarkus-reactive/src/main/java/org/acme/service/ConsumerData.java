package org.acme.service;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConsumerData {

    @Incoming("in-memory")
    public void consume(int randomNumber){
        System.out.println(randomNumber);
    }
}
