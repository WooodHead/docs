# Possible null pointer dereference
SVN:   

	CodeFarmerClub/baseplatform/workflow/trunk/wfpt4
	
判例:

	com.yixin.wfpt.application.impl.engine.service.TaskEngineServiceImpl.java:81
	

代码：
      
    // 结果集
	List<Task> taskList = taskQuery.orderByTaskCreateTime().desc()
	.listPage(taskQueryDTO.getCurrent() - 1, Page.DEFAULT_PAGE_SIZE);
     
      
描述：

	There is a branch of statement that, if executed, guarantees that a null value will be 
	dereferenced, which would generate a NullPointerException when the code is executed. Of course, 
	the problem might be that the branch or statement is infeasible and that the null pointer 
	exception can't ever be executed; deciding that is beyond the ability of FindBugs.
    
	
建议：

	List<Task> taskList = (taskQueryDTO == null)? null : taskQuery.orderByTaskCreateTime().desc()
	.listPage(taskQueryDTO.getCurrent() - 1, Page.DEFAULT_PAGE_SIZE);

# Possible null pointer dereference in method on exception path

SVN:   

	CodeFarmerClub/baseplatform/workflow/trunk/wfpt4
	
判例:

	com.yixin.wfpt.application.impl.api.process.ActExProcessAPIServiceImpl.java:347
	

代码：
      
    try {
         ...
    } catch (Exception e) {
        	String message = "xxx"+deleteInstanceDTO.getProcessInstanceId()+"]xxx" + e.getMessage();
            ...
    }
     
描述：

	A reference value which is null on some exception control path is dereferenced here.  This may 
	lead to a NullPointerException when the code is executed.  Note that because FindBugs currently 
	does not prune infeasible exception paths, this may be a false warning.
	Also note that FindBugs considers the default case of a switch statement to be an exception path,
	since the default case is often infeasible.
    
	
建议：

	进行非空校验

