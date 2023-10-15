
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

class test {
    public static void main(String[] args) {
        String s = "ёлавыапЁЁЁЁка";
        String regex = "[a-zёЁа-я]{1,25}";

        System.out.println(regex);
        System.out.println(s.matches(regex));
        var scanner = new Scanner(System.in);
        var date = scanner.nextLine();
        var result = LocalDate.parse(date,
                DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println(result);

    }
}
