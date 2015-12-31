/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

/**
 *
 * @author Mohamed El-Shaer
 */
import javaapplication19.Shapes.*;

import java.awt.Shape;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.ObjectInputStream;



import com.thoughtworks.xstream.XStream;


public class XML {
	
	public void write (ArrayList<Shapes> sh , String filename ) throws FileNotFoundException{

		XStream x= new XStream () ;
		FileOutputStream out = new FileOutputStream(filename);
		x.toXML(sh, out);
	}
	
	public ArrayList load (String filename) throws FileNotFoundException{
		ArrayList<Shape> o = new ArrayList<Shape>();
		FileInputStream fileinput = new FileInputStream(filename) ;
		XStream x = new XStream();
		return o = (ArrayList) x.fromXML(fileinput );
	}
	
}