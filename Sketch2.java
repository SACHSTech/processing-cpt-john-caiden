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

  float playerX = 230;
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
 
    // Barriers for bottom left platform
    if (playerX < 178 && playerY > 50) {
      playerX = 179;
    }

    // this is the failed attempt part
    if (playerX < 180 && playerY < 50) {
      playerY = 50;
      playerX = 20;
    }

  }
  public void keyPressed() {
    if(key == 'w') {
      if (!jumping) {
      
        //going up
        playerSpeedY = -17;
        
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

  public void barriers() {

  }

}