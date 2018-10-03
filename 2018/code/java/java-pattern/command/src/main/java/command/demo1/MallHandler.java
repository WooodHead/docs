package command.demo1;

public class MallHandler<E> implements IHandler<E> {

	public void handle(E e) {
		// TODO Auto-generated method stub
		System.out.println(String.format("Mall service provider is ready to handle  '%s'  request", e.toString()));
	}

}
