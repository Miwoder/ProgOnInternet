package com.example.Lab21;

import java.util.*;

public class XXRand {
    private Integer n = Integer.MAX_VALUE;
    private Random r = new Random();

    public XXRand(Integer n) {
        this.n = n;
    }

    public Integer Get() {
        return (this.r.nextInt()%this.n);
    }
}

