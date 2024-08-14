package ip_addresses.concurrent;

import java.util.BitSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentDoubleBitSet {
    private final BitSet first = new BitSet();
    private final BitSet second = new BitSet();

    private final Lock firstLock = new ReentrantLock();
    private final Lock secondLock = new ReentrantLock();

    public boolean add(int value) {
        int firstBit = (value >> 31) & 1;
        int remainingBits = value & ~(1 << 31);

        if (firstBit == 0) {
            firstLock.lock();
            try {
                if (first.get(remainingBits)) {
                    return false;
                }
                first.set(remainingBits);
            } finally {
                firstLock.unlock();
            }
        } else {
            secondLock.lock();
            try {
                if (second.get(remainingBits)) {
                    return false;
                }
                second.set(remainingBits);
            } finally {
                secondLock.unlock();
            }
        }
        return true;
    }

}
