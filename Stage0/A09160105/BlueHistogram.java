import ij.*;
import ij.IJ;
import ij.process.*;
import ij.gui.*;
import java.awt.*;
import ij.plugin.*;
import ij.plugin.frame.*;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;
import ij.ImagePlus;
​
public class BlueHistogram implements PlugIn {
​
	public void run(String args) {
		ImagePlus imp = IJ.getImage();
		ImageProcessor ip = imp.getChannelProcessor();
		int M = ip.getWidth();
		int N = ip.getHeight();
		int K = 256; 
 
		ColorProcessor.setWeightingFactors(0,0,1);
		int[] H = ip.getHistogram();
		double[] L = new double[H.length];
		int pixelNumber=M*N;
		
		for (int i = 1; i < H.length; i++) {
			L[i] = (double)(H[i])/pixelNumber; 
			L[i] = L[i - 1] + L[i];            
			IJ.log(String.valueOf(L[i]));
		}	
    }
}