package iwm2016.telemd.consultation.exception;

/**
 * @author kaminsj7
 */
public class ActionException extends IllegalArgumentException {

    public ActionException() {
    }

    public ActionException(String s) {
        super(s);
    }

    public ActionException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ActionException(Throwable throwable) {
        super(throwable);
    }
}
