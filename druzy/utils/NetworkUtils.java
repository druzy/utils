package druzy.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Enumeration;

import org.apache.commons.codec.binary.Hex;

public class NetworkUtils {

	private NetworkUtils(){}
	
	public static InetAddress getSiteLocalAddress(){
		InetAddress address=null;
		
		Enumeration<NetworkInterface> interfaces=null;
		try {
			interfaces = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			e.printStackTrace();
			return null;
		}
		
		while (interfaces.hasMoreElements() && address==null){
			NetworkInterface net=interfaces.nextElement();
			Enumeration<InetAddress> ienum = net.getInetAddresses();
			while (ienum.hasMoreElements() && address==null) {  // retourne l adresse IPv4 et IPv6
				InetAddress ia=ienum.nextElement();
				if (ia.isSiteLocalAddress()){
					if (ia.getHostAddress().indexOf(":")<0){
						address=ia;
					}
				}
			}
		}
		return address;
	}

	public static String getHardwareAddress(NetworkInterface ni){
        if (ni != null) {
            byte[] mac=null;
			try {
				mac = ni.getHardwareAddress();
			} catch (SocketException e) {
				e.printStackTrace();
			}
            if (mac != null) {
                char[] cs=Hex.encodeHex(mac, false);
                String res="";
                for (int i=0;i<cs.length/2;i++){
                	res=res+cs[i*2]+cs[i*2+1];
                	if (i!=cs.length/2-1) res=res+":";
                }
                return res;
            } else {
                System.out.println("Address doesn't exist or is not accessible.");
                return null;
            }
        } else {
            System.out.println("Network Interface for the specified " +"address is not found.");
            return null;
        }
	}

	public static String getActualHardwareAddress(){
		try {
			return getHardwareAddress(NetworkInterface.getByInetAddress(getSiteLocalAddress()));
		} catch (SocketException e) {
			e.printStackTrace();
			return null;
		}
	}
}
