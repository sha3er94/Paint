/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;


/**
 *
 * @author Mohamed El-Shaer
 */
public class Save {

	public String load(){
		
		JFrame parentFrame = new JFrame();
		 
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");   
		 
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		 
		 File fileToSave = fileChooser.getSelectedFile();
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		   
		    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
		}
		return fileToSave.getAbsolutePath();
	}
	

}
