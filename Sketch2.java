import processing.core.PApplet;
import processing.core.PImage;

public class Sketch2 extends PApplet {
	
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

 // player coordinates and hitbox
 float playerX = 140;
 float playerY = 100;
 float playerWidth = 20;
 float playerHeight = 20;
 float playerSpeedX = 3;
 float playerSpeedY;
 
 // boolean to check when the player is jumping
 boolean jumping = false;
 
 // boolean which allows horizontal movement
 boolean leftPressed = false;
 boolean rightPressed = false;  

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
  }

  public void keyPressed() {
    // allow player to jump
    if(key == 'w') {
      if (!jumping) {
      
        //going up
        playerSpeedY = -18;
        
        //disallow jumping while already jumping
        jumping = true;
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

  //draw the ground
  stroke(255);
  line(0, groundY, width, groundY);

  // draw first platform
  line(0, groundY1, 180, groundY1);

  // draw second platform
  line(270, groundY2, 535, groundY2);

  // draw third platform
  line(535, groundY3, 620, groundY3);

  // draw fourth platform
  line(102, groundY4, 233, groundY4);

  //draw fifth platform
  line(268, groundY5, 354, groundY5);

  //draw sixth platform
  line(396, groundY6, 480, groundY6);

  //draw seventh platform
  line(568, groundY7, 700, groundY7);

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
  else if (playerY + playerHeight > groundY3 && playerX > 525 && playerX < 610){
    //snap the player's bottom to the ground's position
    playerY = groundY3 - playerHeight;

    //stop the player falling
    playerSpeedY = 0;
    
    //allow jumping again
    jumping = false;
  }
  
  else if (playerY + playerHeight > groundY4 && playerY + playerHeight < 400 && playerX > 85 && playerX < 233) {
    playerY = groundY4 - playerHeight;

    playerSpeedY = 0;
    jumping = false;
  }

  else if (playerY + playerHeight < groundY5 && playerX > 243 && playerX < 354) {
    playerY = groundY5 - playerHeight;

    playerSpeedY = 0;
    jumping = false;
  }

  else if (playerY + playerHeight > groundY6 && playerX > 396 && playerX < 480) {
    playerY = groundY6 - playerHeight;

    playerSpeedY = 0;
    jumping = false;
  }

  else if (playerY + playerHeight > groundY7 && playerX > 568 && playerX < 700) {
    playerY = groundY7 - playerHeight;

    playerSpeedY = 0;
    jumping = false;
  }

  //player is not colliding with the ground
  else {
    //gravity accelerates the movement speed
    playerSpeedY ++;
  }

    //draw the player rectangle
    fill(0, 0, 255);
    rect(playerX, playerY, playerWidth, playerHeight);

    if (leftPressed){
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
      if (playerX > 675) {
        playerX += 0;
      }
      else if (playerX > 250 && playerX < 535 && playerY > groundY2) {
        playerX += 0;
      }
      else {
        playerX += playerSpeedX;
      }
    }
  }

}
