package com.solarexsoft.javawithkotlin.lastrow;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Solarex on 2024/01/25 15:01
 */
public class LastRow {
    public static void main(String[] args) {
        /*
        // 假设有一个一维数组，每行有5个元素
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        // 要判断的元素
        int elementToCheck = 15;

        // 判断元素是否在最后一行
        boolean isInLastRow = isInLastRow(array, elementToCheck);

        // 输出结果
        if (isInLastRow) {
            System.out.println(elementToCheck + " is");
        } else {
            System.out.println(elementToCheck + " not");
        }
         */
        System.out.println("20 -- 15 = " + isInLastRow(20, 15));
        System.out.println("20 -- 14 = " + isInLastRow(20, 14));
        System.out.println("22 -- 14 = " + isInLastRow(22, 14));
        System.out.println("22 -- 15 = " + isInLastRow(22, 15));
        System.out.println("4 -- 1 = " + isInLastRow(4,1));
        System.out.println("5 -- 0 = " + isInLastRow(5, 0));
        System.out.println("6 -- 1 = " + isInLastRow(6, 1));
    }

    // 判断元素是否在最后一行的方法
    private static boolean isInLastRow(int[] array, int element) {
        // 计算总行数
        int numRows = (int) Math.ceil((double) array.length / 5);

        // 计算元素所在行数
        int row = (element - 1) / 5 + 1;

        // 判断是否在最后一行
        return row == numRows;
    }

    public static boolean isInLastRow(int size, int index) {
        int divider = size / 5;
        int i = size % 5;
        int lastLineIndex;
        if (i == 0) {
            lastLineIndex = size - 5;
        } else {
            lastLineIndex = divider * 5;
        }
        System.out.println("isInLastRow, size = " + size + ", lastLineIndex = " + lastLineIndex);
        boolean b;
        b = index >= lastLineIndex;
        return b;
    }
}
