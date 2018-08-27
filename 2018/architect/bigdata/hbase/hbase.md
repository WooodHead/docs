# HBase Monitor
  
  - Metrics
	
	System status : ping, available memory in percent,disk usage
	HDFS          : name port, data port, journal port, HDFS available space
    HBase         : HBase master port, HBase region servce port	
	Zookeeper 	  : ZooKeeper port , ZKFC port
	HBase RPC     : regionserver.TotalCallTime
	                regionserver.ProcessCallTime
					regionserver.QueueCallTime
					regionserver.numActiveHandler
					regionserver.numCallsInGeneralQueue
					regionserver.ipc.numOpenConnections
					regionserver.RegionServer.numCallsInWriteQueue
					regionserver.RegionServer.numCallsInReadQueue
	HBase IO      : regionserver.Server.Mutate_99th_percentile
	                regionserver.wal.SyncTime_99th_percentile
					regionserver.server.Get_99th_percentile
					regionserver.server.ScanTime_99th_percentile
	HBase region  : region size ,size, blockcache hit radio
	JVM GC        : jvm.JvmMetrics.GcTimeMillis , jvm.JvmMetrics.GcCount
	
  - Tool
  
    [Ganglia]()
    [Zabbix]()