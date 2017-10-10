package castle;
/**
 * @author menglanyingfei
 * @date 2017-7-14
 */
public class Handler {
	protected Game game;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public void doCmd(String word) {	
	}
	
	public boolean isBye() {
		return false;
	}
}
