package myfilters;

import java.awt.Color;
import java.util.Random;

import se.lth.cs.pt.images.ImageFilter;

/** IdentityFilter beskriver en identitetstransformation */
public class XORCryptFilter extends ImageFilter {
	public XORCryptFilter(String name) {
		super(name);
	}

	public Color[][] apply(Color[][] inPixels, double paramValue) {
		Random rand = new Random((long) paramValue); 
		int height = inPixels.length;
		int width = inPixels[0].length;
		Color[][] outPixels = new Color[height][width];
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Color pixel = inPixels[i][j];
				int[] rgb = {pixel.getRed(), pixel.getGreen(), pixel.getBlue() };
				
				for (int k = 0; k < rgb.length; k++) {
					rgb[k] =rgb[k]^rand.nextInt(256);
//					while(rgb[k] < 0) {
//						rgb[k]++;
//					}
//					while (rgb[k] > 255) {
//						rgb[k]--;
//					}
				}

				outPixels[i][j] = new Color(rgb[0], rgb[1], rgb[2]);
			}
		}
		return outPixels;
	}
}