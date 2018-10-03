# Exception is caught when Exception is not thrown

SVN:

	CodeFarmerClub/baseplatform/workflow/trunk/wfpt4
	
判例：

	com.yixin.wfpt.assembler.workflow.ActExTaskHandleAssembler.java:240
	
代码：

	/**
	 * 将需要同步的待办任务数组结果集转为List对象
	 * 
	 * @param taskArray
	 * @return 
	 * @author YixinCapital -- wuwenlong
	 *	       2016年11月7日 下午3:19:44
	 */
	public static List<XXX> toTaskHandleDTOSQLList4Sync(XXX) {
		
		for (Object[] handle : taskArray) {
		
			try {
				.....
			}
			catch (Exception e) { // !--
			}
		}
		return taskHandleDTOList;
	}
	
描述：

	This method uses a try-catch block that catches Exception objects, but Exception is not thrown 
	within the try block, and RuntimeException is not explicitly caught. It is a common bug pattern 
	to say try { ... } catch (Exception e) { something } as a shorthand for catching a number of 
	types of exception each of whose catch blocks is identical, but this construct also accidentally
	catches RuntimeException as well, masking potential bugs.
	A better approach is to either explicitly catch the specific exceptions that are thrown, or to 
	explicitly catch RuntimeException exception, rethrow it, and then catch all non-Runtime Exceptions, 
	as shown below:
	
	try {
		...
	} catch (RuntimeException e) {
		throw e;
	} catch (Exception e) {
		... deal with all non-runtime exceptions ...
	}
	
建议：

	在try statement没有需要处理的异常，请不要加try-catch语句进行异常处理

	try {
		...//没有异常抛出
	} catch (Exception e) {//没有必要增加try-catch
	  ...
	}