/**
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа
 * (типа float),
 * и возвращает введенное значение. Ввод текста вместо числа не должно приводить
 * к падению
 * приложения, вместо этого, необходимо повторно запросить у пользователя ввод
 * данных.
 */
public class task1 {

    public static void main(String[] args) {
        System.out.println(getFloat());
    }

    public static float getFloat() {
        System.out.print("Введите дробное число - ");
        String num = System.console().readLine();
        try {
            float res = Float.parseFloat(num);
            return res;
        } catch (Exception e) {
            System.out.println("Значение должно быть числом, дробным числом");
            System.out.println("Повторите попытку");
            return getFloat();
        }
    }
}