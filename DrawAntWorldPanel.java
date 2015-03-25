/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antmapgui;

import ant.Ant;
import antmapgenerator.AntMapGenerator;
import antmapgenerator.Map;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

/**
 *
 * @author ec263
 */
public class DrawAntWorldPanel extends JPanel {
    
    //FontMetrics metrics;
    static Map map;
    //Ant[][] ants;
    static final int xStart = 10;
    static final int yStart = 10;
    static final double spacing = 13;
    static final int hexRadius = 8;
    static final int offset = 7;
    
    
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Font f = new Font("Dialog", Font.BOLD, 12);
        
        g.setFont(f);

        for (int i = 0; i < 150; i++) {
            int offset;
            
            if (i % 2 != 0) {
                offset = 7;
            }
            else offset =0;

            for (int j = 0; j < 150; j++) {
                Polygon hex = new Polygon();
                for (int pt = 0; pt < 6; pt++){
                    hex.addPoint((int)(xStart + offset + (spacing * j) + hexRadius * Math.sin(pt * 2 * Math.PI / 6)), (int)(yStart+ (spacing * i) +hexRadius * Math.cos(pt*2*Math.PI/6)));
                    }
                
                    if (map.getCell(i, j).isRocky()) {
                        g.setColor(Color.BLACK);
                    }
                    else if (map.getCell(i, j).getRedAnthill()){
                        g.setColor(Color.RED);
                    }
                    else if (map.getCell(i,j).getBlackAnthill()) {
                        g.setColor(Color.DARK_GRAY);
                    }
                    else if (map.getCell(i,j).hasFood() > 0) {

                        g.setColor(Color.YELLOW);
                    }
                    else
                        g.setColor(Color.gray);

                    g.fillPolygon(hex);
                    setLineThickness(g, 2);
                    g.setColor(Color.black);
                    g.drawPolygon(hex);
                    if (map.getCell(i,j).hasFood() > 0) {
                        String s = "";
                        s += map.getCell(i,j).hasFood();
                            g.setColor(Color.blue);
                            g.drawString(s, (int) (xStart + offset +(spacing * j) - 4), (int) (yStart+ (spacing * i) + hexRadius - 3) );
                    }
                /*
                if (ants[i][j].getColor() == "red") {
                    g.setColor(Color.RED);
                    g.drawString("R", (int) (xStart + offset +(spacing * j) - 5), (int) (yStart+ (spacing * i) + hexRadius - 3) );
                }
                else if (ants[i][j].getColor() =="black") {
                    g.setColor(Color.BLACK);
                    g.drawString("B", (int) (xStart + offset +(spacing * j) - 5), (int) (yStart+ (spacing * i) + hexRadius - 3) );
                }
                * 
                */ 
            }
        }        
    }
 
  public static void setLineThickness(Graphics page, int thickness) {
    if (thickness < 0) thickness = 0;
    ((Graphics2D)page).setStroke(new BasicStroke(thickness));
  }
    
    private void setMap(Map map) {
        this.map = map;
    }
    
    public Ant[][] getAnts(Ant[][] ants) {
        //this.ants = ants;
        return null;
    }
    
    public static void main(String[] args) {
        
        AntMapGenerator amg = new AntMapGenerator(150,150);
        
        amg.generateMap();
        map = amg.getMap();
        //ants = getAnts();

        JFrame frame = new JFrame();
        JScrollPane scroll = new JScrollPane();
        JPanel drawPanel = new DrawAntWorldPanel();
        
        drawPanel.setPreferredSize(new Dimension(1965, 1965));
        drawPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        
        scroll.setPreferredSize(new Dimension(1024,768));
        
        scroll.setViewportView(drawPanel);
        scroll.getVerticalScrollBar().setUnitIncrement(50);
        
        Container contentPane = frame.getContentPane();
        

        frame.setTitle("Ant World Display");
        frame.setSize(1920,1080);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        contentPane.add(scroll);

        frame.show();
    }
    
}
