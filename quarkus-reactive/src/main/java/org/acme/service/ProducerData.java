package org.acme.service;

import io.reactivex.Flowable;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class ProducerData {

    private Random random = new Random();

    //@Outgoing("in-memory")
    public Flowable<Integer> produce(){
        return Flowable.interval(500, TimeUnit.MILLISECONDS)
                .map(tick -> random.nextInt(100));
    }
}
