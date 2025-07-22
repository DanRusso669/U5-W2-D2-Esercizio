package danrusso.U5_W2_D2_Esercizio.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super(
                "Record with id " + id + " not found."
        );
    }
}
