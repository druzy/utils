package druzy.version;

import java.util.ArrayList;
import druzy.utils.IntegerUtils;

public class Version extends ArrayList<Integer> implements Comparable<Version>{

	private static final long serialVersionUID = -8782174357690196590L;
	
	public Version() {
		this("1");
		
	}
	
	public Version(int n){
		this(String.valueOf(n));
	}
	
	public Version(String version){
		super();
		if (version==null) throw new NullPointerException("version cannot be null");
		if (version.length()==0) throw new IllegalArgumentException("version is empty");
		
		String[] numeros=version.split("\\.");
		for (int i=0;i<numeros.length;i++){
			String num=numeros[i];
			if (!IntegerUtils.isInteger(num)) throw new IllegalArgumentException(num+" is not a numeric String");
			else this.add(Integer.parseInt(num));
		}
	}
	
	@Override
	public boolean equals(Object o){
		if (!(o instanceof Version)){
			return false;
		}else{
			Version v=(Version)o;
			return this.compareTo(v)==0;
		}
	}
	
	@Override
 	public String toString(){
		if (this.size()==0) return "";
		else{
			String ret="";
			for (int i=0;i<this.size();i++){
				ret=ret+String.valueOf(this.get(i));
				if (i<this.size()-1) ret=ret+".";
			}
			return ret;
		}
	}
	
	@Override
	public int compareTo(Version v) {
		int i=0;
		int ret=0;
		
		while (i<size() && i<v.size() && ret==0){
			int compare=this.get(i).compareTo(v.get(i));
			if (compare<0) ret=-1;
			else if (compare>0) ret=1;
			i++;
		}
		
		if (ret==0){
			if (size()==v.size()) return 0;
			else{
				if (size()<v.size()) return -1;
				else return 1;
			}
		}else return ret;
	}

	//pour les tests
	public static void main(String[] args){
		Version v1=new Version("24.04.3.1.3");
		Version v2=new Version ("24.4.3.1");
		System.out.println(v1.equals(v2));
	}


}
