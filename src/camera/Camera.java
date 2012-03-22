package camera;

import processing.core.PApplet;
import processing.core.PImage;
import processing.video.Capture;


public class Camera extends PApplet {
	Capture myCam;
	String path = selectFolder("Select your destination folder:") +"/";
	PImage face;
	int picNumber = 1;
	int flash = 0;
	public void setup() {
		size(380, 640);

		myCam = new Capture(this, 380, 640, 30);
		face = loadImage("face2.png");
		//face.resize(this.width, this.height);
		println(myCam.width + " " + myCam.height);
	}

	public void draw() 
	{
		myCam.read();
		/*
		 * PImage myCamRight = myCam;
		myCamRight.loadPixels();
		myCam.loadPixels();

		for(int i = 1; i < myCam.pixels.length; i++)
		{
			myCamRight.pixels[i-1] = myCam.pixels[myCam.pixels.length-i];
		}
		myCamRight.updatePixels();
		*/
		image(myCam, 0, 0);

		image(face, -150, 0);
		
		if(flash > 0)
		{
			rect(0, 0, this.width, this.height);
			fill(255, flash);
			flash-=10;
		}
	}

	public void keyPressed()
	{
		if(key == 'a' || key == ' ')
		{
			
			if(!myCam.available())
			{
				myCam.read();

				String imgName = "face";
				String destFile = path + imgName +"_"+ picNumber + ".jpeg";
				picNumber++;
				println(destFile);
				myCam.save(destFile);
			}
			flash = 255;
		}
	}
	
	public static void main(String args[])
    {
      PApplet.main(new String[] { "--present", camera.Camera.class.getName() });
    }
}
