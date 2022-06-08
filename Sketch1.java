import processing.core.PApplet;
import processing.core.PImage;

public class Sketch1 extends PApplet {
    
// Importing Images
PImage sonic_spritesheet;

PImage sonic_rightsheet;
PImage sonic_leftsheet;

PImage[] sonic_right;
PImage[] sonic_left;

// Declaring Variables
int intSonic_right = 8;
int intSonic_left = 8;
int intSonic_frameWidth = 40;
int intSonic_frameHeight = 40;
int intSonicX = 20;
int intSonicY = 80;
boolean dPressed = false;
boolean aPressed = false;

public void settings() {
// put your size call here
  size(400, 400);

}

public void setup() {
  background(210, 255, 173);

  // Load Sonic Runnning Right Spritesheet
  sonic_spritesheet = loadImage("Sonicsheet.png");
  sonic_rightsheet = sonic_spritesheet.get(2,267, intSonic_frameWidth*intSonic_right, intSonic_frameHeight );

  // load sonic running left spritesheet
  sonic_spritesheet = loadImage("Sonicsheet right.png");
  sonic_leftsheet = sonic_spritesheet.get();

  // load the sonic Running Right from the spritesheet
  sonic_right = new PImage[intSonic_right];
  for(int frameNum = 0; frameNum < intSonic_right; frameNum++ ){
    sonic_right[frameNum] = sonic_rightsheet.get(intSonic_frameWidth*frameNum, 0, intSonic_frameWidth, intSonic_frameHeight );
  }

  sonic_left = new PImage[intSonic_left];
  for(int frameNum = 0; frameNum < intSonic_right; frameNum++ ){
    sonic_left[frameNum] = sonic_leftsheet.get(intSonic_frameWidth*frameNum, 0, intSonic_frameWidth, intSonic_frameHeight);
  }

}
public void draw() {
  // Background
  background(0, 0, 0);

  // Draw Sonic to other side of the screen to 
  if(intSonicX > width){
    intSonicX = 0 - intSonic_frameWidth;
    }

  // Movement for Sonic
  if (dPressed) {
    intSonicX += 2;
    image(sonic_right[(frameCount/3)%intSonic_right], intSonicX, intSonicY);
   } 

  if (aPressed) {
    intSonicX -= 2;
    image(sonic_left[(frameCount/3)%intSonic_right], intSonicX, intSonicY);
  }

  if (intSonicX == 0) {
    // sonic standing spritesheet

  }
   
 }

public void keyPressed() {
if (key == 'd') {
  dPressed = true;
}

if (key == 'a') {
  aPressed = true;
}
}

public void keyReleased() {
  if (key == 'd') {
    dPressed = false;
  }
  
  if (key == 'a') {
    aPressed = false;
  }

}
}