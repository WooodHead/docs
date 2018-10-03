# Dead store to local variable 

SVN:

	CodeFarmerClub/baseplatform/workflow/trunk/wfpt4
	
判例:

    com.yixin.wfpt.utils.ResponseUtils.java:26
	
代码：

	public static ApiResult<?> wrap(...) {
		...
        Data<Object> respData = new Data<Object>(); //!-- Dead store to local variable
		...
        return apiResult;
    }
	
描述：

	This instruction assigns a value to a local variable, but the value is not 
	read or used in any subsequent instruction. Often, this indicates an error,
	because the value computed is never used.
    Note that Sun's javac compiler often generates dead stores for final local 
	variables. Because FindBugs is a bytecode-based tool, there is no easy way 
	to eliminate these false positives.

建议：

    直接删掉用不到的变量声明代码