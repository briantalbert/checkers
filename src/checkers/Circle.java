package checkers;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class Circle extends JPanel {

    private final int circleDiameter;
    private final String color;
    
    public Circle(int diameter, String color) {
        circleDiameter = diameter;
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Get the width and height of the panel
        int width = getWidth();
        int height = getHeight();

        // Set the color and draw the circle
        g.setColor(this.color == "black" ? Color.black : Color.red);
        int circleX = (width - circleDiameter) / 2;
        int circleY = (height - circleDiameter) / 2;
        g.fillOval(circleX, circleY, circleDiameter, circleDiameter);
    }
}