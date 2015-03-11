// Authors: Benjamin Harris and Michael Paradis
// Java class that is a modified JPanel object for MFeditor
// June 17, 2013

import javax.swing.*;

public class SubTab extends JPanel {
	private static final long serialVersionUID = 6544606710974603511L;
	private String subTabName;
	private String tabAssign;
	public SubTab (String name, String tabAssign, boolean hasLabel) {
		this.subTabName = name;
		this.tabAssign = tabAssign;	
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		if (hasLabel) {
			setBorder(BorderFactory.createTitledBorder(name));
			//setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), name, TitledBorder.LEADING, TitledBorder.BELOW_TOP));
		} // end if
	} // end constructor ScrollTab()
	public String getName () { return subTabName; }
	public String getTabAssign () { return tabAssign; }
	public static SubTab[] makeSubTabs () {
		SubTab[] tabs = {
				
// to make: new SubTab("sub tab name", "tab assignment", it needs titled border),
			
				
			new SubTab(Widget.G, ScrollTab.G, false),
			
						
			new SubTab(Widget.GS1, ScrollTab.GS, true),
			
			new SubTab(Widget.GS2, ScrollTab.GS, true),

			new SubTab(Widget.GS3, ScrollTab.GS, true),

			new SubTab(Widget.GS4, ScrollTab.GS, true),
			
			new SubTab(Widget.GS5, ScrollTab.GS, true),
		
			
			new SubTab(Widget.GG, ScrollTab.GG, false), 
			
			
			new SubTab(Widget.O1, ScrollTab.O, true),
			
			new SubTab(Widget.O2, ScrollTab.O, true),				

			new SubTab(Widget.O3, ScrollTab.O, true),
			
			new SubTab(Widget.O4, ScrollTab.O, true),
			
			new SubTab(Widget.TB1, ScrollTab.TB, true),
			
			new SubTab(Widget.TB2, ScrollTab.TB, true)
// to make: new SubTab("sub tab name", "tab assignment", it needs titled border),
			
		};
		return tabs;
	} // end makeTabs()
} // end class SubTab