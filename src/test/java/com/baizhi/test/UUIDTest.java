package com.baizhi.test;

import org.junit.Test;

import java.util.UUID;

public class UUIDTest {

    @Test
    public void getUUID(){
        System.out.println(UUID.randomUUID().toString());
    }

}
