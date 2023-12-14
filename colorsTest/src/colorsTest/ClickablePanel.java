package colorsTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;



public class ClickablePanel extends JPanel {

	 private long lastClickTime;
	 Integer red = 0;
	 Integer blue = 0;
	 Integer green = 0;
	 
	 public Integer  Increment  = 1;
	 
	 private final static int MAX_X = 1920;
	 private final static int MAX_Y = 1080;
	 
	 int curMouseX = MAX_X/2;
	 int curMouseY = MAX_Y/2;
	
    public ClickablePanel() {
    	
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                long currentTime = System.currentTimeMillis();
                long timeSinceLastClick = currentTime - lastClickTime;
                lastClickTime = currentTime;

                // This method is called when the mouse is clicked on the panel
                curMouseX = e.getX();
                curMouseY = e.getY();
                System.out.println("Mouse clicked at: " + curMouseX + ", " + curMouseY);
                System.out.println("Time since last click: " + timeSinceLastClick + " milliseconds");
                
                setVisible(true);
                
                if (timeSinceLastClick > 8000) {
                	System.out.println("slow click");
                	red -= 10;
                	setColor(red,green,blue);
                	Increment += 1;
                }
                else {
                	System.out.println("fast click");
                	red += 10;
                	setColor(red,green,blue);
                	Increment += 2;
                }
            }
        });
    }
    public Color setColor(Integer r, Integer g, Integer b) {
    	if (r > 255) {
    		r = 255;
    	}
    	if (r < 0) {
    		r = 0;
    	}
    	
    	  Color curColor = new Color(r,g,b);
    	  this.repaint();
    	  return curColor;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x = 0; x < MAX_X; x += Increment) {
            for (int y = 0; y < MAX_Y; y+= Increment ) {
      
                Color randomColor = Color.BLACK; //Black because it wouldn't work uninitialized.
                float distance = (int) calculateDistance(x,y, curMouseX, curMouseY);
                float maxDistance = (int)calculateDistance(0,0,MAX_X, MAX_Y);
                int testDistance = (int) (255-(255 * (distance/maxDistance)));
          //      System.out.println(maxDistance);
            //    System.out.println(255*distance/maxDistance);
                testDistance = 255;

                //Slightly inefficient? 
                Random random = new Random();
                int number = random.nextInt(3);
                
                 if(number == 0){randomColor = new Color(testDistance, 0, 0);}
                 else if(number ==1){randomColor = new Color(0, testDistance, 0);}
                 else if(number == 2){randomColor = new Color (0,0,testDistance);}
                 
                

                
                g.setColor(randomColor); //Red, Blue, or Green. Depends on if number is 0, 1 or 2.
                g.drawRect(x, y,  Increment ,  Increment); 
                g.fillRect(x, y,  Increment,  Increment);
            }
               
        
        }
    }
    
    public static float calculateDistance(int x1, int y1, int x2, int y2) {
        Float curVal = (float) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return curVal;
    }

    }
