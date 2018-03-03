package myfilters;

import java.awt.Color;
import se.lth.cs.pt.images.ImageFilter;

/** IdentityFilter beskriver en identitetstransformation */
public class NegativeFilter extends ImageFilter {
	public NegativeFilter(String name) {
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
				
				for (int k = 0; k < rgb.length; k++) {
					rgb[k] =255- rgb[k];

				}

				outPixels[i][j] = new Color(rgb[0], rgb[1], rgb[2]);
			}
		}
		return outPixels;
	}
}