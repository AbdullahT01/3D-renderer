import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.geom.Path2D;

public class driver {

	public static void main(String[] args) {
	
		JFrame frame = new JFrame(); 
		Container pane = frame.getContentPane(); 
		pane.setLayout(new BorderLayout());
		
		
	// slider to control horizontal rotation
		JSlider headingSlider = new JSlider(0, 360, 180);
	    pane.add(headingSlider, BorderLayout.SOUTH);
	    
	 // slider to control vertical rotation
        JSlider pitchSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0);
        pane.add(pitchSlider, BorderLayout.EAST);

    // panel to display render results
        
       JPanel renderPanel = new JPanel() {
    	   public void paintComponent(Graphics g) {
    		   Graphics2D g2 = (Graphics2D) g; 
    		   g2.setColor(Color.BLACK);
    		   g2.fillRect(0, 0, getWidth(), getHeight());
    		   
    		   g2.translate(getWidth() / 2, getHeight() / 2);
    		   g2.setColor(Color.WHITE);
    		   
    		   // this will contain a list of triangle of triangle objects 
    		   List<Triangle> tris = new ArrayList<>();
    		   tris.add(new Triangle(new Vertex(100, 100, 100), new Vertex(-100, -100, 100), new Vertex(-100, 100, -100), Color.WHITE));
    		   
    	       
    	       
    		   for (Triangle t : tris) {
    			    Path2D path = new Path2D.Double();
    			    path.moveTo(t.v1.x, t.v1.y); // starts the path here
    			    path.lineTo(t.v2.x, t.v2.y); // draws a line from first vertex to the next one. 
    			    path.lineTo(t.v3.x, t.v3.y);
    			    path.closePath();
    			    g2.draw(path);
    			}
    		   
    		   
    	   }
       };
       
       
     
       
       pane.add(renderPanel, BorderLayout.CENTER);
       
       frame.setSize(600, 600);
       frame.setVisible(true);
       
	}

}
