# Nullcheck of value previously dereferenced
SVN:   

	CodeFarmerClub/baseplatform/workflow/trunk/wfpt4
	
判例:

	com.yixin.wfpt.application.impl.template.ActExTaskButtonServiceImpl.java:73
	

代码：

    ...
    // 默认调用服务
	entity.setInvokeService(true);
	if (entity != null) {
		...
	}
    ...
      
描述：

	A value is checked here to see whether it is null, but this value can't be null because it was 
	previously dereferenced and if it were null a null pointer exception would have occurred at the 
	earlier dereference. Essentially, this code and the previous dereference disagree as to whether 
	this value is allowed to be null. Either the check is redundant or the previous dereference is 
	erroneous.
    
	
建议：

	if (entity != null) {
		entity.setInvokeService(true);
		...
	}
	

