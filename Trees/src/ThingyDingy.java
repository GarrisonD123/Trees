
public class ThingyDingy implements Comparable<ThingyDingy>{
	public int value;
	public int compareTo(ThingyDingy oTD) {
      if(this.value> oTD.value)
    	  return 1;
      else if(this.value < oTD.value) {
    	  return -1;
      }
      else
    	  return 0;
	}
}
