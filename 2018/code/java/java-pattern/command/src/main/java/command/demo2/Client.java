package command.demo2;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Receiver receiver = new Receiver();
		Command command = new ConcreteCommand(receiver);
		Invoker invoker = new Invoker(command);
		invoker.call();
	}

}
