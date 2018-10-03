# Write to static field from instance method

SVN:  

    CodeFarmerClub/baseplatform/workflow/trunk/wfpt
    
判例：

    com.yixin.wfpt.application.impl.engine.listener.CallActivitiNodeListener.java:83
    
代码：
    
      //类变量声明
      private static IActExTaskDefService actExTaskDefService;
      private static IActExTemplateService actExTemplateService;
      public CallActivitiNodeListener(
         ...
         IActExTaskDefService taskDefService,
         IActExTemplateService templateService) {
         ...
    }
    
描述： 
   
     Write to static field CallActivitiNodeListener.runtimeEngineService from 
	 instance method new CallActivitiNodeListener(IRuntimeEngineService, 
	 IActExTaskDefService, IactExTemplateService)
  
  
建议：
         
    1.使用Spring @Autowired组装 
    
    2.去掉 static，为 CallActivitiNodeListener写一个单例工厂来创建实例

    public class CompanyFactory {
        private volatile static Company INSTANCE = null;
        private CompanyFactory(){};
        public static Company getInstance(String name) {
            if(INSTANCE == null){
                synchronized(CompanyFactory.class){
                    if( INSTANCE == null) 
                        INSTANCE = new Company( name );
                }
            }
            return INSTANCE;
        }
     }