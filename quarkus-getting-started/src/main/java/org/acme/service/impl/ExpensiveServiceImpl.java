package org.acme.service.impl;

import org.acme.service.ExpensiveService;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExpensiveServiceImpl implements ExpensiveService {

    @Override
    public int calculate() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 100;
    }
}
