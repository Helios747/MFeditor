// Authors: Benjamin Harris and Michael Paradis
// Java class that is the driver for MFeditor
// June 17, 2013

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MFeditor extends JDialog {

	/**
	 * 
	 */
	public static DGGMFGUI everything;
	public static JFrame win;
	private final JPanel contentPanel = new JPanel();

	
	public static void main(String[] args) {
		
		try {
			MFeditor dialog = new MFeditor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setSize(425, 350);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MFeditor() {
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		BufferedImage dggridImage2 = null;
		String imageFile2 = "res/dgg.png";
		try {
			dggridImage2 = ImageIO.read(ResourceLoader.load(imageFile2));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblPichere = new JLabel(new ImageIcon(dggridImage2));
		springLayout.putConstraint(SpringLayout.WEST, lblPichere, 112, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblPichere);
		
		JLabel lblWelcomeToMfeditor = new JLabel("Welcome to MFEditor. Select a task");
		springLayout.putConstraint(SpringLayout.NORTH, lblWelcomeToMfeditor, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblWelcomeToMfeditor, 68, SpringLayout.WEST, getContentPane());
		lblWelcomeToMfeditor.setFont(new Font("Tahoma", Font.BOLD, 16));
		getContentPane().add(lblWelcomeToMfeditor);
		
		JButton btnCreateNewMetafile = new JButton("Create new Metafile");
		springLayout.putConstraint(SpringLayout.NORTH, lblPichere, 6, SpringLayout.SOUTH, btnCreateNewMetafile);
		springLayout.putConstraint(SpringLayout.NORTH, btnCreateNewMetafile, 6, SpringLayout.SOUTH, lblWelcomeToMfeditor);
		springLayout.putConstraint(SpringLayout.EAST, btnCreateNewMetafile, -10, SpringLayout.EAST, getContentPane());
		btnCreateNewMetafile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MFeditor.everything = new DGGMFGUI();
				MFeditor.win = new JFrame("MFeditor Version 1.2");
				MFeditor.win.setMinimumSize(new Dimension(400, 480));
				MFeditor.win.getContentPane().add(MFeditor.everything);
				MFeditor.win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				MFeditor.win.getContentPane();
				MFeditor.win.pack();
				MFeditor.win.setVisible(true);
				MFeditor.win.setLocationRelativeTo(null);
				MFeditor.win.setIconImage(MFeditor.everything.dggridImage2);
				setVisible(false);
			}
		});
		getContentPane().add(btnCreateNewMetafile);
		
		JButton btnLoadExistingMetafile = new JButton("Load existing Metafile");
		springLayout.putConstraint(SpringLayout.NORTH, btnLoadExistingMetafile, 6, SpringLayout.SOUTH, lblWelcomeToMfeditor);
		springLayout.putConstraint(SpringLayout.WEST, btnLoadExistingMetafile, 10, SpringLayout.WEST, getContentPane());
		btnLoadExistingMetafile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MFeditor.everything = new DGGMFGUI();
				MFeditor.win = new JFrame("MFeditor Version 1.1");
				MFeditor.win.setMinimumSize(new Dimension(400, 480));
				MFeditor.win.getContentPane().add(MFeditor.everything);
				MFeditor.win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				MFeditor.win.getContentPane();
				MFeditor.win.pack();
				MFeditor.win.setVisible(true);
				MFeditor.win.setLocationRelativeTo(null);
				MFeditor.win.setIconImage(MFeditor.everything.dggridImage2);
				setVisible(false);
				DGGMFGUI.load.doClick();
			}
		});
		getContentPane().add(btnLoadExistingMetafile);
		
		JButton btnAbout = new JButton("About");
		springLayout.putConstraint(SpringLayout.WEST, btnAbout, 172, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnAbout, -10, SpringLayout.SOUTH, getContentPane());
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MFeditor.everything = new DGGMFGUI();
				DGGMFGUI.about.doClick();
			}
		});
		getContentPane().add(btnAbout);

	}
	
	public static void passNote (String note) {
		everything.setNote(note);
	} // end passNote()
	
	public static void passActionEvent (ActionEvent e, String name) {
		everything.performAction(e, name);
	} // end passActionEvent
} // end class DGGMFGdriver