package org.acme.service;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BrokerConsumer {

    @Incoming("temperature")
    public void consume(int randomNumber){
        System.out.println("Temperature: " + randomNumber);
    }
}
