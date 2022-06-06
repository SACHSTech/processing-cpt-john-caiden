import processing.core.PApplet;
import processing.core.PImage;

public class Sketch2 extends PApplet {
	
 // background image variable
 PImage img;

 // platform hitboxes
 float groundY = 700;
 float groundY1 = 580;
 
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
  //player is not colliding with the ground
  else {
    //gravity accelerates the movement speed
    playerSpeedY ++;
  }

  /*if (playerY + playerHeight > groundY1 && playerX < 175) {

    //snap the player's bottom to the ground's position
    playerY = groundY1 - playerHeight;

    //stop the player falling
    playerSpeedY = 0;

    //player is not colliding with the ground
    playerY = groundY - playerHeight;

    //allow jumping again
    jumping = false;
  }
  else {
    playerSpeedY ++;
  }*/
    if (playerY < groundY1 && playerX < 180) {
      //snap the player's bottom to the ground's position
      playerY = groundY1 - playerHeight;

      if (playerY + playerHeight > groundY1)
      //stop the player falling
      playerSpeedY = 0;
      
      if(key == 'w') {
        if (!jumping) {
        
          //going up
          playerSpeedY = -15;
          
          //disallow jumping while already jumping
          jumping = true;
        }
      }
    }
      
      /*else if (playerX < 178 && playerY + playerHeight > groundY1) {
        //snap the player's bottom to the ground's position
        playerY = groundY1 - playerHeight;

        //stop the player falling
        playerSpeedY = 0;

        //player is not colliding with the ground
        playerY = groundY - playerHeight;

        //allow jumping again
        jumping = false;
      }
      else {
        playerX -= 0;
      }
*/

    //draw the player rectangle
    rect(playerX, playerY, playerWidth, playerHeight);

    if (leftPressed){
      if (playerX < 0) {
        playerX -= 0;
      }
      else if (playerX < 180 && playerY > groundY1) {
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
      else {
        playerX += playerSpeedX;
      }
    }
  }
  
  public void keyPressed() {
    // allow player to jump
    if(key == 'w') {
      if (!jumping) {
      
        //going up
        playerSpeedY = -15;
        
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

}
