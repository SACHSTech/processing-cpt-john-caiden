import processing.core.PApplet;
import processing.core.PImage;

public class Sketch2 extends PApplet {
	
  PImage sonic_spritesheet;
  PImage sonic_runningsheet;
  PImage[] sonic_frames;
  int intSonic_frames = 8;
  int intSonic_frameWidth = 40;
  int intSonic_frameHeight = 40;
  int intSonicX = 20;
  int intSonicY = 80;
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {

    background(0);

    sonic_spritesheet = loadImage("Sonicsheet.png");
    sonic_runningsheet = sonic_spritesheet.get(2,267, intSonic_frameWidth*intSonic_frames, intSonic_frameHeight );

    sonic_frames = new PImage[intSonic_frames];
    for(int frameNum = 0; frameNum < intSonic_frames; frameNum++ ){
      System.out.println("load frames");
      sonic_frames[frameNum] = sonic_runningsheet.get(intSonic_frameWidth*frameNum, 0, intSonic_frameWidth, intSonic_frameHeight );
    }
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

	  image(sonic_frames[(frameCount/3)%intSonic_frames], intSonicX, intSonicY);
    intSonicX += 2;

    if(intSonicX > width){
      intSonicX = 0 - intSonic_frameWidth;
    }
    
    
  }
  
  // define other methods down here.
}