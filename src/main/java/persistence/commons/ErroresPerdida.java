package persistence.commons;

public class ErroresPerdida extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErroresPerdida(Exception e) {
		super(e);
	}
	
}
