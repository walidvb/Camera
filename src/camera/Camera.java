package camera;

import processing.core.PApplet;
import processing.core.PImage;
import processing.video.Capture;


public class Camera extends PApplet {
	Capture myCam;
	String path = selectFolder("Select your destination folder:") +"/";
	int picNumber = 1;
	public void setup() {
		myCam = new Capture(this, 500, 500, 30);
	}

	public void draw() 
	{
		size(500, 500);
		myCam.read();
		image(myCam, 0, 0);
		ellipse(width/2, height/2, 50, 50);

	}

	public void keyPressed()
	{
		if(key == 'a')
		{
			if(myCam.available())
			{
				myCam.read();
				String imgName = "face";
				String destFile = path + imgName +"_"+ picNumber + ".jpeg";
				picNumber++;
				println(destFile);
				save(destFile);
			}
		}
	}
	
	public static void main(String args[])
    {
      PApplet.main(new String[] { "--present", camera.Camera.class.getName() });
    }
}
