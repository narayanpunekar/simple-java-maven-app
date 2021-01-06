/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cardlayout.app;

import java.util.StringTokenizer;
import java.lang.Math;

/**
 *
 * @author narayan.punekar@yahoo.com
 * A class to hold data for one wedge
 */
public class PieItem {

    public double dFrac;
    public String strLabel;
    
    public PieItem(String str1) {
        StringTokenizer st1 = new StringTokenizer(str1, ",");
        dFrac = Double.valueOf(st1.nextToken()).doubleValue();
        strLabel = st1.nextToken();
    }
    
}
