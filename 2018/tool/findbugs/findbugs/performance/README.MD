# String concatenation in loop using + operator
SVN:   

	CodeFarmerClub/baseplatform/workflow/trunk/wfpt4
	
判例:

	com.yixin.wfpt.util.DataUtil.java:35

代码：
      
    public static String getSQLInCondition(List<String> kList) {
		String condition = "";
		if (kList != null && kList.size() > 0) {
    	   for (int i = 0 ; i < kList.size() ; i ++) {
    		   if (i != 0) {
    			   condition += ",";
    		   }
    		   condition += "'" + kList.get(0) + "'";
    	   }
		}
		return condition;
    }
     
      
描述：

    The method seems to be building a String using concatenation in a loop. In each iteration, the 
	String is converted to a StringBuffer/StringBuilder, appended to, and converted back to a String.
	This can lead to a cost quadratic in the number of iterations, as the growing string is recopied
	in each iteration.
	Better performance can be obtained by using a StringBuffer (or StringBuilder in Java 1.5) explicitly.
	
建议：

	For example:
	// This is bad
	String s = "";
	for (int i = 0; i < field.length; ++i) {
		s = s + field[i];
	}

	// This is better
	StringBuffer buf = new StringBuffer();
	for (int i = 0; i < field.length; ++i) {
		buf.append(field[i]);
	}
	String s = buf.toString();

# Inefficient Map Iterator
SVN:   

	CodeFarmerClub/baseplatform/workflow/trunk/wfpt4
	
判例:

	com.yixin.wfpt.util.redis.RedisClientService.java:216
	
代码：
      
    public Set<String> getKeys(String pattern) {
        ... 
        Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();  
        for(String k : clusterNodes.keySet()){  
            JedisPool jp = clusterNodes.get(k);  
            ... 
        }  
        ...
    }
     
描述：

	This method accesses the value of a Map entry, using a key that was retrieved from a keySet 
	iterator. It is more efficient to use an iterator on the entrySet of the map, to avoid the 
	Map.get(key) lookup.
    
建议：

	if(clusterNodes != null){
		for(Entry<String, JedisPool> node : clusterNodes.entrySet()){
			System.out.println("key:"+node.getKey()+",value:"+node.getValue());
		}
	}

参考：

[Inefficient use of keySet iterator instead of entrySet iterator](http://stackoverflow.com/questions/12639259/findbugs-warning-inefficient-use-of-keyset-iterator-instead-of-entryset-iterato)
