/*
 * 
 */
package exception;

/**
 * Classe de Exception da CFe
 * @author Everton Alvaro
 */
public class CfeException extends Exception {
    String message;
	
	/**
	 * Construtor da classe.
	 * 
	 * @param e
	 */
	public CfeException(Throwable e) {
            super(e);
	}

	
	/**
	 * Construtor da classe.
	 * 
	 * @param message
	 */
	public CfeException(String message) {
            this((Throwable) null);
            this.message = message;
	}

	/**
	 * @return the message
	 */
        @Override
	public String getMessage() {
            return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
            this.message = message;
	}

}
