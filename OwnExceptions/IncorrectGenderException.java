public class IncorrectGenderException extends IncorrectDataFormatException {

    private int index;

    public IncorrectGenderException(String message) {
        super(message);
    }

    public IncorrectGenderException(String message, int index) {
        super(message);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
