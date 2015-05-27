// Authors: Benjamin Harris and Michael Paradis
// Java class that does file functions for MFeditor
// June 17, 2013

import java.io.*;

import javax.swing.*;

public class FileFuncs {
	
	private static File loadCurrentFile; ///////////////////////
	private static File saveCurrentFile; ///////////////////////
	public static String readInFile (File f) {
		String strToParse = "";
		JFileChooser fc = new JFileChooser();
		
		fc.setSelectedFile(f);
		fc.setFileFilter(new MetaFilter());
		//fc.addChoosableFileFilter(new TxtFilter());
		fc.setAcceptAllFileFilterUsed(true);
		if (loadCurrentFile != null) {
			fc.setCurrentDirectory(loadCurrentFile);
			fc.setSelectedFile(loadCurrentFile);
		} // end if
		int result = fc.showDialog(null, "Load Metafile");
		if (result == JFileChooser.APPROVE_OPTION) {
			try {
				f = fc.getSelectedFile();
				try {
					Config conf = new Config();
					conf.saveConfig("LoadPath", f.getAbsolutePath());
				} catch (IOException e1) {

				}
				loadCurrentFile = f;
				BufferedReader in = new BufferedReader( new FileReader(f));
				String str = in.readLine();
				while (str != null) {
					strToParse += str + "\n";
					str = in.readLine();
				} // end while
				in.close();
				MFeditor.passNote("File Selected: " + f.getName() + "<br>");
			} catch (FileNotFoundException e) {
				
			} catch (IOException e) {
				
			} // end try-catch-catch
		} else {
			MFeditor.passNote("File Input Cancelled<br>");
			return null;
		} // end if-else
		return strToParse;
	} // end readInFile()
	public static void saveFile (String s, File f) {
		JFileChooser fc = new JFileChooser(f);
		//fc.setSelectedFile(f);
		fc.setFileFilter(new MetaFilter());
		//fc.addChoosableFileFilter(new TxtFilter());
		fc.setAcceptAllFileFilterUsed(true);
		if (saveCurrentFile != null) {
			fc.setCurrentDirectory(saveCurrentFile);
			fc.setSelectedFile(saveCurrentFile);
		} // end if
		int result = fc.showDialog(null, "Save Metafile");
		if (result == JFileChooser.APPROVE_OPTION) {
			try {
				f = fc.getSelectedFile();
				try {
					Config conf = new Config();
					conf.saveConfig("SavePath", f.getAbsolutePath());
				} catch (IOException e1) {

				}
				saveCurrentFile = f;
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
				out.println(s);
				out.close();
				MFeditor.passNote("File Saved As: " + f.getName() + "<br>");
			} catch (IOException e) {
				 
			} // end try-catch
		} else {
			MFeditor.passNote("File Save Cancelled<br>");
		} // end if-else
	} // end saveFile()
	
	/*private static String geType (File f) {
        String t = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            t = s.substring(i+1).toLowerCase();
        }
        return t;
    }
   */ 
} // end class FileFuncs
	

class MetaFilter extends javax.swing.filechooser.FileFilter {
	public boolean accept(File f) {
		if (f.isDirectory()) return true;
		String fName = f.getName();
		fName = fName.toLowerCase();
		return fName.endsWith(".meta");
	} // end accept()
	public String getDescription() {
		return "*.meta";
	} // end getDescription()
} // end class MetaFilter