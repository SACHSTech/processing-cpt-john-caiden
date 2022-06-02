import processing.core.PApplet;
import processing.core.PImage;

public class Sketch2 extends PApplet {
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(700, 700);
  }

  PImage img;

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0);
    img = loadImage("Preview2_0.jpg");
  }

  float groundY = 700;
  float groundY2 = 580;

  float playerX = 140;
  float playerY = 100;
  float playerWidth = 20;
  float playerHeight = 20;
  float playerSpeedY = 0;

  boolean jumping = false;

///////////////////////////////

  boolean leftPressed = false;
  boolean rightPressed = false;  

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    
  // load background
  image(img, 0, 0);
  img.resize(700, 700);

   //draw the ground
  stroke(255);
  line(0, groundY, width, groundY);

  line(0, groundY2, 200, groundY2);

  //move the player
  playerY += playerSpeedY;

  //is the player colliding with the ground?
  if (playerY + playerHeight > groundY) {

    //snap the player's bottom to the ground's position
    playerY = groundY - playerHeight;

    //stop the player falling
    playerSpeedY = 0;

    //allow jumping again
    jumping = false;
  }
  //player is not colliding with the ground
  else {
    //gravity accelerates the movement speed
    playerSpeedY ++;
  }

  //draw the player rectangle
  rect(playerX, playerY, playerWidth, playerHeight);

    
    if (leftPressed){
      playerX -= 3;
    }
    if (rightPressed){
      playerX += 3;
    }

  }
  public void keyPressed() {
    if(key == 'w') {
      if (!jumping) {
      
        //going up
        playerSpeedY = -15;
        
        //disallow jumping while already jumping
        jumping = true;
      }
    }

    else if (key == 'a') {
      leftPressed = true;
    }
    else if (key == 'd') {
      rightPressed = true;
    }
  }
  
  public void keyReleased() {
    if (key == 'a') {
      leftPressed = false;
    }
    if (key == 'd') {
      rightPressed = false;
    }
  }

}

/*import processing.core.PApplet;
import processing.core.PImage;

public class Sketch2 extends PApplet {
	
// Importing Images
PImage sonic_spritesheet;

PImage sonic_rightsheet;
PImage sonic_leftsheet;

PImage[] sonic_right;
PImage[] sonic_left;

// Declaring Variables
int intSonic_right = 8;
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

  // load the sonic Running Right from the spritesheet
  sonic_right = new PImage[intSonic_right];
  for(int frameNum = 0; frameNum < intSonic_right; frameNum++ ){
    sonic_right[frameNum] = sonic_rightsheet.get(intSonic_frameWidth*frameNum, 0, intSonic_frameWidth, intSonic_frameHeight );
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
*/