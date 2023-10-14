package Homework_Sem_3;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class prog {
    public static void main(String[] args) throws NotEnoughtOrTooMuchDataException {

        printPrompt();
        String[] dataArray = getDataArray();
        String[] dataArray1 = surnameReEntering(dataArray);
        String[] dataArray2 = nameReEntering(dataArray1);
        String[] dataArray3 = patronymicReEntering(dataArray2);
        System.out.println(Arrays.toString(dataArray3));
    }

    public static String[] dataAcquisition() {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String[] splitArray = data.split(" ");
        return splitArray;
    }

    /**
     * Проверка на кол-во введенных данных
     *
     * @throws NotEnoughtOrTooMuchDataException
     */
    public static void dataLenghtChecking(String[] array) throws NotEnoughtOrTooMuchDataException {

        if (array.length != 5) {
            throw new NotEnoughtOrTooMuchDataException(
                    "Повторите попытку, введите данные в соответствии с инструкцией",
                    array.length);
        }
    }

    public static String[] getDataArray() {
        while (true) {

            try {
                String[] array = dataAcquisition();
                dataLenghtChecking(array);
                return array;

            } catch (NotEnoughtOrTooMuchDataException e) {
                if (e.getDataQuantity() < 5) {
                    System.out.printf("Вы ввели слишком мало данных -> {%s}. %s\n", e.getDataQuantity(),
                            e.getMessage());
                } else {
                    System.out.printf("Вы ввели слишком много данных -> {%s}. %s\n", e.getDataQuantity(),
                            e.getMessage());
                }
            }
        }
    }

    public static String[] surnameReEntering(String[] array) {
        while (true) {
            try {
                surnameFormatChecking(array);
                return array;
            } catch (IncorrectNameException e) {
                System.out.printf("%s, введите %s заново\n", e.getMessage(), e.getNameData());
                array[e.getIndex()] = System.console().readLine();
            }
        }
    }

    public static String[] nameReEntering(String[] array) {
        while (true) {
            try {
                nameFormatChecking(array);
                return array;
            } catch (IncorrectNameException e) {
                System.out.printf("%s, введите %s заново\n", e.getMessage(), e.getNameData());
                array[e.getIndex()] = System.console().readLine();
            }
        }
    }

    public static String[] patronymicReEntering(String[] array) {
        while (true) {
            try {
                patronymicFormatChecking(array);
                return array;
            } catch (IncorrectNameException e) {
                System.out.printf("%s, введите %s заново\n", e.getMessage(), e.getNameData());
                array[e.getIndex()] = System.console().readLine();
            }
        }
    }

    public static void printPrompt() {
        System.out.println("Введите данные в одну строку через пробел в произвольном порядке ");

        System.out.println("Форматы данных:\r\n" + "фамилия, имя, отчество - строки\r\n" + //
                "дата рождения - строка формата dd.mm.yyyy\r\n" + //
                "номертелефона - целое беззнаковое число без форматирования\r\n" + //
                "пол - символ латиницей f или m.");

        System.out.println(
                "Введите фамилию, имя, отчество, дату рождения, пол и номер телефона в соответствии с инструкцией");
    }

    public static void surnameFormatChecking(String[] array) throws IncorrectNameException {
        if (!array[0].matches("[a-zёа-я]{1,100}")) {
            throw new IncorrectNameException("Фамилия не соответствует формату данных", "Фамилию", 0);
        }
    }

    public static void nameFormatChecking(String[] array) throws IncorrectNameException {
        if (!array[1].matches("[a-zёа-я]{1,100}")) {
            throw new IncorrectNameException("Имя не соответствует формату данных", "Имя", 1);
        }
    }

    public static void patronymicFormatChecking(String[] array) throws IncorrectNameException {
        if (!array[2].matches("[a-zёа-я]{1,100}")) {
            throw new IncorrectNameException("Отчество не соответствует формату данных", "Отчество", 2);
        }
    }
}
