package Homework_Sem_3;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        String s = "ёлавыапЁЁЁЁка";
        String regex = "[a-zёЁа-я]{1,25}";

        System.out.println(regex);
        System.out.println(s.matches(regex));
    }
}
