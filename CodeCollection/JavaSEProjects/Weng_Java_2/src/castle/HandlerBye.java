package castle;
/**
 * @author menglanyingfei
 * @date 2017-7-15
 */
public class HandlerBye extends Handler {
	
	public HandlerBye(Game game) {
		super(game);
	}

	@Override
	public boolean isBye() {
		return true;
	}
}
