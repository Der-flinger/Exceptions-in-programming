
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;

public class prog {
    public static void main(String[] args) throws NotEnoughtOrTooMuchDataException {

        printPrompt();
        String[] dataArray = getDataArray();
        dataArray = surnameReEntering(dataArray);
        dataArray = nameReEntering(dataArray);
        dataArray = patronymicReEntering(dataArray);
        dataArray = dateReEntering(dataArray);
        dataArray = genderReEntering(dataArray);
        dataArray = phoneReEntering(dataArray);
        System.out.println(Arrays.toString(dataArray));

        try (FileWriter fw = new FileWriter(new File(dataArray[0]), true)) {
            String personalData = stringFormatting(dataArray) + "\n";
            fw.write(personalData);
            fw.flush();
            // fw.append(stringFormatting(dataArray));
        } catch (IOException e) {
            System.out.println("Не удалось записать данные" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Вывод сообщений пользователю на экран
     */
    public static void printPrompt() {
        System.out.println("Введите данные в одну строку через пробел в заданном порядке ");

        System.out.println("Форматы данных:\r\n" + "фамилия, имя, отчество - строки\r\n" + //
                "дата рождения - строка формата dd.mm.yyyy\r\n" + //
                "пол - символ латиницей f или m.\r\n" + //
                "номертелефона - целое беззнаковое число без форматирования\r\n");

        System.out.println(
                "Введите фамилию, имя, отчество, дату рождения, пол и номер телефона в соответствии с инструкцией");
    }

    /**
     * Ввод данных пользователем и парсинг полученных данных
     * 
     * @return Возвращает массив с данными
     */
    public static String[] dataAcquisition() {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String[] splitArray = data.split(" ");
        System.out.println(Arrays.toString(splitArray));
        return splitArray;
    }

    /**
     * Проверка на кол-во введенных данных
     *
     * @throws NotEnoughtOrTooMuchDataException
     */
    public static void dataLenghtChecking(String[] array) throws NotEnoughtOrTooMuchDataException {

        if (array.length != 6) {
            throw new NotEnoughtOrTooMuchDataException(
                    "Повторите попытку, введите данные в соответствии с инструкцией",
                    array.length);
        }
    }

    /**
     * Вывод информацию о кол-ве введенных данных
     * 
     * @return Возвращает массив с правильным кол-вом данных
     */
    public static String[] getDataArray() {
        while (true) {

            try {
                String[] array = dataAcquisition();
                dataLenghtChecking(array);
                return array;

            } catch (NotEnoughtOrTooMuchDataException e) {
                if (e.getDataQuantity() < 6) {
                    System.out.printf("Вы ввели слишком мало данных -> {%s}. %s\n", e.getDataQuantity(),
                            e.getMessage());
                } else {
                    System.out.printf("Вы ввели слишком много данных -> {%s}. %s\n", e.getDataQuantity(),
                            e.getMessage());
                }
            }
        }
    }

    /**
     * Ввод новой фамилии, если сработало исключение
     * 
     * @param array массив с данными
     * @return Возвращает массив с обновленными данными
     */
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

    /**
     * Ввод нового имени, если сработало исключение
     * 
     * @param array массив с данными
     * @return Возвращает массив с обновленными данными
     */
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

    /**
     * Ввод нового отчества, если сработало исключение
     * 
     * @param array массив с данными
     * @return Возвращает массив с обновленными данными
     */
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

    /**
     * Ввод новой даты рождения, если сработало исключение
     * 
     * @param array массив с данными
     * @return Возвращает массив с обновленными данными
     */
    public static String[] dateReEntering(String[] array) {
        while (true) {
            try {
                dateFormatChecking(array);
                return array;
            } catch (IncorrectDateException e) {
                System.out.printf("%s, введите дату рождения заново в формате %s\n", e.getMessage(), e.getDate());
                array[e.getIndex()] = System.console().readLine();
            }
        }
    }

    /**
     * Ввод пола пользователя повторно, если сработало исключение
     * 
     * @param array массив с данными
     * @return Возвращает массив с обновленными данными
     */
    public static String[] genderReEntering(String[] array) {
        while (true) {
            try {
                genderFormatChecking(array);
                return array;
            } catch (IncorrectGenderException e) {
                System.out.printf("%s, Введите f -> (female/женщина) или m -> (male/мужчина) для выбора пола\n",
                        e.getMessage());
                array[e.getIndex()] = System.console().readLine();
            }
        }
    }

    /**
     * Ввод номера телефона повторно, если сработало исключение
     * 
     * @param array массив с данными
     * @return Возвращает массив с обновленными данными
     */
    public static String[] phoneReEntering(String[] array) {
        while (true) {
            try {
                phoneFormatChecking(array);
                return array;
            } catch (IncorrectPhoneException e) {
                System.out.printf("%s, введите номер телефона заново в формате %s\n", e.getMessage(),
                        e.getPhoneFormat());
                array[e.getIndex()] = System.console().readLine();
            }
        }
    }

    /**
     * Проверка формата введенных данных
     * 
     * @param array массив с данными
     * @throws IncorrectNameException
     */
    public static void surnameFormatChecking(String[] array) throws IncorrectNameException {
        if (!array[0].toLowerCase().matches("[а-яa-z]{1,100}")) {
            throw new IncorrectNameException("Фамилия не соответствует формату данных", "Фамилию", 0);
        }
    }

    /**
     * Проверка формата введенных данных
     * 
     * @param array массив с данными
     * @throws IncorrectNameException
     */
    public static void nameFormatChecking(String[] array) throws IncorrectNameException {
        if (!array[1].toLowerCase().matches("[а-яa-z]{1,100}")) {
            throw new IncorrectNameException("Имя не соответствует формату данных", "Имя", 1);
        }
    }

    /**
     * Проверка формата введенных данных
     * 
     * @param array массив с данными
     * @throws IncorrectNameException
     */
    public static void patronymicFormatChecking(String[] array) throws IncorrectNameException {
        if (!array[2].toLowerCase().matches("[а-яa-z]{1,100}")) {
            throw new IncorrectNameException("Отчество не соответствует формату данных", "Отчество", 2);
        }
    }

    /**
     * Проверка формата введенных данных
     * 
     * @param array массив с данными
     * @throws IncorrectNameException
     */
    public static void dateFormatChecking(String[] array) throws IncorrectDateException {
        // array[3]
        try {
            LocalDate res = LocalDate.parse(array[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException ex) {
            throw new IncorrectDateException("Формат даты не соответствует шаблону", 3);
        }
    }

    /**
     * Проверка формата введенных данных
     * 
     * @param array массив с данными
     * @throws IncorrectNameException
     */
    public static void genderFormatChecking(String[] array) throws IncorrectGenderException {
        // array[4]
        if (!array[4].matches("[fm]")) {
            throw new IncorrectGenderException("Вы ввели пол в неверном формате", 4);
        }
    }

    /**
     * Проверка формата введенных данных
     * 
     * @param array массив с данными
     * @throws IncorrectNameException
     */
    public static void phoneFormatChecking(String[] array) throws IncorrectPhoneException {
        // array[5]
        String regex = "\\d\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}";
        if (!array[5].matches(regex)) {
            throw new IncorrectPhoneException("Неверный формат телефона, следуйте инструкции", 5);
        }
    }

    /**
     * Преобразование массива с данными в строку
     * 
     * @param array массив с данными
     * @return Возвращает строку, составленную из данных массива
     */
    public static String stringFormatting(String[] array) {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            str += "<" + array[i] + ">";
        }
        return str;
    }
}
