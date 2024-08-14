package ip_addresses.concurrent;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.zip.ZipInputStream;

public class ConcurrentIpCounter {

    private final LongAdder totalIps = new LongAdder();
    private final LongAdder uniqueIps = new LongAdder();

    public void count(BufferedReader reader) {
        long startTime = System.nanoTime();

        ConcurrentDoubleBitSet bitSet = new ConcurrentDoubleBitSet();
        try (ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);) {
            scheduler.scheduleAtFixedRate(() -> System.out.printf("[%s] Periodic Report: Total ips: %d. Unique ips: %d%n",
                    timeSinceStart(startTime), totalIps.longValue(), uniqueIps.longValue()), 10, 10, TimeUnit.SECONDS);

            try (ForkJoinPool customThreadPool = new ForkJoinPool(4)) {
                customThreadPool.submit(() ->
                        reader.lines().parallel().forEach(line -> {
                            if (bitSet.add(ipToInt(line))) {
                                uniqueIps.increment();
                            }
                            totalIps.increment();
                        })
                ).join();

                System.out.printf("[%s] Final Report: Total ips: %d. Unique ips: %d%n",
                        timeSinceStart(startTime), totalIps.longValue(), uniqueIps.longValue());

            }
        }
    }

    private String timeSinceStart(long startTime) {
        long elapsedTime = System.nanoTime() - startTime;
        return String.format("%.2f seconds", elapsedTime / 1_000_000_000.0);
    }

    private int ipToInt(String ip) {
        String[] parts = ip.split("\\.");
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result |= (Integer.parseInt(parts[i]) << ((3 - i) * 8));
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
//        String filename = "/Users/sergey/Downloads/ip_addresses.zip";
        String filename = args[0];
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(filename));
        zipInputStream.getNextEntry();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(zipInputStream, StandardCharsets.UTF_8));

        ConcurrentIpCounter ipCounter = new ConcurrentIpCounter();
        ipCounter.count(bufferedReader);
    }

}
