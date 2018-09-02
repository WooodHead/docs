# Issue

  - how to extract increment from big file
  
    sed -n '16224,16482 p' orig-data-file > new-file
	wc -l log.log
	
    [Best way to extract lines from a log file in Linux](https://www.unix.com/shell-programming-and-scripting/235133-extract-data-log-file-specified-range-time.html)
    [How can I extract a predetermined range of lines from a text file on Unix](https://stackoverflow.com/questions/83329/how-can-i-extract-a-predetermined-range-of-lines-from-a-text-file-on-unix)
	[How to count lines in a document](https://stackoverflow.com/questions/3137094/how-to-count-lines-in-a-document)
	
  - how to convert json to .csv
    [json2csv](https://github.com/zeMirco/json2csv)
    
# Tools

  - [Kettle](../../tool/kettle/kettle.md)
	
# Reference
	
	[大规模提取、转换和加载 (ETL)](https://docs.azure.cn/zh-cn/hdinsight/hadoop/apache-hadoop-etl-at-scale)