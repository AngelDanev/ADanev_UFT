/*
The plugin is developed in University of Food Technologies - Plovdiv, Bulgaria.
A scientific paper is available on: 
https://www.researchgate.net/publication/349213848_APPLICATION_OF_ARITHMETIC_AND_LOGIC_OPERATIONS_FOR_OBJECTS_EXTRACTION_IN_IMAGEJ/stats
For citation: 
Danev A., A. Bosakova-Ardenska, M. Kutryanska, I. Ivanov, V. Karparov, (2020). 
APPLICATION OF ARITHMETIC AND LOGIC OPERATIONS FOR OBJECTS EXTRACTION IN IMAGEJ,
Scientific  Research  of  the  Union  of  Scientists  in  Bulgaria  –  Plovdiv,  
series  B. Natural Sciences and Humanities, Vol XX, ISSN: 1311- 9192 (Print), 
ISSN:2534-9376 (On-line), VIIIth International  Conference Of Young  Scientists 2020. 
*/
import javax.swing.JPanel;
import java.io.*;
import ij.IJ;
import ij.ImagePlus;
import ij.ImageStack;
import ij.WindowManager;
import ij.plugin.ImageCalculator;
import ij.plugin.PlugIn;
import ij.process.ImageProcessor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.BorderLayout;
import java.awt.Button;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Choice;
import java.awt.Label;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Component;
import java.awt.Canvas;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JList;

public class ALOImagePro_ extends JPanel implements PlugIn{
	ImagePlus imp1 = WindowManager.getImage(0);
	ImagePlus imp2 = WindowManager.getImage(1);
	ImagePlus imp3;
	ImageIcon icon;
	ImageCalculator ic;
	
	String [] methods={"Try all", "Add", "Subtract", "Multiply", "Divide", "AND", "OR", "XOR", "Min", "Max", "Average", "Difference", "Transparent-zero" };
	
	
	ImageStack tstack=null;
	
	JFrame frame;
	JButton btnPerformAddOpperation;
	Choice choice;
	JPanel panel;
	Label label;
	JLabel labelResultImage_1;
	private JLabel labelResultImage_2;
	private JLabel labelResultImage_3;
	private JLabel labelResultImage_4;
	private JLabel labelResultImage_5;
	private JLabel labelResultImage_6;
	private JLabel labelResultImage_7;
	private JLabel labelResultImage_8;
	private JLabel labelResultImage_9;
	private JLabel labelResultImage_10;
	private JLabel labelResultImage_11;
	private JLabel labelResultImage_12;
	
	private JLabel lblSingleResult;
	private JLabel lblAdd;
	private JLabel lblSubtract;
	private JLabel lblMultiply;
	private JLabel lblDivide;
	private JLabel lblAND;
	private JLabel lblOR;
	private JLabel lblXOR;
	private JLabel lblMin;
	private JLabel lblMax;
	private JLabel lblAverage;
	private JLabel lblDifference;
	private JLabel lblTransperent;
	private JButton btnSave;
	
