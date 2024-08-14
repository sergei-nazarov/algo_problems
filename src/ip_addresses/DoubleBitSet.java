package ip_addresses;

import java.util.BitSet;

public class DoubleBitSet {

    private final BitSet first = new BitSet();
    private final BitSet second = new BitSet();

    public int add(int value) {
        int firstBit = (value >> 31) & 1;
        int remainingBits = value & ~(1 << 31);

        if (firstBit == 0) {
            if (first.get(remainingBits)) {
                return 0;
            }
            first.set(remainingBits);
        } else {
            if (second.get(remainingBits)) {
                return 0;
            }
            second.set(remainingBits);
        }
        return 1;
    }
}
