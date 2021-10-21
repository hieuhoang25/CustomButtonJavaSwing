/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package button;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author HieuHoang
 */
public class MyButton extends JButton {

    public MyButton() {

        setColor(color.white);
        setCursor(new Cursor(12));
        colorOver = new Color(179, 250, 160);
        colorClick = new Color(152, 104, 144);
        boderColor = new Color(30, 136, 56);
       setContentAreaFilled(false); // xóa UI BUTTON CỦA JAVASWING Metal
        // add event mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(color);
                over = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(colorOver);
                over = true;

            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(colorClick);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (over) {
                    setBackground(colorOver);
                } else {
                    setBackground(color);
                }
            }

        });
    }
    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private Color boderColor;
    private int radius = 0;
    private int boderSize = 1;
    private boolean boder = true;

    /**
     * @return the over
     */
    public boolean isOver() {
        return over;
    }

    /**
     * @param over the over to set
     */
    public void setOver(boolean over) {
        this.over = over;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    /**
     * @return the colorOver
     */
    public Color getColorOver() {
        return colorOver;
    }

    /**
     * @param colorOver the colorOver to set
     */
    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    /**
     * @return the colorClick
     */
    public Color getColorClick() {
        return colorClick;
    }

    /**
     * @param colorClick the colorClick to set
     */
    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    /**
     * @return the boderColor
     */
    public Color getBoderColor() {
        return boderColor;
    }

    /**
     * @param boderColor the boderColor to set
     */
    public void setBoderColor(Color boderColor) {
        this.boderColor = boderColor;
    }

    /**
     * @return the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //paint border;
        g2d.setColor(boderColor);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        if (isBoder()) {

            g2d.setColor(getBackground());
            g2d.fillRoundRect(boderSize, boderSize, getWidth() - boderSize * 2, getHeight() - boderSize * 2, radius, radius);
        }
        else{
             g2d.setColor(getBackground());
             g2d.fillRoundRect(boderSize, boderSize, getWidth()- boderSize * 2, getHeight()- boderSize * 2, radius, radius);

        }

        super.paintComponent(g);
    }

    /**
     * @return the boderSize
     */
    public int getBoderSize() {
        return boderSize;
    }

    /**
     * @param boderSize the boderSize to set
     */
    public void setBoderSize(int boderSize) {
        this.boderSize = boderSize;
    }

    /**
     * @return the boder
     */
    public boolean isBoder() {
        return boder;
    }

    /**
     * @param boder the boder to set
     */
    public void setBoder(boolean boder) {
        this.boder = boder;
    }

}
