package com.j13.garen.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OrderNumberService {

    private static Random random = new Random();

    public static String gen() {
        int end = random.nextInt(9);
        return System.currentTimeMillis() + "" + end;
    }
}
