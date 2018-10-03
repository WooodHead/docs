# Comparator doesn't implement Serializable

SVN:   

	CodeFarmerClub/baseplatform/workflow/trunk/wfpt4
	
判例:

	com.yixin.wfpt.util.redis.ListComparatorProxy.java:15
	

代码：
      
    public class ListComparatorProxy implements Comparator<...> {

		...
	}
     
      
描述：

    This class implements the Comparator interface. You should consider whether or not it should also
	implement the Serializable interface. If a comparator is used to construct an ordered collection
	such as a TreeMap, then the TreeMap will be serializable only if the comparator is also serializable. 
	As most comparators have little or no state, making them serializable is generally easy and good
	defensive programming.
	
建议:

	java.util.Comparator<T>
	
	Note: It is generally a good idea for comparators to also implement java.io.Serializable, as they 
	may be used as ordering methods in serializable data structures (like TreeSet, TreeMap). In order
	for the data structure to serialize successfully, the comparator (if provided) must implement 
	Serializable.
	
	实现java.util.Comparator接口建议同时实现java.io.Serializable
	

参考：

[Comparator](http://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html)


	
     
    
	 
 

