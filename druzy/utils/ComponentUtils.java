package druzy.utils;

import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

public class ComponentUtils {

	private ComponentUtils() {}
	
	public static void setMaximumSizeToMaximumWindowBounds(Component c){
		GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
		c.setMaximumSize(maximumWindowBounds.getSize());
	}
}
