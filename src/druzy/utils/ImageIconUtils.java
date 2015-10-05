/** package pour manier les ImageIcon
*Pour toute question ou remarque,
*Contact : jonathan.legreneur@free.fr
*@author Le Greneur jonathan
*@version 1.0
*@since 1.7
*/


/** Classe static pour manier les ImageIcon
* @since 1.7
* @version 1.0
*/

package druzy.utils;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageIconUtils{

	//variables ///{{{
	///}}}

	//constructeurs ///{{{
	private ImageIconUtils(){}
	///}}}

	//getters ///{{{
	///}}}

	//setters ///{{{
	///}}}
	
	public static ImageIcon resize(File f,Dimension d) throws IOException{
		return new ImageIcon(ImageIO.read(f).getScaledInstance((int)d.getWidth(),(int)d.getHeight(), Image.SCALE_DEFAULT));
	}
	
	public static ImageIcon resize(ImageIcon ii, Dimension d){
		return new ImageIcon(ii.getImage().getScaledInstance((int)d.getWidth(),(int)d.getHeight(),Image.SCALE_DEFAULT));	
	}
	
	public static ImageIcon resize(ImageIcon ii, int dim){
		return resize(ii,new Dimension(dim,dim));
	}

}

