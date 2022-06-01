import processing.core.PApplet;
import processing.core.PImage;

public class Sketch2 extends PApplet {
	
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
  }

  float groundY = 400;

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
    
    // draw background
    background(0, 0, 0);

   //draw the ground
  stroke(255);
  line(0, groundY, width, groundY);

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
        playerSpeedY = -10;
        
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