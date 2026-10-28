package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CatTest {
    @Mock
    Feline feline;

    @Test
    void getSoundCheckTrueSound() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound(),"Должен вернуть (Мяу)");
    }

    @Test
    void getTrueListOfFood() throws Exception {
        Cat cat=new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual=cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actual);
    }
}