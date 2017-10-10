package exception;
/**
 * @author menglanyingfei
 * @date 2017-9-11
 */

class OpenException1 extends Exception {
	private static final long serialVersionUID = 1L;
}

class CloseException1 extends OpenException1 {
	private static final long serialVersionUID = 1L;
}

class NewException extends Exception {
	private static final long serialVersionUID = 1L;
}
// 父类
public class ExceptionExtends {
	public ExceptionExtends() throws OpenException1 {}
	public void f() throws OpenException1 {}
	public static void main(String[] args) {

	}

}
// 子类
class NewClass extends ExceptionExtends {
	public NewClass() throws OpenException1, NewException {}
	public void f() throws CloseException1 {}
	public static void main(String[] args) {
		try {
			ExceptionExtends p = new NewClass();
			p.f();
		} catch (OpenException1 e) {
			e.printStackTrace();
		} catch (NewException e) {
			e.printStackTrace();
		}
	}
}























