package exception;
/**
 * @author menglanyingfei
 * @date 2017-9-11
 */

class OpenException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5919194185171469730L;
	
}

public class FileShow {
	public static int open() {
		return -1;
	}
	
	public static void readFile() throws OpenException {
		if (open() == -1) {
			throw new OpenException();
		}
	}
	
	public static void main(String[] args) {
		try {
			readFile();
		} catch (OpenException e) {
			e.printStackTrace();
		}
	}
}



