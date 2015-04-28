// Authors: Benjamin Harris and Michael Paradis
// Java class that is the driver for MFeditor
// June 17, 2013

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MFeditor {

	public static DGGMFGUI everything;
	public static JFrame win;
	
	public static void passNote (String note) {
		everything.setNote(note);
	} // end passNote()
	
	public static void passActionEvent (ActionEvent e, String name) {
		everything.performAction(e, name);
	} // end passActionEvent
} // end class DGGMFGdriver