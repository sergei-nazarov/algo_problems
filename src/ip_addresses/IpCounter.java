package ip_addresses;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class IpCounter {
    long totalIps = 0;
    long uniqueIps = 0;

    public void count(BufferedReader reader) throws IOException {

        long startTime = System.nanoTime();
        long lastReportTime = startTime;
        DoubleBitSet bitSet = new DoubleBitSet();
        String line;
        while ((line = reader.readLine()) != null) {
            uniqueIps += bitSet.add(ipToInt(line));
            totalIps++;

            if ((System.nanoTime() - lastReportTime) >= 10_000_000_000L) {
                System.out.printf("[%s] Periodic Report: Total ips: %d. Unique ips: %d%n",
                        timeSinceStart(startTime), totalIps, uniqueIps);
                lastReportTime = System.nanoTime();
            }
        }
        System.out.printf("[%s] Final Report: Total ips: %d. Unique ips: %d%n",
                timeSinceStart(startTime), totalIps, uniqueIps);
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

        IpCounter ipCounter = new IpCounter();
        ipCounter.count(bufferedReader);
    }

}
