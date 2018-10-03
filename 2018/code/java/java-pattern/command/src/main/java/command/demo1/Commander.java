/**
 * 2017年5月11日
 * zq
 */
package command.demo1;

/**
 * Package : command
 * 
 * @author YixinCapital -- zq 2017年5月11日 下午4:44:13
 *
 */
public class Commander<T> {

	public  IHandler<T> lookupHanderByName(String name) throws HandlerNotExistedException {
		IHandler<T> handler = null;
		switch(name) {
		case "store":
			handler = new StoreHandler<>();
			break;
		case "hotel":
			handler = new HotelHandler<>();
			break;
		case "mall":
			handler = new MallHandler<>();
			break;
		default:
			throw new HandlerNotExistedException();
		}
		return handler;
	}

}
