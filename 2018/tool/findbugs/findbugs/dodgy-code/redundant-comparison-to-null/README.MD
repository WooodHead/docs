# Reduntant nullcheck of value known to be non-null

SVN: 

	CodeFarmerClub/baseplatform/workflow/trunk/wfpt4
	
判例：

	com.yixin.wfpt.application.impl.organization.ActExOrgServiceImpl.java:177
	
代码：
	
	public InvokeResult<XXX> getUsersByOrgId(ActParamOrgDTO actParamOrgDTO) {
		...
		
		if (actParamOrgDTO == null || ...)
			...
		}
			
		if (actParamOrgDTO != null && ...) {
			...
		}
		...
	}
	
描述：

	This method contains a redundant check of a known non-null value against the constant null.
	
建议：

    梳理流程，理清分支处理过程