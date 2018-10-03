package command.demo1;

public class Main {

	public static void main(String[] args) throws HandlerNotExistedException {
		// TODO Auto-generated method stub
		Commander commander = new Commander();
		String name = "test";
		IHandler handler = commander.lookupHanderByName("mall");
		handler.handle("give me an apple,please");
	}

}
