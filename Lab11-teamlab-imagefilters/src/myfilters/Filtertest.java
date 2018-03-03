package myfilters;

import java.awt.Color;
import se.lth.cs.pt.images.ImageFilter;

/** IdentityFilter beskriver en identitetstransformation */
public class Filtertest extends ImageFilter {
	public Filtertest(String name) {
		super(name);
	}
	
	public Color[][] apply(Color[][] inPixels, double paramValue) {
		int height = inPixels.length;
		int width = inPixels[0].length;
		Color[][] outPixels = new Color[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Color pixel = inPixels[i][j];
				int[] rgb = { pixel.getRed(), pixel.getGreen(), pixel.getBlue() };
				for (int k = 0; k < rgb.length; k++) {
//					if (rgb[k] >= 128) {
						switch (k) {
						case 0:
							rgb[k] = rgb[k] + (int) paramValue;
							break;
						case 1:
							rgb[k] = rgb[k] - (int) paramValue;
							break;
						case 2:
							rgb[k] = rgb[k] - (int) paramValue;
							break;
						}
						rgb[k] = rgb[k] + (int) paramValue;
						if (rgb[k] > 255) {
							rgb[k] = 255;
						}
//					}
//					if (rgb[k] < 128) {
//						switch (k) {
//						case 0:
//							rgb[k] = rgb[k] - (int) paramValue;
//							break;
//						case 1:
//							rgb[k] = rgb[k] + (int) paramValue;
//							break;
//						case 2:
//							rgb[k] = rgb[k] + (int) paramValue;
//							break;
//						}
//						rgb[k] = rgb[k] + (int) paramValue;
//						if (rgb[k] > 255) {
//							rgb[k] = 255;
//						}
//					}
				}
				outPixels[i][j] = new Color(rgb[0], rgb[1], rgb[2]);
			}
		}
		return outPixels;
	}
}
// if ((Math.round((double) rgb[k] / 2)) >= 128) {
// rgb[k] = rgb[k] +(int) paramValue;
//
// if (rgb[k] > 255) {
// rgb[k] = 255;
// }
// }
// if ((Math.round((double) rgb[k] / 2)) < 128){
// rgb[k] = rgb[k] -(int) paramValue ;
// if (rgb[k] < 0) {
// rgb[k] = 0;
// }
