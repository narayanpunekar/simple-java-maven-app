/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cardlayout.app;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author narayan.punekar@yahoo.com
 */
public class PieView extends Canvas {

    PieItem[] arrWedges;                    //The data for the pie
    double dTotal = 0.0;                    //Total of all wedges
    final static int iNumColors = 5;
    Color arrWedgeColor[] = new Color[5];
    int iPieViewSize;
    final static int iPieBorderWidth = 10;
    int iPieDiameter;
    int iPieRadius;
    int iPieCenterPos;
    
    public PieView(int iSize, PieItem[] piVec) {
        this.iPieViewSize = iSize;
        this.arrWedges = piVec;
        
        iPieDiameter = iPieViewSize-2*iPieBorderWidth;
        iPieRadius = iPieDiameter/2;
        iPieCenterPos = iPieBorderWidth + iPieRadius;
        this.setFont(new Font("Arial",Font.BOLD,12));
        this.setBackground(Color.white);
        for(int i=0;i<arrWedges.length;i++) {
            dTotal += arrWedges[i].dFrac;
        }
        arrWedgeColor[0]=Color.cyan;
        arrWedgeColor[1]=Color.green;
        arrWedgeColor[2]=Color.pink;
        arrWedgeColor[3]=Color.red;
        arrWedgeColor[4]=Color.yellow;
    }
    
    public void paint(Graphics g) {
        int iArcDeg;
        int iStartDeg = 0;
        double dAngleRad;
        int x;
        int y;
        
        g.setColor(Color.lightGray);        //shadow
        g.fillOval(iPieBorderWidth+3, iPieBorderWidth+3, iPieDiameter, iPieDiameter);
        g.setColor(Color.gray);        
        g.fillOval(iPieBorderWidth, iPieBorderWidth, iPieDiameter, iPieDiameter);

        //Draw the wedges
        int iWedgeColor = 0;
        for(int i=0; i<this.arrWedges.length; i++) {
            iArcDeg = (int)((this.arrWedges[i].dFrac/dTotal)*360);
            g.setColor(arrWedgeColor[iWedgeColor++]);
            g.fillArc(iPieBorderWidth, iPieBorderWidth, iPieDiameter, iPieDiameter, iStartDeg, iArcDeg);
            if(iWedgeColor>=iNumColors) {
                iWedgeColor = 0;          //rotate colors
            }
            iStartDeg += iArcDeg;
        }
        
        iStartDeg = 0;
        for(int i=0; i<this.arrWedges.length; i++) {
            iArcDeg = (int)((this.arrWedges[i].dFrac/dTotal) * 360);
            if (iArcDeg > 3) {
                g.setColor(Color.black);
                dAngleRad = (float)(iStartDeg+(iArcDeg/2)) * java.lang.Math.PI / 180.0;
                x = iPieCenterPos + (int)((iPieRadius/1.3) * java.lang.Math.cos(dAngleRad));
                y = iPieCenterPos - (int)((iPieRadius/1.3) * java.lang.Math.sin(dAngleRad)) + 5;    //5 is about half the text height
                g.drawString(this.arrWedges[i].strLabel, x, y);
            }
            iStartDeg += iArcDeg;
        }  
    }

    public Dimension fnPreferredSize() {
        return new Dimension(iPieViewSize, iPieViewSize);
    }
    
}
