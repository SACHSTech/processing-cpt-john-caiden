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

  // Game & menu started variables
  boolean blnGameStarted;
  boolean blnMenuStarted;

  // Sonic location and movement variables
  int intSonic_right = 8;
  int intSonic_left = 8;
  int intSonic_still = 3;
  int intSonic_frameWidth = 40;
  int intSonic_frameHeight = 40;
    
  // background image variable
  PImage img;
  PImage spikes;

  // platform hitboxes
  float fltGroundY = 700;
  float fltGroundY1 = 580;
  float fltGroundY2 = 520;
  float fltGroundY3 = 580;
  float fltGroundY4 = 365;
  float fltGroundY5 = 238;
  float fltGroundY6 = 164;
  float fltGroundY7 = 139;
  float fltGroundY8 = 135;

  // player coordinates and hitbox
  float fltPlayerX = 10;
  float fltPlayerY = 458;
  float fltPlayerWidth = 20;
  float fltPlayerHeight = 20;
  float fltPlayerSpeedX = 3;
  float fltPlayerSpeedY;
 
 // boolean to check when the player is jumping
 boolean blnJumping = false;
 
 // boolean which allows horizontal movement
 boolean blnLeftPressed = false;
 boolean blnRightPressed = false;  
 boolean blnUpPressed = false;

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
    spikes = loadImage("spikes.png");

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
      if (!blnJumping) {

        //going up
        fltPlayerSpeedY = -16;
        
        //disallow jumping while already jumping
        blnJumping = true;

        Sonicfall = loadImage("Sonicfall.png");
        Sonicfall.resize(30, 40);
        image(Sonicfall, fltPlayerX, fltPlayerY);
      }
      else{
      }
    }

    // allow for horizontal player movement
    else if (key == 'a') {
      blnLeftPressed = true;
    }
    else if (key == 'd') {
      blnRightPressed = true;
    }
  }
  
  public void keyReleased() {
    if (key == 'a') {
      blnLeftPressed = false;
    }
    if (key == 'd') {
      blnRightPressed = false;
    }
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    
  // load background
  image(img, 0, 0);
  img.resize(700, 700);

  image(spikes, 540, 564);
  spikes.resize(80, 20);

  // player always has a downward force acting upon them
  fltPlayerY += fltPlayerSpeedY;
 
  // if the player is above the ground
  if (fltPlayerY + fltPlayerHeight > fltGroundY) {

    //snap the player's bottom to the ground's position
    fltPlayerY = fltGroundY - fltPlayerHeight;

    //stop the player falling
    fltPlayerSpeedY = 0;

    //allow jumping again
    blnJumping = false;
  }
  else if (fltPlayerY + fltPlayerHeight > fltGroundY1 && fltPlayerX < 170) {
    //snap the player's bottom to the ground's position
    fltPlayerY = fltGroundY1 - fltPlayerHeight;

    //stop the player falling
    fltPlayerSpeedY = 0;
    
    //allow jumping again
    blnJumping = false;
  }
  else if (fltPlayerY + fltPlayerHeight > fltGroundY2 && fltPlayerX > 260 && fltPlayerX < 525){
    //snap the player's bottom to the ground's position
    fltPlayerY = fltGroundY2 - fltPlayerHeight;

    //stop the player falling
    fltPlayerSpeedY = 0;
    
    //allow jumping again
    blnJumping = false;
  }
  else if (fltPlayerY + fltPlayerHeight > fltGroundY3 && fltPlayerY + fltPlayerHeight < 600 && fltPlayerX > 526 && fltPlayerX < 610){
    //snap the player's bottom to the ground's position
    fltPlayerY = fltGroundY3 - fltPlayerHeight;

    //stop the player falling
    fltPlayerSpeedY = 0;
    
    //allow jumping again
    blnJumping = false;
  }
  
  else if (fltPlayerY + fltPlayerHeight > fltGroundY4 && fltPlayerY + fltPlayerHeight < 390 && fltPlayerX > 85 && fltPlayerX < 233) {
    fltPlayerY = fltGroundY4 - fltPlayerHeight;

    fltPlayerSpeedY = 0;
    blnJumping = false;
  }

  else if (fltPlayerY + fltPlayerHeight > fltGroundY5 && fltPlayerY + fltPlayerHeight < 260 && fltPlayerX > 243 && fltPlayerX < 354) {
    fltPlayerY = fltGroundY5 - fltPlayerHeight;

    fltPlayerSpeedY = 0;
    blnJumping = false;
  }

  else if (fltPlayerY + fltPlayerHeight > fltGroundY6 && fltPlayerY + fltPlayerHeight < 190 && fltPlayerX > 360 && fltPlayerX < 480) {
    fltPlayerY = fltGroundY6 - fltPlayerHeight;

    fltPlayerSpeedY = 0;
    blnJumping = false;
  }

  else if (fltPlayerY + fltPlayerHeight > fltGroundY7 && fltPlayerY + fltPlayerHeight < 150 && fltPlayerX > 545 && fltPlayerX < 700) {
    fltPlayerY = fltGroundY7 - fltPlayerHeight;

    fltPlayerSpeedY = 0;
    blnJumping = false;
  }

  else if (fltPlayerY + fltPlayerHeight > fltGroundY8 && fltPlayerY + fltPlayerHeight < 150 && fltPlayerX > 0 && fltPlayerX < 176) {
    fltPlayerY = fltGroundY8 - fltPlayerHeight;

    fltPlayerSpeedY = 0;
    blnJumping = false;
  }

  //player is not colliding with the ground
  else {
    //gravity accelerates the movement speed
    fltPlayerSpeedY ++;
  }

    //draw the player if they are not running or jumping
    if (blnLeftPressed == false && blnRightPressed == false && blnJumping == false){
      image(sonic_still[(frameCount/10)%intSonic_still], fltPlayerX, fltPlayerY - fltPlayerHeight);
    }
    // draw player if they are jumping
    else if (blnLeftPressed == false && blnRightPressed == false) {
      Sonicfall = loadImage("Sonicfall.png");
      Sonicfall.resize(30, 40);
      image(Sonicfall, fltPlayerX, fltPlayerY - fltPlayerHeight);
    }

    // left movement
    if (blnLeftPressed){
      // draw player if they are moving left
      image(sonic_left[(frameCount/3)%intSonic_left], fltPlayerX, fltPlayerY - fltPlayerHeight);
      if (fltPlayerX < 0) {
        fltPlayerX -= 0;
      }
      else if (fltPlayerX < 180 && fltPlayerY > fltGroundY1) {
        fltPlayerX -= 0;
      }
      else if (fltPlayerX < 545 && fltPlayerX > 270 && fltPlayerY > fltGroundY2) {
        fltPlayerX -= 0;
      }
      else {
        fltPlayerX -= fltPlayerSpeedX;
      }
    }

    // right movement
    if (blnRightPressed){
      // draw player if they are movign right
      image(sonic_right[(frameCount/3)%intSonic_right], fltPlayerX, fltPlayerY - fltPlayerHeight);
      if (fltPlayerX > 675) {
        fltPlayerX += 0;
      }
      else if (fltPlayerX + fltPlayerWidth > 250 && fltPlayerX < 535 && fltPlayerY > fltGroundY2) {
        fltPlayerX += 0;
      }
      else {
        fltPlayerX += fltPlayerSpeedX;
      }
    }
  }

}
