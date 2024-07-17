package ru.mirea.sdk.genearators;

import java.util.Random;

public class ShopPlannerGenerator {
    public static char[][] generateStoreLayout(int rows, int cols) {
        char[][] layout = new char[rows][cols];

        // Инициализация всего магазина проходами
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                layout[i][j] = '.';
            }
        }

        Random random = new Random();

        // Заполнение витринами в виде прямоугольников с проходами между ними
        fillRectangleWithAisles(layout, 'B', 0, rows / 4 - 1, 0, cols - 1, random);         // Бакалея
        fillRectangleWithAisles(layout, 'H', rows / 4 + 1, rows / 2 - 1, 0, cols - 1, random);  // Хозяйственные товары
        fillRectangleWithAisles(layout, 'M', rows / 2 + 1, 3 * rows / 4 - 1, 0, cols - 1, random);  // Молочные товары
        fillRectangleWithAisles(layout, 'F', 3 * rows / 4 + 1, rows - 1, 0, cols / 2 - 1, random);  // Фрукты
        fillRectangleWithAisles(layout, 'O', 3 * rows / 4 + 1, rows - 1, cols / 2 + 1, cols - 1, random); // Овощи
        return layout;
    }

    // Метод для заполнения прямоугольной области витринами с проходами
    public static void fillRectangleWithAisles(char[][] layout, char shelfType, int rowStart, int rowEnd, int colStart, int colEnd, Random random) {
        for (int i = rowStart; i <= rowEnd; i++) {
            // Заполняем строку витринами
            for (int j = colStart; j <= colEnd; j++) {
                layout[i][j] = shelfType;
            }

            // Добавляем проходы на каждой строке
            if (i % 3 == 0) { // Проход каждые 3 строки
                for (int j = colStart; j <= colEnd; j++) {
                    layout[i][j] = '.'; // Проход
                }
            }
        }
    }
}
