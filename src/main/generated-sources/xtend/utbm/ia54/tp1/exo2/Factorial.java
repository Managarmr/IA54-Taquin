package utbm.ia54.tp1.exo2;

import io.sarl.lang.annotation.Generated;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Event;

/**
 * @author Lucas
 */
@SuppressWarnings("all")
public class Factorial extends Event {
  public Long number;
  
  public Long value;
  
  /**
   * Construct an event. The source of the event is unknown.
   */
  @Generated
  public Factorial() {
    super();
  }
  
  /**
   * Construct an event.
   * @param source - address of the agent that is emitting this event.
   */
  @Generated
  public Factorial(final Address source) {
    super(source);
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
    Factorial other = (Factorial) obj;
    if (this.number == null) {
      if (other.number != null)
        return false;
    } else if (!this.number.equals(other.number))
      return false;
    if (this.value == null) {
      if (other.value != null)
        return false;
    } else if (!this.value.equals(other.value))
      return false;
    return true;
  }
  
  @Override
  @Generated
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.number== null) ? 0 : this.number.hashCode());
    result = prime * result + ((this.value== null) ? 0 : this.value.hashCode());
    return result;
  }
  
  /**
   * Returns a String representation of the Factorial event's attributes only.
   */
  @Generated
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("number  = ").append(this.number);
    result.append("value  = ").append(this.value);
    return result.toString();
  }
  
  @Generated
  private final static long serialVersionUID = -334022904L;
}
