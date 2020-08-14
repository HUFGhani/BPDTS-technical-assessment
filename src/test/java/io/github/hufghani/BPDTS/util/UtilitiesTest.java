package io.github.hufghani.BPDTS.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilitiesTest {
  @Test
  void testDistanceCal() {
    double result = Utilities.distanceCal(53.483959, -2.244644);
    Assertions.assertEquals(163.0881686282125, result);
  }x
}
