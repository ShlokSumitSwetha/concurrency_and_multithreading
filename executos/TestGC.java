package Complete_Concurrent_Collections.executos;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class TestGC {
	public static void main(String[] args) throws Exception {
		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
		ObjectName gcName = new ObjectName("java.lang:type=GarbageCollector,*");

		// Get the list of GarbageCollector MBeans
		for (ObjectName name : mBeanServer.queryNames(gcName, null)) {
			String gcCollectorName = name.getKeyProperty("name");
			String gcCollectorType = (String) mBeanServer.getAttribute(name, "Name");

			System.out.println("GC Collector Name: " + gcCollectorName);
			System.out.println("GC Collector Type: " + gcCollectorType);
		}
	}
}

