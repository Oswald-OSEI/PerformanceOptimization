package springdata.springdata.config;
import org.springframework.stereotype.Service;

import java.lang.management.*;
import java.util.List;

@Service
public class GcStatsUtil {
    public long getGarbageCollectionTime() {
        long gcTime = 0;
        for (GarbageCollectorMXBean gcBean : ManagementFactory.getGarbageCollectorMXBeans()) {
            gcTime += gcBean.getCollectionTime();
        }
        return gcTime;
    }

    public long getGarbageCollectionCount() {
        long gcCount = 0;
        for (GarbageCollectorMXBean gcBean : ManagementFactory.getGarbageCollectorMXBeans()) {
            gcCount += gcBean.getCollectionCount();
        }
        return gcCount;
    }

    public long getMemoryUsage() {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        return memoryBean.getHeapMemoryUsage().getUsed();
    }



    public static String getGcStats() throws Exception {
        StringBuilder stats = new StringBuilder();

        // Get the garbage collection MXBeans
        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcBean : gcBeans) {
            stats.append("GC Name: ").append(gcBean.getName()).append("\n");
            stats.append("GC Collections: ").append(gcBean.getCollectionCount()).append("\n");
            stats.append("GC Time (ms): ").append(gcBean.getCollectionTime()).append("\n");
            stats.append("--------------\n");
        }

        // Get memory usage details
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();

        stats.append("Heap Memory Used: ").append(heapMemoryUsage.getUsed()).append("\n");
        stats.append("Heap Memory Max: ").append(heapMemoryUsage.getMax()).append("\n");
        stats.append("Non-Heap Memory Used: ").append(nonHeapMemoryUsage.getUsed()).append("\n");
        stats.append("Non-Heap Memory Max: ").append(nonHeapMemoryUsage.getMax()).append("\n");

        return stats.toString();
    }
}
