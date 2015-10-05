package druzy.utils;

public class IntegerUtils {

	private IntegerUtils() {}
	
	public static boolean isInteger(String str){
		boolean ret=true;
		if (str.length()==0) return false;
		else{
			for (int i=0;i<str.length() && ret;i++){
				if (!Character.isDigit(str.charAt(i))) ret=false;
			}
			return ret;
		}
	}

}
