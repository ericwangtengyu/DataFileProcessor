/**
 * 
 */
package process;

/**
 * @author Eric
 *
 */
public class Tuple {

	private String bssid;
	private int value;
	
	public Tuple(String bssid,int value)
	{
		this.setBssid(bssid);
		this.setValue(value);
	}

	/**
	 * @return the bssid
	 */
	public String getBssid() {
		return bssid;
	}

	/**
	 * @param bssid the bssid to set
	 */
	public void setBssid(String bssid) {
		this.bssid = bssid;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
}
