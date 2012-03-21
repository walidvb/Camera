import processing.core.*;
import processing.video.*;
import java.awt.event.*;

public class Cam extends PApplet{

	Capture myCapture;
	String path = "/Users/Gaston/Desktop/proc/";
	public void setup() 
	{
		println(Capture.list());

	  size(1000, 800);
	  //background (255);    // Set bg to white
	  //noStroke();          //uncomment this line to remove the stroke
	  frameRate(100);       // Set framerate
	  smooth();            // Antialiasing
	  myCapture = new Capture(this, width, height, 30);
	}

	void captureEvent(Capture myCapture) {
	  myCapture.read();
	}

	public void draw() {
	  float pointillize = map(mouseX, 0, width, 2, 20);
	  int x = (int)(random(myCapture.width));
	  int y = (int)(random(myCapture.height));
	  captureEvent(myCapture);
	  image(myCapture, 0, 0);
}

	// SAVE IMAGE
	int saveincr;
	public void mousePressed() 
	{
	 saveincr++;
	 save(path + "image"+saveincr+".jpg");
	}
}
