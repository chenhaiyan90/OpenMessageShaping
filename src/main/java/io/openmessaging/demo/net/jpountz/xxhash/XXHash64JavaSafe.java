// Auto-generated: DO NOT EDIT

package io.openmessaging.demo.net.jpountz.xxhash;

import io.openmessaging.demo.net.jpountz.util.ByteBufferUtils;
import io.openmessaging.demo.net.jpountz.util.SafeUtils;

import java.nio.ByteBuffer;

import static java.lang.Long.rotateLeft;

/**
 * {@link XXHash64} implementation.
 */
final class XXHash64JavaSafe extends XXHash64 {

  public static final XXHash64 INSTANCE = new XXHash64JavaSafe();

  @Override
  public long hash(byte[] buf, int off, int len, long seed) {

    SafeUtils.checkRange(buf, off, len);

    final int end = off + len;
    long h64;

    if (len >= 32) {
      final int limit = end - 32;
      long v1 = seed + XXHashConstants.PRIME64_1 + XXHashConstants.PRIME64_2;
      long v2 = seed + XXHashConstants.PRIME64_2;
      long v3 = seed + 0;
      long v4 = seed - XXHashConstants.PRIME64_1;
      do {
        v1 += SafeUtils.readLongLE(buf, off) * XXHashConstants.PRIME64_2;
        v1 = rotateLeft(v1, 31);
        v1 *= XXHashConstants.PRIME64_1;
        off += 8;

        v2 += SafeUtils.readLongLE(buf, off) * XXHashConstants.PRIME64_2;
        v2 = rotateLeft(v2, 31);
        v2 *= XXHashConstants.PRIME64_1;
        off += 8;

        v3 += SafeUtils.readLongLE(buf, off) * XXHashConstants.PRIME64_2;
        v3 = rotateLeft(v3, 31);
        v3 *= XXHashConstants.PRIME64_1;
        off += 8;

        v4 += SafeUtils.readLongLE(buf, off) * XXHashConstants.PRIME64_2;
        v4 = rotateLeft(v4, 31);
        v4 *= XXHashConstants.PRIME64_1;
        off += 8;
      } while (off <= limit);

      h64 = rotateLeft(v1, 1) + rotateLeft(v2, 7) + rotateLeft(v3, 12) + rotateLeft(v4, 18);

      v1 *= XXHashConstants.PRIME64_2; v1 = rotateLeft(v1, 31); v1 *= XXHashConstants.PRIME64_1; h64 ^= v1;
      h64 = h64 * XXHashConstants.PRIME64_1 + XXHashConstants.PRIME64_4;

      v2 *= XXHashConstants.PRIME64_2; v2 = rotateLeft(v2, 31); v2 *= XXHashConstants.PRIME64_1; h64 ^= v2;
      h64 = h64 * XXHashConstants.PRIME64_1 + XXHashConstants.PRIME64_4;

      v3 *= XXHashConstants.PRIME64_2; v3 = rotateLeft(v3, 31); v3 *= XXHashConstants.PRIME64_1; h64 ^= v3;
      h64 = h64 * XXHashConstants.PRIME64_1 + XXHashConstants.PRIME64_4;

      v4 *= XXHashConstants.PRIME64_2; v4 = rotateLeft(v4, 31); v4 *= XXHashConstants.PRIME64_1; h64 ^= v4;
      h64 = h64 * XXHashConstants.PRIME64_1 + XXHashConstants.PRIME64_4;
    } else {
      h64 = seed + XXHashConstants.PRIME64_5;
    }

    h64 += len;

    while (off <= end - 8) {
      long k1 = SafeUtils.readLongLE(buf, off);
      k1 *= XXHashConstants.PRIME64_2; k1 = rotateLeft(k1, 31); k1 *= XXHashConstants.PRIME64_1; h64 ^= k1;
      h64 = rotateLeft(h64, 27) * XXHashConstants.PRIME64_1 + XXHashConstants.PRIME64_4;
      off += 8;
    }

    if (off <= end - 4) {
      h64 ^= (SafeUtils.readIntLE(buf, off) & 0xFFFFFFFFL) * XXHashConstants.PRIME64_1;
      h64 = rotateLeft(h64, 23) * XXHashConstants.PRIME64_2 + XXHashConstants.PRIME64_3;
      off += 4;
    }

    while (off < end) {
      h64 ^= (SafeUtils.readByte(buf, off) & 0xFF) * XXHashConstants.PRIME64_5;
      h64 = rotateLeft(h64, 11) * XXHashConstants.PRIME64_1;
      ++off;
    }

    h64 ^= h64 >>> 33;
    h64 *= XXHashConstants.PRIME64_2;
    h64 ^= h64 >>> 29;
    h64 *= XXHashConstants.PRIME64_3;
    h64 ^= h64 >>> 32;

    return h64;
  }

