// Authors: Benjamin Harris and Michael Paradis
// Java class that is a modified JScrollPane object for MFeditor
// June 17, 2013

import javax.swing.*;
import java.awt.*;

public class ScrollTab extends JPanel{
	private static final long serialVersionUID = 1094331748494525625L;
	public static final String G = "General";
	public static final String GS = "Grid Specification";
	public static final String GG = "Grid Generation";
	public static final String O = "Output";
	private String tabName;
	private JScrollPane sp;
	private JPanel pa;
	//private static final int scrollSpeed = 6;
	public ScrollTab (String tabName) {
		this.tabName = tabName;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setPreferredSize(new Dimension(DGGMFGUI.OX2, DGGMFGUI.OY1 / 2));
		pa = new JPanel();
		sp = new JScrollPane(pa);
		sp.getVerticalScrollBar().setUnitIncrement(DGGMFGUI.scrollSpeed);
		sp.setWheelScrollingEnabled(true);
		add(sp);
		pa.setLayout(new BoxLayout(pa, BoxLayout.PAGE_AXIS));
	} // end constructor ScrollTab()
	public String getName () { return tabName; }
	public void add (JPanel p) { pa.add(p); } // end overriding add()
	public static ScrollTab[] makeTabs () {
		ScrollTab[] tabs = {

			new ScrollTab(G),

			new ScrollTab(GS),

			new ScrollTab(GG),

			new ScrollTab(O),


			
		};
		return tabs;
	} // end makeTabs()
} // end object class ScrollTab