	public ALOImagePro_() {
		frame = new JFrame("ALOImagePro");
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(960, 625);
		frame.getContentPane().setLayout(null);
		
		btnPerformAddOpperation = new JButton("Make Calculation");
		btnPerformAddOpperation.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPerformAddOpperation.setBounds(178, 39, 151, 23);
		frame.getContentPane().add(btnPerformAddOpperation);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(11, 90, 923, 510);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
		
		labelResultImage_1 = new JLabel("Result Image 1");
		labelResultImage_1.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultImage_1.setBorder(border);
		labelResultImage_1.setLocation(10, 8);
		labelResultImage_1.setSize(214, 118);
		panel.add(labelResultImage_1);
		
		labelResultImage_2 = new JLabel("Result Image 2");
		labelResultImage_2.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultImage_2.setBounds(238, 7, 214, 120);
		labelResultImage_2.setBorder(border);
		panel.add(labelResultImage_2);
		
		labelResultImage_3 = new JLabel("Result Image 3");
		labelResultImage_3.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultImage_3.setBounds(471, 7, 214, 120);
		labelResultImage_3.setBorder(border);
		panel.add(labelResultImage_3);
		
		labelResultImage_4 = new JLabel("Result Image 4");
		labelResultImage_4.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultImage_4.setBounds(697, 6, 214, 120);
		labelResultImage_4.setBorder(border);
		panel.add(labelResultImage_4);
		
		labelResultImage_5 = new JLabel("Result Image 5");
		labelResultImage_5.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultImage_5.setBounds(10, 167, 214, 120);
		labelResultImage_5.setBorder(border);
		panel.add(labelResultImage_5);

		labelResultImage_6 = new JLabel("Result Image 6");
		labelResultImage_6.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultImage_6.setBounds(238, 167, 214, 120);
		labelResultImage_6.setBorder(border);
		panel.add(labelResultImage_6);
		
		labelResultImage_7 = new JLabel("Result Image 7");
		labelResultImage_7.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultImage_7.setBounds(471, 167, 214, 120);
		labelResultImage_7.setBorder(border);		
		panel.add(labelResultImage_7);
		
		labelResultImage_8 = new JLabel("Result Image 8");
		labelResultImage_8.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultImage_8.setBounds(697, 167, 214, 120);
		labelResultImage_8.setBorder(border);		
		panel.add(labelResultImage_8);
		
		labelResultImage_9 = new JLabel("Result Image 9");
		labelResultImage_9.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultImage_9.setBounds(10, 325, 214, 120);
		labelResultImage_9.setBorder(border);
		panel.add(labelResultImage_9);
		
		labelResultImage_10 = new JLabel("Result Image 10");
		labelResultImage_10.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultImage_10.setBounds(238, 325, 214, 120);
		labelResultImage_10.setBorder(border);
		panel.add(labelResultImage_10);
		
		labelResultImage_11 = new JLabel("Result Image 11");
		labelResultImage_11.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultImage_11.setBounds(471, 325, 214, 120);
		labelResultImage_11.setBorder(border);		
		panel.add(labelResultImage_11);		
		
		labelResultImage_12 = new JLabel("Result Image 12");
		labelResultImage_12.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultImage_12.setBounds(697, 325, 214, 120);
		labelResultImage_12.setBorder(border);		
		panel.add(labelResultImage_12);		
		
		lblSingleResult = new JLabel("Single Result");
		lblSingleResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblSingleResult.setBounds(0, 0, 923, 486);
		panel.add(lblSingleResult);
		
		lblAdd = new JLabel("ADD");
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setBounds(10, 129, 214, 22);
		panel.add(lblAdd);
		
		lblSubtract = new JLabel("Subtract");
		lblSubtract.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtract.setBounds(238, 132, 214, 22);
		panel.add(lblSubtract);
		
		lblMultiply = new JLabel("Multiply");
		lblMultiply.setHorizontalAlignment(SwingConstants.CENTER);
		lblMultiply.setBounds(474, 129, 211, 22);
		panel.add(lblMultiply);
		
		lblDivide = new JLabel("Divide");
		lblDivide.setHorizontalAlignment(SwingConstants.CENTER);
		lblDivide.setBounds(697, 129, 214, 25);
		panel.add(lblDivide);
		
		lblAND = new JLabel("AND");
		lblAND.setHorizontalAlignment(SwingConstants.CENTER);
		lblAND.setBounds(10, 290, 214, 22);
		panel.add(lblAND);
		
		lblOR = new JLabel("OR");
		lblOR.setHorizontalAlignment(SwingConstants.CENTER);
		lblOR.setBounds(238, 290, 214, 22);
		panel.add(lblOR);
		
		lblXOR = new JLabel("XOR");
		lblXOR.setHorizontalAlignment(SwingConstants.CENTER);
		lblXOR.setBounds(481, 290, 197, 22);
		panel.add(lblXOR);
		
		lblMin = new JLabel("Min");
		lblMin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMin.setBounds(697, 290, 214, 22);
		panel.add(lblMin);
		
		lblMax = new JLabel("Max");
		lblMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblMax.setBounds(10, 452, 214, 22);
		panel.add(lblMax);
		
		lblAverage = new JLabel("Average");
		lblAverage.setHorizontalAlignment(SwingConstants.CENTER);
		lblAverage.setBounds(238, 452, 214, 22);
		panel.add(lblAverage);
		
		lblDifference = new JLabel("Difference");
		lblDifference.setHorizontalAlignment(SwingConstants.CENTER);
		lblDifference.setBounds(464, 452, 214, 22);
		panel.add(lblDifference);
		
		lblTransperent = new JLabel("Transparent-zero");
		lblTransperent.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransperent.setBounds(697, 452, 214, 22);
		panel.add(lblTransperent);
		
		label = new Label("Choose operation");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(11, 12, 151, 22);
		frame.getContentPane().add(label);
		
		//check if input images are loaded
		if(WindowManager.getImage(1)!=null && WindowManager.getImage(2)!=null){
			frame.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "There are no input images!");
			frame.setVisible(false);
		}
				
