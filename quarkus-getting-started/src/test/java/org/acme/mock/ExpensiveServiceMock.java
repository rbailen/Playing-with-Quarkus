package org.acme.mock;

import io.quarkus.test.Mock;
import org.acme.service.ExpensiveService;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Mock
public class ExpensiveServiceMock implements ExpensiveService {

    @Override
    public int calculate() {
        return 20;
    }
}
