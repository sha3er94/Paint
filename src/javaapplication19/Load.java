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
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Load {
	public String  load(){
		JFrame  f = new JFrame () ;
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		    "txt and xml files ", "txt", "xml");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(f);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
		   return   chooser.getSelectedFile().getAbsolutePath();
		}
		return "name.txt";
	}
}

