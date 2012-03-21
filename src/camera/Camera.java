package camera;

import controlP5.ControlEvent;
import processing.core.PApplet;
import processing.core.PImage;
import processing.video.Capture;


public class Camera extends PApplet {
	Capture myCam;
	String path = selectFolder("Select your destination folder:") +"/";
	int picNumber = 1;
	public void setup() {
		  myCam = new Capture(this, width, height, 30);

	}

	public void draw() 
	{
		myCam.read();
		image(myCam, 0, 0);
	}
	
	public void keyPressed()
	{
		if(key == 'n')
		{
			myCam.read();
			String imgName = "face";
			String destFile = path + imgName +"_"+ picNumber++ + ".jpeg";
			PImage myFace = myCam;
			println(destFile);
			save(destFile);
		}
	}
}
