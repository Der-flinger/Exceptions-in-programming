/**
 * Исключение показывает неверный формат даты рождения
 */
public class IncorrectDateException extends IncorrectDataFormatException {

    final String date = "dd.MM.yyyy";
    private int index;

    public IncorrectDateException(String message) {
        super(message);
    }

    public IncorrectDateException(String message, int index) {
        super(message);
        this.index = index;
    }

    public String getDate() {
        return date;
    }

    public int getIndex() {
        return index;
    }

}
