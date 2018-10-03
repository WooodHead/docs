/**
 * 2017年5月11日
 * zq
 */
package command.demo1;

/**
 * Package : command
 * 
 * @author YixinCapital -- zq
 *		   2017年5月11日 下午4:21:57
 *
 */
public interface IHandler<T> {
	
	void handle(T t);

}
