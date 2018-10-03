/**
 * 2017年8月2日
 * zq
 */
package command.demo2;

/**
 * 
 * 具体命令的实现
 * Package : patterns.command.demo2
 * 
 * @author YixinCapital -- zq
 *		   2017年8月2日 下午5:02:27
 *
 */
public class ConcreteCommand implements Command {
	
	
	private Receiver receiver;
	
	
	public ConcreteCommand(Receiver receiver){
		this.receiver = receiver;
	}

	/**
	 *  
	 * @author YixinCapital -- zq
	 *	       2017年8月2日 下午5:02:27
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.receiver.action();

	}

}
