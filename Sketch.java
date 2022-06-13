import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
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
boolean dPressed = false;
boolean aPressed = false;
  
 // background image variable
 PImage img;

 // platform hitboxes
 float groundY = 700;
 float groundY1 = 580;
 float groundY2 = 520;
 float groundY3 = 580;
 float groundY4 = 365;
 float groundY5 = 238;
 float groundY6 = 164;
 float groundY7 = 139;
 float groundY8 = 135;

 // player coordinates and hitbox
 float playerX = 10;
 float playerY = 458;
 float playerWidth = 20;
 float playerHeight = 20;
 float playerSpeedX = 3;
 float playerSpeedY;
 
 // boolean to check when the player is jumping
 boolean jumping = false;
 
 // boolean which allows horizontal movement
 boolean leftPressed = false;
 boolean rightPressed = false;  
 boolean upPressed = false;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(700, 700);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0);
    img = loadImage("Preview2_0.jpg");

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

  public void keyPressed() {
    // allow player to jump
    if(key == 'w') {
      if (!jumping) {

        //going up
        playerSpeedY = -16;
        
        //disallow jumping while already jumping
        jumping = true;

        Sonicfall = loadImage("Sonicfall.png");
        Sonicfall.resize(30, 40);
        image(Sonicfall, playerX, playerY);
      }
      else{
      }
    }

    // allow for horizontal player movement
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

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    
  // load background
  image(img, 0, 0);
  img.resize(700, 700);



  // player always has a downward force acting upon them
  playerY += playerSpeedY;

 
  // if the player is above the ground
  if (playerY + playerHeight > groundY) {

    //snap the player's bottom to the ground's position
    playerY = groundY - playerHeight;

    //stop the player falling
    playerSpeedY = 0;

    //allow jumping again
    jumping = false;
  }
  else if (playerY + playerHeight > groundY1 && playerX < 170) {
    //snap the player's bottom to the ground's position
    playerY = groundY1 - playerHeight;

    //stop the player falling
    playerSpeedY = 0;
    
    //allow jumping again
    jumping = false;
  }
  else if (playerY + playerHeight > groundY2 && playerX > 260 && playerX < 525){
    //snap the player's bottom to the ground's position
    playerY = groundY2 - playerHeight;

    //stop the player falling
    playerSpeedY = 0;
    
    //allow jumping again
    jumping = false;
  }
  else if (playerY + playerHeight > groundY3 && playerY + playerHeight < 600 && playerX > 526 && playerX < 610){
    //snap the player's bottom to the ground's position
    playerY = groundY3 - playerHeight;

    //stop the player falling
    playerSpeedY = 0;
    
    //allow jumping again
    jumping = false;
  }
  
  else if (playerY + playerHeight > groundY4 && playerY + playerHeight < 390 && playerX > 85 && playerX < 233) {
    playerY = groundY4 - playerHeight;

    playerSpeedY = 0;
    jumping = false;
  }

  else if (playerY + playerHeight > groundY5 && playerY + playerHeight < 260 && playerX > 243 && playerX < 354) {
    playerY = groundY5 - playerHeight;

    playerSpeedY = 0;
    jumping = false;
  }

  else if (playerY + playerHeight > groundY6 && playerY + playerHeight < 190 && playerX > 360 && playerX < 480) {
    playerY = groundY6 - playerHeight;

    playerSpeedY = 0;
    jumping = false;
  }

  else if (playerY + playerHeight > groundY7 && playerY + playerHeight < 150 && playerX > 545 && playerX < 700) {
    playerY = groundY7 - playerHeight;

    playerSpeedY = 0;
    jumping = false;
  }

  else if (playerY + playerHeight > groundY8 && playerY + playerHeight < 150 && playerX > 0 && playerX < 176) {
    playerY = groundY8 - playerHeight;

    playerSpeedY = 0;
    jumping = false;
  }

  //player is not colliding with the ground
  else {
    //gravity accelerates the movement speed
    playerSpeedY ++;
  }

    //draw the player rectangle
    if (leftPressed == false && rightPressed == false && jumping == false){
      image(sonic_still[(frameCount/10)%intSonic_still], playerX, playerY - playerHeight);
    }
    else if (leftPressed == false && rightPressed == false) {
      Sonicfall = loadImage("Sonicfall.png");
      Sonicfall.resize(30, 40);
      image(Sonicfall, playerX, playerY - playerHeight);
    }

    if (leftPressed){
      image(sonic_left[(frameCount/3)%intSonic_left], playerX, playerY - playerHeight);
      if (playerX < 0) {
        playerX -= 0;
      }
      else if (playerX < 180 && playerY > groundY1) {
        playerX -= 0;
      }
      else if (playerX < 545 && playerX > 270 && playerY > groundY2) {
        playerX -= 0;
      }
      else {
        playerX -= playerSpeedX;
      }
    }

    if (rightPressed){
      image(sonic_right[(frameCount/3)%intSonic_right], playerX, playerY - playerHeight);
      if (playerX > 675) {
        playerX += 0;
      }
      else if (playerX + playerWidth > 250 && playerX < 535 && playerY > groundY2) {
        playerX += 0;
      }
      else {
        playerX += playerSpeedX;
      }
    }
  }

}
