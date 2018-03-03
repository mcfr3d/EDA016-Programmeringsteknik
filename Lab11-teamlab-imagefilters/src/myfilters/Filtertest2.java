package myfilters;

import java.awt.Color;
import se.lth.cs.pt.images.ImageFilter;

/** IdentityFilter beskriver en identitetstransformation */
public class Filtertest2 extends ImageFilter {
	public Filtertest2(String name) {
		super(name);
	}

	public Color[][] apply(Color[][] inPixels, double paramValue) {
		int height = inPixels.length;
		int width = inPixels[0].length;
		Color[][] outPixels = new Color[height][width];
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Color pixel = inPixels[i][j];
				int[] rgb = {pixel.getRed(), pixel.getGreen(), pixel.getBlue() };
				int[] oldrgb=rgb.clone();
//				{rgb[0],rgb[1],rgb[2]};
				
				for (int k = 0; k < rgb.length; k++) {
					
					switch(k){
					case 0: rgb[k]=oldrgb[1]; break;
					case 1: rgb[k]=oldrgb[2]; break;
					case 2: rgb[k]=oldrgb[0]; break;
					}

				}

				outPixels[i][j] = new Color(rgb[0], rgb[1], rgb[2]);
			}
		}
		return outPixels;
	}
}