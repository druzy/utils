package druzy.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;

public class FileUtils {

	private FileUtils() {}

	public static String getText(File file){
		try {
		       BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
		       StringWriter out = new StringWriter();
		       int b;
		       while ((b=in.read()) != -1)
		           out.write(b);
		       out.flush();
		       out.close();
		       in.close();
		       return out.toString();
		    }
		    catch (IOException ie)
		    {
		         ie.printStackTrace();
		         return null;
		    }
	}

}
