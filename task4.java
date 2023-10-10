
// Разработайте программу, которая выбросит Exception, когда пользователь 
// вводит пустую строку. Пользователю должно показаться сообщение,
// что пустые строки вводить нельзя.

public class task4 {
    public static void main(String[] args) {
        try {
            userInput();

        } catch (ownExceptionObject e) {
            System.out.println("Пустые строки вводить нельзя");
            System.out.println("Программа завершена, до свидания!");
        }
    }

    public static void userInput() throws ownExceptionObject {
        String str = new String();
        System.out.println("Введите строку");
        str = System.console().readLine();
        if (str.equals("")) {
            throw new ownExceptionObject("Пользователь ввел пустую строку");
        }
        System.out.println(str);
    }
}
