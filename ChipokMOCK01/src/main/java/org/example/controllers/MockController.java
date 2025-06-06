package org.example.controllers;

import org.example.utils.Mock01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {

    private final Mock01 mock01;

    @Autowired
    public MockController(Mock01 mock01) {
        this.mock01 = mock01;
    }

    @GetMapping("/api/mock01")
    public boolean callMock1() {
        return mock01.callMock1();
    }
}
