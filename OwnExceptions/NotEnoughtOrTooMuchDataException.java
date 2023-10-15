
/**
 * Исключение, указывает на неверное кол-во данных
 */
public class NotEnoughtOrTooMuchDataException extends Exception {
    private int dataQuantity;

    public NotEnoughtOrTooMuchDataException(String message) {
        super(message);
    }

    public NotEnoughtOrTooMuchDataException(String message, int dataQuantity) {
        super(message);
        this.dataQuantity = dataQuantity;
    }

    public int getDataQuantity() {
        return dataQuantity;
    }

}