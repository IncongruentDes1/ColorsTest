package colorsTest;
import java.util.Timer;
import java.util.TimerTask;

public class main {

	public static void main(String[] args) {
		Panel test = new Panel("test");
		
		 Timer timer = new Timer();

	        timer.scheduleAtFixedRate(new TimerTask() {
	            @Override
	            public void run() {
	                // Check the variable every second
	                System.out.println("Current value of myVariable: " + test.mainPanel.Increment);
	                if (test.mainPanel.Increment > 1) {
		                test.mainPanel.Increment -=1;
	                }
	                test.repaint();

	                // You can add your logic here to perform actions based on the variable's value
	            }
	        }, 0, 1000); // 1000 milliseconds = 1 second
	    }
	}