		choice = new Choice();
		choice.setBounds(11, 39, 151, 30);
		for(int i=0; i<methods.length; i++){
			choice.add(methods[i]);
		}
		frame.getContentPane().add(choice);
		
		//save button
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser fs=new JFileChooser(new File("c:\\"));
				String ext = imp3.getTitle().substring(imp3.getTitle().indexOf(".")+1,imp3.getTitle().length());
				fs.setDialogTitle("Save a File");
				fs.setFileFilter(new FileTypeFilter("."+ext,ext));
				
				int result = fs.showSaveDialog(null);
				if(result==JFileChooser.APPROVE_OPTION) {
					File fileToSave = fs.getSelectedFile();
					System.out.println("Save as file: " + fileToSave.getAbsolutePath());
					System.out.println(imp3.getFileInfo());
					System.out.println(imp3.getTitle());
					
					System.out.println(ext);
					IJ.saveAs(imp3,ext,fileToSave.getAbsolutePath()+"."+ext);
				}
			}
		});
		btnSave.setBounds(818, 40, 116, 21);
		frame.getContentPane().add(btnSave);
		
	}
	
	@Override
	public void run(String arg) {
		//set default visibility of some elements 
		lblSingleResult.setVisible(false);
		labelResultImage_1.setVisible(true);
		labelResultImage_2.setVisible(true);
		labelResultImage_3.setVisible(true);
		labelResultImage_4.setVisible(true);
		labelResultImage_5.setVisible(true);
		labelResultImage_6.setVisible(true);
		labelResultImage_7.setVisible(true);
		labelResultImage_8.setVisible(true);
		labelResultImage_9.setVisible(true);
		labelResultImage_10.setVisible(true);
		labelResultImage_11.setVisible(true);
		labelResultImage_12.setVisible(true);						
		btnSave.setEnabled(false);
		
		 // Define ActionListener
		ActionListener actionListener = new ActionListener() {
			 public void actionPerformed(ActionEvent actionEvent) {
				 chooseCalculatorOperation();
			 }
		};
			  
		// Attach listeners
		btnPerformAddOpperation.addActionListener(actionListener);		
	}
	
	private void chooseCalculatorOperation(){
		if(choice.getSelectedItem() =="Try all"){
			 JOptionPane.showMessageDialog(null, "Try all is chosen!");
			 lblSingleResult.setVisible(false);
			 labelResultImage_1.setVisible(true);
			 labelResultImage_2.setVisible(true);
			 labelResultImage_3.setVisible(true);
			 labelResultImage_4.setVisible(true);
			 labelResultImage_5.setVisible(true);
		   	 labelResultImage_6.setVisible(true);
			 labelResultImage_7.setVisible(true);
			 labelResultImage_8.setVisible(true);
			 labelResultImage_9.setVisible(true);
			 labelResultImage_10.setVisible(true);
			 labelResultImage_11.setVisible(true);
			 labelResultImage_12.setVisible(true);
			 btnSave.setEnabled(false);
			 
			 for (int k=1; k<methods.length;k++){
				 ic = new ImageCalculator();
				 imp1 = WindowManager.getImage(1);
				 imp2 = WindowManager.getImage(2);
				 imp3 = ic.run(methods[k]+" create", imp1, imp2);
				 
				 icon = new ImageIcon(getScaledImage(imp3.getImage(), 214, 120));
				 
				 if(methods[k]=="Add"){
					 labelResultImage_1.setIcon(icon);
				 }else if(methods[k]=="Subtract"){
					 labelResultImage_2.setIcon(icon);
				 }else if(methods[k]=="Multiply"){
					 labelResultImage_3.setIcon(icon);
				 }else if(methods[k]=="Divide"){
					 labelResultImage_4.setIcon(icon);
				 }else if(methods[k]=="AND"){
					 labelResultImage_5.setIcon(icon);
				 }else if(methods[k]=="OR"){
					 labelResultImage_6.setIcon(icon);
				 }else if(methods[k]=="XOR"){
					 labelResultImage_7.setIcon(icon);
				 }else if(methods[k]=="Min"){
					 labelResultImage_8.setIcon(icon);
				 }else if(methods[k]=="Max"){
					 labelResultImage_9.setIcon(icon);
				 }else if(methods[k]=="Average"){
					 labelResultImage_10.setIcon(icon);
				 }else if(methods[k]=="Difference"){
					 labelResultImage_11.setIcon(icon);
				 }else if(methods[k]=="Transparent-zero"){
					 labelResultImage_12.setIcon(icon);
				 }     
			 }
			
		 }else if(choice.getSelectedItem()=="Add"){
			 JOptionPane.showMessageDialog(null, "Add opperation is chosen!");
			 lblSingleResult.setVisible(true);
			 labelResultImage_1.setVisible(false);
			 labelResultImage_2.setVisible(false);
			 labelResultImage_3.setVisible(false);
			 labelResultImage_4.setVisible(false);
			 labelResultImage_5.setVisible(false);
		   	 labelResultImage_6.setVisible(false);
			 labelResultImage_7.setVisible(false);
			 labelResultImage_8.setVisible(false);
			 labelResultImage_9.setVisible(false);
			 labelResultImage_10.setVisible(false);
			 labelResultImage_11.setVisible(false);
			 labelResultImage_12.setVisible(false);
			 btnSave.setEnabled(true);
			 
			 ic = new ImageCalculator();
			 imp1 = WindowManager.getImage(1);
			 imp2 = WindowManager.getImage(2);
			 imp3 = ic.run("Add create", imp1, imp2);
			 
			 icon = new ImageIcon(getScaledImage(imp3.getImage(), 923, 486));
			 
			 lblSingleResult.setIcon(icon);
			 
		 }else if(choice.getSelectedItem()=="Subtract"){
			 JOptionPane.showMessageDialog(null, "Subtract opperation is chosen!");
			 lblSingleResult.setVisible(true);
			 labelResultImage_1.setVisible(false);
			 labelResultImage_2.setVisible(false);
			 labelResultImage_3.setVisible(false);
			 labelResultImage_4.setVisible(false);
			 labelResultImage_5.setVisible(false);
		   	 labelResultImage_6.setVisible(false);
			 labelResultImage_7.setVisible(false);
			 labelResultImage_8.setVisible(false);
			 labelResultImage_9.setVisible(false);
			 labelResultImage_10.setVisible(false);
			 labelResultImage_11.setVisible(false);
			 labelResultImage_12.setVisible(false);
			 btnSave.setEnabled(true);
			 
			 ic = new ImageCalculator();
			 imp1 = WindowManager.getImage(1);
			 imp2 = WindowManager.getImage(2);
			 imp3 = ic.run("Subtract create", imp1, imp2);
			 
			 icon = new ImageIcon(getScaledImage(imp3.getImage(), 923, 486));
			 lblSingleResult.setIcon(icon);
			 
		 }else if(choice.getSelectedItem()=="Multiply"){
			 JOptionPane.showMessageDialog(null, "Multiply opperation is chosen!");
			 lblSingleResult.setVisible(true);
			 labelResultImage_1.setVisible(false);
			 labelResultImage_2.setVisible(false);
			 labelResultImage_3.setVisible(false);
			 labelResultImage_4.setVisible(false);
			 labelResultImage_5.setVisible(false);
		   	 labelResultImage_6.setVisible(false);
			 labelResultImage_7.setVisible(false);
			 labelResultImage_8.setVisible(false);
			 labelResultImage_9.setVisible(false);
			 labelResultImage_10.setVisible(false);
			 labelResultImage_11.setVisible(false);
			 labelResultImage_12.setVisible(false);
			 btnSave.setEnabled(true);
			 
			 ic = new ImageCalculator();
			 imp1 = WindowManager.getImage(1);
			 imp2 = WindowManager.getImage(2);
			 imp3 = ic.run("Multiply create", imp1, imp2);
			 
			 icon = new ImageIcon(getScaledImage(imp3.getImage(), 923, 486));
			 lblSingleResult.setIcon(icon);
			 
		 }else if(choice.getSelectedItem()=="Divide"){
			 JOptionPane.showMessageDialog(null, "Divide opperation is chosen!");
			 lblSingleResult.setVisible(true);
			 labelResultImage_1.setVisible(false);
			 labelResultImage_2.setVisible(false);
			 labelResultImage_3.setVisible(false);
			 labelResultImage_4.setVisible(false);
			 labelResultImage_5.setVisible(false);
		   	 labelResultImage_6.setVisible(false);
			 labelResultImage_7.setVisible(false);
			 labelResultImage_8.setVisible(false);
			 labelResultImage_9.setVisible(false);
			 labelResultImage_10.setVisible(false);
			 labelResultImage_11.setVisible(false);
			 labelResultImage_12.setVisible(false);
			 btnSave.setEnabled(true);
			 
			 ic = new ImageCalculator();
			 imp1 = WindowManager.getImage(1);
			 imp2 = WindowManager.getImage(2);
			 imp3 = ic.run("Divide create", imp1, imp2);
			 
			 icon = new ImageIcon(getScaledImage(imp3.getImage(), 923, 486));
			 lblSingleResult.setIcon(icon);
			 
		 }else if(choice.getSelectedItem()=="AND"){
			 JOptionPane.showMessageDialog(null, "AND opperation is chosen!");
			 lblSingleResult.setVisible(true);
			 labelResultImage_1.setVisible(false);
			 labelResultImage_2.setVisible(false);
			 labelResultImage_3.setVisible(false);
			 labelResultImage_4.setVisible(false);
			 labelResultImage_5.setVisible(false);
		   	 labelResultImage_6.setVisible(false);
			 labelResultImage_7.setVisible(false);
			 labelResultImage_8.setVisible(false);
			 labelResultImage_9.setVisible(false);
			 labelResultImage_10.setVisible(false);
			 labelResultImage_11.setVisible(false);
			 labelResultImage_12.setVisible(false);
			 btnSave.setEnabled(true);
			 
			 ic = new ImageCalculator();
			 imp1 = WindowManager.getImage(1);
			 imp2 = WindowManager.getImage(2);
			 imp3 = ic.run("AND create", imp1, imp2);
			 
			 icon = new ImageIcon(getScaledImage(imp3.getImage(), 923, 486));
			 lblSingleResult.setIcon(icon);
			 
		 }else if(choice.getSelectedItem()=="OR"){
			 JOptionPane.showMessageDialog(null, "OR opperation is chosen!");
			 lblSingleResult.setVisible(true);
			 labelResultImage_1.setVisible(false);
			 labelResultImage_2.setVisible(false);
			 labelResultImage_3.setVisible(false);
			 labelResultImage_4.setVisible(false);
			 labelResultImage_5.setVisible(false);
		   	 labelResultImage_6.setVisible(false);
			 labelResultImage_7.setVisible(false);
			 labelResultImage_8.setVisible(false);
			 labelResultImage_9.setVisible(false);
			 labelResultImage_10.setVisible(false);
			 labelResultImage_11.setVisible(false);
			 labelResultImage_12.setVisible(false);
			 btnSave.setEnabled(true);
			 
			 ic = new ImageCalculator();
			 imp1 = WindowManager.getImage(1);
			 imp2 = WindowManager.getImage(2);
			 imp3 = ic.run("OR create", imp1, imp2);
			 
			 icon = new ImageIcon(getScaledImage(imp3.getImage(), 923, 486));
			 lblSingleResult.setIcon(icon);
			 
		 }else if(choice.getSelectedItem()=="XOR"){
			 JOptionPane.showMessageDialog(null, "XOR opperation is chosen!");
			 lblSingleResult.setVisible(true);
			 labelResultImage_1.setVisible(false);
			 labelResultImage_2.setVisible(false);
			 labelResultImage_3.setVisible(false);
			 labelResultImage_4.setVisible(false);
			 labelResultImage_5.setVisible(false);
		   	 labelResultImage_6.setVisible(false);
			 labelResultImage_7.setVisible(false);
			 labelResultImage_8.setVisible(false);
			 labelResultImage_9.setVisible(false);
			 labelResultImage_10.setVisible(false);
			 labelResultImage_11.setVisible(false);
			 labelResultImage_12.setVisible(false);
			 btnSave.setEnabled(true);
			 
			 ic = new ImageCalculator();
			 imp1 = WindowManager.getImage(1);
			 imp2 = WindowManager.getImage(2);
			 imp3 = ic.run("XOR create", imp1, imp2);
			 
			 icon = new ImageIcon(getScaledImage(imp3.getImage(), 923, 486));
			 lblSingleResult.setIcon(icon);
			 
		 }else if(choice.getSelectedItem()=="Min"){
			 JOptionPane.showMessageDialog(null, "Min opperation is chosen!");
			 lblSingleResult.setVisible(true);
			 labelResultImage_1.setVisible(false);
			 labelResultImage_2.setVisible(false);
			 labelResultImage_3.setVisible(false);
			 labelResultImage_4.setVisible(false);
			 labelResultImage_5.setVisible(false);
		   	 labelResultImage_6.setVisible(false);
			 labelResultImage_7.setVisible(false);
			 labelResultImage_8.setVisible(false);
			 labelResultImage_9.setVisible(false);
			 labelResultImage_10.setVisible(false);
			 labelResultImage_11.setVisible(false);
			 labelResultImage_12.setVisible(false);
			 btnSave.setEnabled(true);
			 
			 ic = new ImageCalculator();
			 imp1 = WindowManager.getImage(1);
			 imp2 = WindowManager.getImage(2);
			 imp3 = ic.run("Min create", imp1, imp2);
			 
			 icon = new ImageIcon(getScaledImage(imp3.getImage(), 923, 486));
			 lblSingleResult.setIcon(icon);
			 
		 }else if(choice.getSelectedItem()=="Max"){
			 JOptionPane.showMessageDialog(null, "Max opperation is chosen!");
			 lblSingleResult.setVisible(true);
			 labelResultImage_1.setVisible(false);
			 labelResultImage_2.setVisible(false);
			 labelResultImage_3.setVisible(false);
			 labelResultImage_4.setVisible(false);
			 labelResultImage_5.setVisible(false);
		   	 labelResultImage_6.setVisible(false);
			 labelResultImage_7.setVisible(false);
			 labelResultImage_8.setVisible(false);
			 labelResultImage_9.setVisible(false);
			 labelResultImage_10.setVisible(false);
			 labelResultImage_11.setVisible(false);
			 labelResultImage_12.setVisible(false);
			 btnSave.setEnabled(true);
			 
			 ic = new ImageCalculator();
			 imp1 = WindowManager.getImage(1);
			 imp2 = WindowManager.getImage(2);
			 imp3 = ic.run("Max create", imp1, imp2);
			 
			 icon = new ImageIcon(getScaledImage(imp3.getImage(), 923, 486));
			 lblSingleResult.setIcon(icon);
			 
		 }else if(choice.getSelectedItem()=="Average"){
			 JOptionPane.showMessageDialog(null, "XOR opperation is chosen!");
			 lblSingleResult.setVisible(true);
			 labelResultImage_1.setVisible(false);
			 labelResultImage_2.setVisible(false);
			 labelResultImage_3.setVisible(false);
			 labelResultImage_4.setVisible(false);
			 labelResultImage_5.setVisible(false);
		   	 labelResultImage_6.setVisible(false);
			 labelResultImage_7.setVisible(false);
			 labelResultImage_8.setVisible(false);
			 labelResultImage_9.setVisible(false);
			 labelResultImage_10.setVisible(false);
			 labelResultImage_11.setVisible(false);
			 labelResultImage_12.setVisible(false);
			 btnSave.setEnabled(true);
			 
			 ic = new ImageCalculator();
			 imp1 = WindowManager.getImage(1);
			 imp2 = WindowManager.getImage(2);
			 imp3 = ic.run("XOR create", imp1, imp2);
			 
			 icon = new ImageIcon(getScaledImage(imp3.getImage(), 923, 486));
			 lblSingleResult.setIcon(icon);
			 
		 }else if(choice.getSelectedItem()=="Difference"){
			 JOptionPane.showMessageDialog(null, "Difference opperation is chosen!");
			 lblSingleResult.setVisible(true);
			 labelResultImage_1.setVisible(false);
			 labelResultImage_2.setVisible(false);
			 labelResultImage_3.setVisible(false);
			 labelResultImage_4.setVisible(false);
			 labelResultImage_5.setVisible(false);
		   	 labelResultImage_6.setVisible(false);
			 labelResultImage_7.setVisible(false);
			 labelResultImage_8.setVisible(false);
			 labelResultImage_9.setVisible(false);
			 labelResultImage_10.setVisible(false);
			 labelResultImage_11.setVisible(false);
			 labelResultImage_12.setVisible(false);
			 btnSave.setEnabled(true);
			 
			 ic = new ImageCalculator();
			 imp1 = WindowManager.getImage(1);
			 imp2 = WindowManager.getImage(2);
			 imp3 = ic.run("Difference create", imp1, imp2);
			 
			 icon = new ImageIcon(getScaledImage(imp3.getImage(), 923, 486));
			 lblSingleResult.setIcon(icon);
			 
		 }else if(choice.getSelectedItem()=="Transparent-zero"){
			 JOptionPane.showMessageDialog(null, "Transparent-zero opperation is chosen!");
			 lblSingleResult.setVisible(true);
			 labelResultImage_1.setVisible(false);
			 labelResultImage_2.setVisible(false);
			 labelResultImage_3.setVisible(false);
			 labelResultImage_4.setVisible(false);
			 labelResultImage_5.setVisible(false);
		   	 labelResultImage_6.setVisible(false);
			 labelResultImage_7.setVisible(false);
			 labelResultImage_8.setVisible(false);
			 labelResultImage_9.setVisible(false);
			 labelResultImage_10.setVisible(false);
			 labelResultImage_11.setVisible(false);
			 labelResultImage_12.setVisible(false);
			 btnSave.setEnabled(true);
			 
			 ic = new ImageCalculator();
			 imp1 = WindowManager.getImage(1);
			 imp2 = WindowManager.getImage(2);
			 imp3 = ic.run("Transparent-zero create", imp1, imp2);
			 
			 icon = new ImageIcon(getScaledImage(imp3.getImage(), 923, 486));
			 lblSingleResult.setIcon(icon);
			 
		 }
	}
	
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
}
