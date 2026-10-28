package com.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionAlexTest {
    private LionAlex alex;
    @Mock
    Feline feline;

    @BeforeEach
    void SetUpForLionAlex() throws Exception {
        alex=new LionAlex(feline);
    }

    @Test
    void getPlaceOfLivingReturnsCorrectPlace() {
        String actual = alex.getPlaceOfLiving();
        String expected = "Нью-Йоркский зоопарк";
        assertEquals(expected, actual);
    }

    @Test
    void getTrueListOfFriendsAlex() {
        List<String> expected = List.of("зебра Марти", "бегемотиха Глори", "Жираф Мелман");
        List<String> actual = alex.getFriends();
        assertEquals(expected, actual);
    }

    @Test
    void alexHasNoKittens() {
        assertEquals(0, alex.getKittens());
    }
}