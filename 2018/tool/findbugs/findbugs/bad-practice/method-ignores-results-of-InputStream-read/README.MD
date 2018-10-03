# Method ignores results of InputStream.read()

SVN:   

	CodeFarmerClub/baseplatform/workflow/trunk/wfpt4
	
判例:

	com.yixin.wfpt.utils.GetTypeByHead.java:83
	
代码：
      
    public static String getFileHeader(InputStream is) {  
       
        String value = null;  
        try {  
            byte[] b = new byte[4];   
            is.read(b, 0, b.length);  
            ...  
        } catch (Exception e) {  
        } finally {  
            if (null != is) {  
                try {  
                    is.close();  
                } catch (IOException e) {  
                }  
            }  
        }  
        return value;  
    }  
      
描述：

    This method ignores the return value of one of the variants of java.io.InputStream.read() 
	which can return multiple bytes.? If the return value is not checked, the caller will not 
	be able to correctly handle the case where fewer bytes were read than the caller requested.? 
	This is a particularly insidious kind of bug, because in many programs, reads from input 
	streams usually do read the full amount of data requested, causing the program to fail only 
	sporadically.
	
建议：

	int we_have_read = is.read(b, 0, b.length);
	//先处理边界条件，再处理业务
	if( we_have_read <= 0 ){
		//不需要处理
	}else if(we_hava_read < bufferSize){
		// 需要做些特殊处理吗？
	}else{
		//正常处理缓冲区的内容
	}
	
参考：

[inputstream.read issue](http://stackoverflow.com/questions/38063548/intellij-result-of-inputstream-read-is-ignored-how-to-fix)
[zero bufferSize](http://stackoverflow.com/questions/2319395/what-0-returned-by-inputstream-read-means-how-to-handle-this)
     
    
	 
 

