// Authors: Benjamin Harris and Michael Paradis
// Java class that is the driver for MFeditor
// June 17, 2013

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MFeditor {

	public static DGGMFGUI everything;
	public static JFrame win;
	public static void main(String[] args) {
		everything = new DGGMFGUI();
		
		win = new JFrame("MFeditor Version Beta 1.0");
		win.setMinimumSize(new Dimension(400, 480));
		win.add(everything);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.getContentPane();
		win.pack();
		win.setVisible(true);
		win.setLocationRelativeTo(null);
		win.setIconImage(everything.dggridImage2);
	} // end main()
	
	public static void passNote (String note) {
		everything.setNote(note);
	} // end passNote()
	
	public static void passActionEvent (ActionEvent e, String name) {
		everything.performAction(e, name);
	} // end passActionEvent
} // end class DGGMFGdriver