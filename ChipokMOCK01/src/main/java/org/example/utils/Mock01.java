package org.example.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Mock01 {

    public boolean callMock1() {
        // Генерируем случайное число 0 или 1
        int randomNumber = new Random().nextInt(2);
        // Возвращаем true, если случайное число равно 1, иначе возвращаем false
        return randomNumber == 1;

            }
        }
