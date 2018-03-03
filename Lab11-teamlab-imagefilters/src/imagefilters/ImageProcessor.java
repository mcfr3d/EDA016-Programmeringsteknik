package imagefilters;

import myfilters.Filtertest;
import myfilters.Filtertest2;
import myfilters.NegativeFilter;
import myfilters.XORCryptFilter;
import se.lth.cs.pt.images.ImageFilter;
import se.lth.cs.pt.images.ImageGUI;

public class ImageProcessor {
	public static void main(String[] args) {
		ImageFilter[] filters = new ImageFilter[5];
		filters[0] = new IdentityFilter("Identity Filter");
		filters[1]= new NegativeFilter("Negative Filter");
		filters[2] = new XORCryptFilter("XORCrypTFilter");
		filters[3] = new Filtertest2("Filtertest2");
		filters[4] = new Filtertest("Filtertest");
		new ImageGUI(filters);
	}
}