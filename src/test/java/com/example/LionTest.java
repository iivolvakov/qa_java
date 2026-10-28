package com.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    Feline feline;

    private Lion lion;

    @BeforeEach
    void setUpForTestLion() throws Exception {
        lion=new Lion("Самец", feline);
    }

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void doesHaveManeCheckReturnTrueAndFalse(String sex, boolean expectedHasMane) throws Exception {
        Lion testLion = new Lion(sex, feline);
        assertEquals(expectedHasMane, testLion.doesHaveMane());
    }

    @Test
    void getKittensWhenReturnRealValue() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        assertEquals(1, actual);
    }

    @Test
    void getFoodReturnTrueValueOfList() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"),actual);
    }

    @Test
    void invalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестно", feline);
        });

        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}