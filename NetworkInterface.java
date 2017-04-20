
public class NetworkInterface 
{
	// Constructor
	String macAddress; 
	public NetworkInterface(String MAC_address) 
	{
		this.macAddress = MAC_address;
		
	}
	
	// Check if the MAC address is the same as the given string
	public boolean equals(String address) 
	{
		if ( macAddress.equals(address)){
			
			return true;
		}
		else return false;
	}
}
