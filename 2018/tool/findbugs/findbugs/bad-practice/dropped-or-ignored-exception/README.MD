# Method might ignore exception

SVN:   

	CodeFarmerClub/baseplatform/workflow/trunk/wfpt4
	
判例:

	com.yixin.wfpt.application.impl.template.ActExTemplateServiceImpl.java:389
	

代码：
      
    try {
		...
	} catch (Exception e) {
		//nothing
	}
	
     
      
描述：

	This method might ignore an exception.? In general, exceptions should be handled or reported in 
	some way, or they should be thrown out of the method.
    
参考：

	不要吃掉异常信息

	try {
		...
	} catch (Exception e) {
		//must add the error information to logger
		logger.error("found excetpion:" , e);
		//may throw a new BizException 
		//throw new BizException(e.getMessage());
	}
	
[printing exception vs printing excetpion.getMessage](http://stackoverflow.com/questions/32840399/printing-exception-vs-exception-getmessage)

	

	

	
     
    
	 
 

