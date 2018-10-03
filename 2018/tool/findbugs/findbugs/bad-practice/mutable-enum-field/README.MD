# Public enum method unconditionally sets its field

SVN:   

	CodeFarmerClub/baseplatform/workflow/trunk/wfpt4
	
判例:

	com.yixin.wfpt.enumpackage.engine.MongoDBCollectionNameEnum.java:53
	
代码：
      
    /**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
      
描述：

    Public enum method unconditionally sets its field
    This public method declared in public enum unconditionally sets enum field, 
	thus this field can be changed by malicious code or by accident from another 
	package. Though mutable enum fields may be used for lazy initialization, 
	it's a bad practice to expose them to the outer world. Consider removing 
	this method or declaring it package-private.

建议：
     
	枚举类对外是静态的，所以不能提供属性修改的方法
    掉setXXX(...);
	 
	
