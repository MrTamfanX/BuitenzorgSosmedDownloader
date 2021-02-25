/*
 * Copyright (C) 2014 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.airbnb.lottie;

import java.nio.charset.Charset;

/**
 * 数据处理的工具类
 */
final class Util {
  /** A cheap and type-safe constant for the UTF-8 Charset. */
  public static final Charset UTF_8 = Charset.forName("UTF-8");

  private Util() {
  }


  /**
   * 用于判断数组的截取是否是否复核规矩
   * @param size  数组的长度
   * @param offset 截取的偏移值
   * @param byteCount 截取的的长度
   */
  public static void checkOffsetAndCount(long size, long offset, long byteCount) {
    if ((offset | byteCount) < 0 || offset > size || size - offset < byteCount) {
      throw new ArrayIndexOutOfBoundsException(
          String.format("size=%s offset=%s byteCount=%s", size, offset, byteCount));
    }
  }

  /**
   * 用于short 的大端、小端的转换
   */
  public static short reverseBytesShort(short s) {
    int i = s & 0xffff;
    int reversed = (i & 0xff00) >>> 8
        |          (i & 0x00ff)  << 8;
    return (short) reversed;
  }

  /**
   * 用于int 的大端、小端的转换
   */
  public static int reverseBytesInt(int i) {
    return (i & 0xff000000) >>> 24
        |  (i & 0x00ff0000) >>>  8
        |  (i & 0x0000ff00)  <<  8
        |  (i & 0x000000ff)  << 24;
  }

  /**
   * 用于Long 的大端、小端的转换
   */
  public static long reverseBytesLong(long v) {
    return (v & 0xff00000000000000L) >>> 56
        |  (v & 0x00ff000000000000L) >>> 40
        |  (v & 0x0000ff0000000000L) >>> 24
        |  (v & 0x000000ff00000000L) >>>  8
        |  (v & 0x00000000ff000000L)  <<  8
        |  (v & 0x0000000000ff0000L)  << 24
        |  (v & 0x000000000000ff00L)  << 40
        |  (v & 0x00000000000000ffL)  << 56;
  }

  /**
   * Throws {@code t}, even if the declared throws clause doesn't permit it.
   * This is a terrible – but terribly convenient – hack that makes it easy to
   * catch and rethrow exceptions after cleanup. See Java Puzzlers #43.
   *
   * 如果有异常不直接抛出异常，而是先保存异常，等清理工作完成以后再抛出异常
   */
  public static void sneakyRethrow(Throwable t) {
    Util.<Error>sneakyThrow2(t);
  }

  @SuppressWarnings("unchecked")
  private static <T extends Throwable> void sneakyThrow2(Throwable t) throws T {
    throw (T) t;
  }

  /**
   * 判断两个数组某一部分是否相等
   */
  public static boolean arrayRangeEquals(
      byte[] a, int aOffset, byte[] b, int bOffset, int byteCount) {
    for (int i = 0; i < byteCount; i++) {
      if (a[i + aOffset] != b[i + bOffset]) return false;
    }
    return true;
  }
}
