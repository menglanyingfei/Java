package castle;
/**
 * @author menglanyingfei
 * @date 2017-7-15
 */
public class HandlerHelp extends Handler {

	public HandlerHelp(Game game) {
		super(game);
	}

	@Override
	public void doCmd(String word) {
		System.out.println("迷路了吗? 你可以做的命令有: go bye help");
		System.out.println("如: \tgo east");
	}
	
}



















