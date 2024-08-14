### IPv4 Address Counting

Since all IPv4 addresses are in the range `000.000.000.000` to `255.255.255.255`, there are `256^4 = 2^32` possible addresses.

To store these `2^32` addresses in a HashSet as integers, we would need `2^32 * 4` bytes, or 16 GB of memory.
To reduce memory consumption, instead of storing integers, we can store booleans.

One challenge is that the size of an array is limited to `2^31` elements.
However, by using two arrays, we can accommodate the entire `2^32` addresses and reduce the required memory to `2 * 2^31` bytes (4 GB).
The division into two bit sets is based on the sign bit of the number: 
- if the sign bit is 0, the value is stored in the first bit set
- if the sign bit is 1, it is stored in the second bit set.

A more efficient approach utilizes the BitSet class, which uses only 1 bit per boolean value.
This means we can store 8 booleans in one byte, reducing the required memory to `2 * 2^31 / 8` bytes (0.5 GB).

The `DoubleBitSet` and `IpCounter` classes implement this idea.

Since we use two bit sets, we can access them concurrently.

The `ConcurrentDoubleBitSet` and `ConcurrentIpCounter` classes follow this principle.
I experimented with using 2, 10, and 16 locks for each bit set (similar to ConcurrentHashMap),
but it had no significant effect on performance.

#### Results

- No counting

`[476.73 seconds] Final Report: Total IPs: 8,000,000,000. Unique IPs: 0`
- Sequential Variant

`[1554.62 seconds] Final Report: Total IPs: 8,000,000,000. Unique IPs: 1,000,000,000`

- Concurrent Variant

`[964.29 seconds] Final Report: Total IPs: 8,000,000,000. Unique IPs: 1,000,000,000`
