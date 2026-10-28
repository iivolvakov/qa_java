package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FelineTest {
    private Feline feline;


    @BeforeEach
    void setUpForTestFeline() {
        feline = new Feline(); // Создается заново перед каждым тестом
    }

    @Test
    void eatMeatCeckOfTrueArrayFor() throws Exception{
        List<String> actual = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actual, "Должен вернуться список соответствующий хищнику");
    }

    @Test
    void getFamilyReturnCorrectString() {
        assertEquals("Кошачьи", feline.getFamily(),"Должен вернуть верное значение (Кошачьи)");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    void getKittensWithCorrectCount(int count) {
        assertEquals(count, feline.getKittens(count));
    }

    @Test
    void checkOfTrueReturnGetKittens() {
        int actualCount =1;
        int realCount =feline.getKittens();
        assertEquals(actualCount,realCount);
    }
}