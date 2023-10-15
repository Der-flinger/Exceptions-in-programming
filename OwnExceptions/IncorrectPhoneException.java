
/**
 * Исключение показывает неверный формат номера телефона пользователя
 */
public class IncorrectPhoneException extends IncorrectDataFormatException {

    final String phoneFormat = "8(000)000-00-00";
    private int index;

    public IncorrectPhoneException(String message) {
        super(message);
    }

    public IncorrectPhoneException(String message, int index) {
        super(message);
        this.index = index;
    }

    public String getPhoneFormat() {
        return phoneFormat;
    }

    public int getIndex() {
        return index;
    }

}
