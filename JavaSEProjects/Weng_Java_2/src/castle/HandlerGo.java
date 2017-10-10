package castle;
/**
 * @author menglanyingfei
 * @date 2017-7-15
 */
public class HandlerGo extends Handler {

	public HandlerGo(Game game) {
		super(game);
	}

	@Override
	public void doCmd(String word) {
		game.goRoom(word);
	}
	
}
