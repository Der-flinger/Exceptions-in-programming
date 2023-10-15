
/**
 * Исключение показывает неверный формат имени пользователя
 * 
 * @param message сообщение дает информацию о том, что неверно
 */
public class IncorrectNameException extends IncorrectDataFormatException {

    private String nameData;
    private int index;

    public IncorrectNameException(String message) {
        super(message);
    }

    public IncorrectNameException(String message, String nameData) {
        super(message);
        this.nameData = nameData;
    }

    public IncorrectNameException(String message, String nameData, int index) {
        super(message);
        this.nameData = nameData;
        this.index = index;
    }

    public String getNameData() {
        return nameData;
    }

    public int getIndex() {
        return index;
    }

}
