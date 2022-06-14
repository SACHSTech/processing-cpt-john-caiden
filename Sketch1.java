import processing.core.PApplet;
import processing.core.PImage;

public class Sketch1 extends PApplet {
    
// Importing Images
PImage Sonicfall;

PImage sonic_spritesheet;

PImage sonic_rightsheet;
PImage sonic_leftsheet;
PImage sonic_stillsheet;

PImage[] sonic_right;
PImage[] sonic_left;
PImage[] sonic_still;

// Declaring Variables
int intSonic_right = 8;
int intSonic_left = 8;
int intSonic_still = 3;
int intSonic_frameWidth = 40;
int intSonic_frameHeight = 40;
int intSonicX;
int intSonicY;
boolean dPressed = false;
boolean aPressed = false;

// test variable for sketch 2
boolean jumping = true;

public void settings() {
// put your size call here
  size(400, 400);

}

public void setup() {
  background(210, 255, 173);

  // load sonic standing still spritesheet
  sonic_spritesheet = loadImage("Sonicsheet right.png");
  sonic_stillsheet = sonic_spritesheet.get(222, 816, intSonic_frameWidth*intSonic_right, intSonic_frameHeight);

  // load sonic runnning right spritesheet
  sonic_spritesheet = loadImage("Sonicsheet right.png");
  sonic_rightsheet = sonic_spritesheet.get(2,267, intSonic_frameWidth*intSonic_right, intSonic_frameHeight);

  // load sonic running left spritesheet
  sonic_spritesheet = loadImage("Sonicsheet left.png");
  sonic_leftsheet = sonic_spritesheet.get(244, 267, intSonic_frameWidth*intSonic_left, intSonic_frameHeight);

  // load the sonic running right from the spritesheet
  sonic_right = new PImage[intSonic_right];
  for(int frameNum = 0; frameNum < intSonic_right; frameNum++ ){
    sonic_right[frameNum] = sonic_rightsheet.get(intSonic_frameWidth*frameNum, 0, intSonic_frameWidth, intSonic_frameHeight);
  }

  // load the sonic running left from the spritesheet
  sonic_left = new PImage[intSonic_left];
  for(int frameNum = 0; frameNum < intSonic_left; frameNum++ ){
    sonic_left[frameNum] = sonic_leftsheet.get(intSonic_frameWidth*frameNum, 0, intSonic_frameWidth, intSonic_frameHeight);
  }

  // load the sonic standing still from the spritesheet
  sonic_still = new PImage[intSonic_still];
  for(int frameNum = 0; frameNum < intSonic_still; frameNum++) {
    sonic_still[frameNum] = sonic_stillsheet.get(intSonic_frameWidth*frameNum, 0, intSonic_frameWidth, intSonic_frameHeight);
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
  if (jumping = true) {
    Sonicfall = loadImage("Sonicfall.png");
    Sonicfall.resize(30, 40);
    image(Sonicfall, intSonicX, intSonicY);
  }
  else if (dPressed) {
    intSonicX += 2;
    image(sonic_right[(frameCount/3)%intSonic_right], intSonicX, intSonicY);
   } 
  else if (aPressed) {
    intSonicX -= 2;
    image(sonic_left[(frameCount/3)%intSonic_left], intSonicX, intSonicY);
  }
  else {
    image(sonic_still[(frameCount/10)%intSonic_still], intSonicX, intSonicY);
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
