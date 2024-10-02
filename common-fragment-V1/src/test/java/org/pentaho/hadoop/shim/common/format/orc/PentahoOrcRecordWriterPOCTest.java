package org.pentaho.hadoop.shim.common.format.orc;

import junit.framework.TestCase;
import org.apache.hadoop.conf.Configuration;
import org.apache.orc.impl.HadoopShims;
import org.apache.orc.impl.HadoopShimsCurrent;
import org.junit.Test;

import java.util.Random;

public class PentahoOrcRecordWriterPOCTest extends TestCase {

  @Test
  public void testCryptoUtilsCreate() throws Exception {
    /**
     * v2.0.0
     *  - https://github.com/apache/orc/blob/v2.0.0/java/core/src/java/org/apache/orc/impl/CryptoUtils.java
     *  - https://github.com/apache/orc/blob/v2.0.0/java/core/src/java/org/apache/orc/impl/HadoopShimsFactory.java
     * v1.6.1
     *  - https://github.com/apache/orc/blob/rel/release-1.6.1/java/core/src/java/org/apache/orc/impl/CryptoUtils.java
     *  - https://github.com/apache/orc/blob/rel/release-1.6.1/java/core/src/java/org/apache/orc/impl/HadoopShimsFactory.java
     */

    HadoopShimsCurrent  hsc = new HadoopShimsCurrent();
    ((HadoopShims) hsc).getHadoopKeyProvider( new Configuration(), new Random() );
    System.out.println("I was able to compile and run HadoopShimsCurrent#getHadoopKeyProvider !!!!!! ");
  }

}