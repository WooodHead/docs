# Static use of type Calendar or DateFormat
SVN:   

	CodeFarmerClub/baseplatform/workflow/trunk/wfpt4
	
判例:

	com.yixin.wfpt.common.aop.PerformenceMonitor.java:50

代码：
      
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
		...
		long begin = System.currentTimeMillis();  
		String beginStr = sdf.format(new Date(begin));
		...
	}
     
      
描述：

    As the JavaDoc states, DateFormats are inherently unsafe for multithreaded use. The detector has
	found a call to an instance of DateFormat that has been obtained via a static field. This looks 
	suspicous.
	For more information on this see Sun Bug 
	[Sun Bug 6231579](http://bugs.java.com/bugdatabase/view_bug.do?bug_id=6231579) 
	[Sun Bug #6178997](http://bugs.java.com/bugdatabase/view_bug.do?bug_id=6178997)
	
建议：

	private static final String DATE_FORMAT = "yyyy-MM-dd HH:ss:mm";
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
		...
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT); 
		String beginStr = sdf.format(new Date());
		...
	}

