import processing.core.PApplet;
import processing.core.PImage;

public class Sketch1 extends PApplet {
	
// Importing Images
PImage sonic_spritesheet;
PImage sonic_runningsheet;
PImage[] sonic_frames;

// Declaring Variables
int intSonic_frames = 8;
int intSonic_frameWidth = 40;
int intSonic_frameHeight = 40;
int intSonicX = 20;
int intSonicY = 80;



public void settings() {
// put your size call here
  size(400, 400);

}


public void setup() {
  background(210, 255, 173);

  // Load Sonic Spritesheet
  sonic_spritesheet = loadImage("Sonicsheet.png");
  sonic_runningsheet = sonic_spritesheet.get(2,267, intSonic_frameWidth*intSonic_frames, intSonic_frameHeight );

  // load the sonic frames from the spritesheet
  sonic_frames = new PImage[intSonic_frames];
  for(int frameNum = 0; frameNum < intSonic_frames; frameNum++ ){
    System.out.println("load frames");
    sonic_frames[frameNum] = sonic_runningsheet.get(intSonic_frameWidth*frameNum, 0, intSonic_frameWidth, intSonic_frameHeight );
  }

}


public void draw() {
  // Background
  background(0, 0, 0);

  // Draw Sonic to Screen
  image(sonic_frames[(frameCount/3)%intSonic_frames], intSonicX, intSonicY);
  intSonicX += 2;

  if(intSonicX > width){
    intSonicX = 0 - intSonic_frameWidth;

  }
  
}
}
