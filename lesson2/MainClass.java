package ru.geekbrains.lesson2;

// import java.util.*;
public class MainClass {

    static int result = 0;

    public static void main(String[] args) {

        //1* correct
        String[][] array = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = "1";
            }
        }

        //2* size
        String[][] wrongSize = new String[5][4];


        //3* data
        String[][] wrongData = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                wrongData[i][j] = "1";
            }
        }
        wrongData[0][1] = "1$";
        //System.out.println(Arrays.deepToString(wrongData));
//*****************************************************************************
        System.out.println("1| Using Correct array ");
        System.out.println("------------------------");
        check(array);

        System.out.println("2| Using Wrong size array ");
        System.out.println("------------------------");
        check(wrongSize);

        System.out.println("3| Using array with the wrong data ");
        System.out.println("------------------------");
        check(wrongData);
    }

    //********************************************************************************
//*
    static void check(String[][] array) {

        try {
            result = 0;
            result = analyze(array);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        } catch (MyArrayDataException e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            System.out.println("The Summ of the cells is: " + result);
            System.out.println("===============================");
        }
    }

    static int analyze(String[][] array) throws MyArraySizeException, MyArrayDataException {

        int summ = 0;
        int row;
        int column;

        if (array.length != 4 || array[0].length != 4 || array[1].length != 4 || array[2].length != 4 || array[3].length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < 4; i++) {
            row = i + 1;
            for (int j = 0; j < 4; j++) {
                column = j + 1;
                try {
                    summ += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    //e.printStackTrace();
                    String message = "in row: " + String.valueOf(row) + ", cell: " + String.valueOf(column);
                    throw new MyArrayDataException(message);
                }
            }
        }

        return summ;
    }
}





