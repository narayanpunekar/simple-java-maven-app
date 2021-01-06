/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cardlayout.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;

/**
 *
 * @author narayan.punekar@yahoo.com
 */
public class Pie extends Frame {

    private static PieView pieView = null;

    public Pie() {
        
    }

    public static void main (String args[]) {
        int i;
        double dTemp;
        String strTemp;

        String strChartTitle = "Chart";
        String strChartSubtitle = "Pie Chart";

        PieItem[] arrPieItem = new PieItem[args.length];
        for (i=0; i<args.length; i++) {
            arrPieItem[i] = new PieItem(args[i]);
        }
        
        //Shell Sort
        int d = (i+1)/2;
        do {
            for (i=0; i<args.length-d; i++) {
                if(arrPieItem[i].dFrac < arrPieItem[i+d].dFrac) {
                    dTemp = arrPieItem[i].dFrac;                    //swap
                    arrPieItem[i].dFrac = arrPieItem[i+d].dFrac;
                    arrPieItem[i+d].dFrac = dTemp;
                    strTemp = arrPieItem[i].strLabel;
                    arrPieItem[i].strLabel = arrPieItem[i+d].strLabel;
                    arrPieItem[i+d].strLabel = strTemp;
                }
            }
            d -=1;
        } while(d>0);

        pieView = new PieView(100, arrPieItem);
        
        Frame frPie = new Pie();
        frPie.setLayout(new BorderLayout(0, 0));
        frPie.setBackground(Color.white);
        frPie.add("Center", pieView);
        frPie.add("North", new Label(strChartTitle));
        frPie.add("South", new Label(strChartSubtitle));
        frPie.setSize(512, 512);
        frPie.setVisible(true);
    }
}
