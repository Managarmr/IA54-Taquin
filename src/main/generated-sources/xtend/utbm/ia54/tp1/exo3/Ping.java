package utbm.ia54.tp1.exo3;

import io.sarl.lang.annotation.Generated;
import io.sarl.lang.core.Event;

/**
 * @author Lucas
 */
@SuppressWarnings("all")
public class Ping extends Event {
  public final int index;
  
  public Ping(final int i) {
    this.index = i;
  }
  
  @Override
  @Generated
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    if (!super.equals(obj))
      return false;
    Ping other = (Ping) obj;
    if (other.index != this.index)
      return false;
    return true;
  }
  
  @Override
  @Generated
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + this.index;
    return result;
  }
  
  /**
   * Returns a String representation of the Ping event's attributes only.
   */
  @Generated
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("index  = ").append(this.index);
    return result.toString();
  }
  
  @Generated
  private final static long serialVersionUID = -1313624158L;
}
