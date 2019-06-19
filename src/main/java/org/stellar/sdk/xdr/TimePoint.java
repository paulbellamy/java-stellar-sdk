// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  typedef uint64 TimePoint;

//  ===========================================================================
public class TimePoint  {
  private Uint64 TimePoint;
  public Uint64 getTimePoint() {
    return this.TimePoint;
  }
  public void setTimePoint(Uint64 value) {
    this.TimePoint = value;
  }
  public static void encode(XdrDataOutputStream stream, TimePoint  encodedTimePoint) throws IOException {
  Uint64.encode(stream, encodedTimePoint.TimePoint);
  }
  public static TimePoint decode(XdrDataInputStream stream) throws IOException {
    TimePoint decodedTimePoint = new TimePoint();
  decodedTimePoint.TimePoint = Uint64.decode(stream);
    return decodedTimePoint;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.TimePoint);
  }
  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof TimePoint)) {
      return false;
    }

    TimePoint other = (TimePoint) object;
    return Objects.equal(this.TimePoint, other.TimePoint);
  }
}