  @Override
  public long hash(ByteBuffer buf, int off, int len, long seed) {

    if (buf.hasArray()) {
      return hash(buf.array(), off + buf.arrayOffset(), len, seed);
    }
    ByteBufferUtils.checkRange(buf, off, len);
    buf = ByteBufferUtils.inLittleEndianOrder(buf);

    final int end = off + len;
    long h64;

    if (len >= 32) {
      final int limit = end - 32;
      long v1 = seed + XXHashConstants.PRIME64_1 + XXHashConstants.PRIME64_2;
      long v2 = seed + XXHashConstants.PRIME64_2;
      long v3 = seed + 0;
      long v4 = seed - XXHashConstants.PRIME64_1;
      do {
        v1 += ByteBufferUtils.readLongLE(buf, off) * XXHashConstants.PRIME64_2;
        v1 = rotateLeft(v1, 31);
        v1 *= XXHashConstants.PRIME64_1;
        off += 8;

        v2 += ByteBufferUtils.readLongLE(buf, off) * XXHashConstants.PRIME64_2;
        v2 = rotateLeft(v2, 31);
        v2 *= XXHashConstants.PRIME64_1;
        off += 8;

        v3 += ByteBufferUtils.readLongLE(buf, off) * XXHashConstants.PRIME64_2;
        v3 = rotateLeft(v3, 31);
        v3 *= XXHashConstants.PRIME64_1;
        off += 8;

        v4 += ByteBufferUtils.readLongLE(buf, off) * XXHashConstants.PRIME64_2;
        v4 = rotateLeft(v4, 31);
        v4 *= XXHashConstants.PRIME64_1;
        off += 8;
      } while (off <= limit);

      h64 = rotateLeft(v1, 1) + rotateLeft(v2, 7) + rotateLeft(v3, 12) + rotateLeft(v4, 18);

      v1 *= XXHashConstants.PRIME64_2; v1 = rotateLeft(v1, 31); v1 *= XXHashConstants.PRIME64_1; h64 ^= v1;
      h64 = h64 * XXHashConstants.PRIME64_1 + XXHashConstants.PRIME64_4;

      v2 *= XXHashConstants.PRIME64_2; v2 = rotateLeft(v2, 31); v2 *= XXHashConstants.PRIME64_1; h64 ^= v2;
      h64 = h64 * XXHashConstants.PRIME64_1 + XXHashConstants.PRIME64_4;

      v3 *= XXHashConstants.PRIME64_2; v3 = rotateLeft(v3, 31); v3 *= XXHashConstants.PRIME64_1; h64 ^= v3;
      h64 = h64 * XXHashConstants.PRIME64_1 + XXHashConstants.PRIME64_4;

      v4 *= XXHashConstants.PRIME64_2; v4 = rotateLeft(v4, 31); v4 *= XXHashConstants.PRIME64_1; h64 ^= v4;
      h64 = h64 * XXHashConstants.PRIME64_1 + XXHashConstants.PRIME64_4;
    } else {
      h64 = seed + XXHashConstants.PRIME64_5;
    }

    h64 += len;

    while (off <= end - 8) {
      long k1 = ByteBufferUtils.readLongLE(buf, off);
      k1 *= XXHashConstants.PRIME64_2; k1 = rotateLeft(k1, 31); k1 *= XXHashConstants.PRIME64_1; h64 ^= k1;
      h64 = rotateLeft(h64, 27) * XXHashConstants.PRIME64_1 + XXHashConstants.PRIME64_4;
      off += 8;
    }

    if (off <= end - 4) {
      h64 ^= (ByteBufferUtils.readIntLE(buf, off) & 0xFFFFFFFFL) * XXHashConstants.PRIME64_1;
      h64 = rotateLeft(h64, 23) * XXHashConstants.PRIME64_2 + XXHashConstants.PRIME64_3;
      off += 4;
    }

    while (off < end) {
      h64 ^= (ByteBufferUtils.readByte(buf, off) & 0xFF) * XXHashConstants.PRIME64_5;
      h64 = rotateLeft(h64, 11) * XXHashConstants.PRIME64_1;
      ++off;
    }

    h64 ^= h64 >>> 33;
    h64 *= XXHashConstants.PRIME64_2;
    h64 ^= h64 >>> 29;
    h64 *= XXHashConstants.PRIME64_3;
    h64 ^= h64 >>> 32;

    return h64;
  }


}

