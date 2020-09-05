package com.prometheus.springDemoApp.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DanTest {

    @Test
    public void suma100PlusDanJe120() {
        assertEquals(BigDecimal.valueOf(120L), Dan.pripocitajDan(BigDecimal.valueOf(100L)));
    }

    @Test
    public void suma141PlusDanJe169Cela2() {
        assertEquals(BigDecimal.valueOf(169.20).setScale(2), Dan.pripocitajDan(BigDecimal.valueOf(141L).setScale(2)));
    }

    @Test
    public void suma10PlusDanNieJe1000(){
        assertNotEquals(BigDecimal.valueOf(1000),Dan.pripocitajDan(BigDecimal.valueOf(10L).setScale(2)));
    }
}