package io.github.hufghani.BPDTS.util;

public class Utilities {

  private final static double LONDON_LATITUDE = 51.509865;
  private final static double LONDON_LONGITUDE = -0.118092;
  public static double distanceCal(Double userLatitude,
      Double userLongitude) {
    if ((LONDON_LATITUDE == userLatitude) && (LONDON_LONGITUDE == userLongitude)) {
      return 0;
    }
    else {
      double theta = LONDON_LONGITUDE - userLongitude;
      double dist = Math.sin(Math.toRadians(LONDON_LATITUDE)) * Math.sin(Math.toRadians(userLatitude)) + Math.cos(Math.toRadians(LONDON_LATITUDE)) * Math.cos(Math.toRadians(userLatitude)) * Math.cos(Math.toRadians(theta));
      dist = Math.acos(dist);
      dist = Math.toDegrees(dist);
      dist = dist * 60 * 1.1515;
      return (dist);
    }
  }
}
