// Authors: Benjamin Harris and Michael Paradis
// Java parent class for the parameter types in MFeditor
// June 17, 2013

import javax.swing.*;
import java.awt.*;

public class Widget extends JPanel{
	private static final long serialVersionUID = -5023765160182873029L;
	protected String name = "";
	protected String value, paneAssign;
	
	private JPanel topPane, namePane, namePaneIn, namePaneOut, cornerPaneIn, cornerPaneOut;
	protected JPanel cornerPane, bottomPane;
	public JLabel nameField;
		
	public static final String G = "Gen";
	public static final String GS1 = "Topology";
	public static final String GS2 = "Projection";
	public static final String GS3 = "Aperture";
	public static final String GS4 = "Orientation";
	public static final String GS5 = "Resolution";
	public static final String GG = "Grid Generation";
	public static final String O1 = "General";
	public static final String O2 = "Cell Output";
	public static final String O3 = "Point Output";
	public static final String O4 = "Random Points Output";
	
	// NEW TAB v6.2**************************************************************************************
	public static final String TB1 = "Input";
	public static final String TB2 = "Output";
	// NEW TAB v6.2**************************************************************************************
	
	private static final int INTMAX = 2000000000;
	private static final double DOUBLEMAX = 1000000000;
	private static final int NFW = 250;
	private static final int NFH = 60;
	public static final Dimension tfDim = new Dimension(100, 30);
	
	public Widget (String name, String description, String paneAssign) {
		
		this.name = name;
		this.paneAssign = paneAssign;

		//setBorder(BorderFactory.createLoweredBevelBorder());
		//setBorder(BorderFactory.createRaisedBevelBorder());
		setBorder(BorderFactory.createEtchedBorder());
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		nameField = new JLabel("<html><h4 style=\"text-align:right\">" + name + "</h4></html>", SwingConstants.TRAILING);
	
		namePaneIn = new JPanel();
		namePaneIn.add(nameField);
		
		Dimension nfDim = new Dimension(NFW, NFH);
		namePaneIn.setLayout(new BoxLayout(namePaneIn, BoxLayout.LINE_AXIS));
		namePaneIn.setMinimumSize(nfDim);
		namePaneIn.setMaximumSize(nfDim);
		namePaneIn.setPreferredSize(nfDim);
		
		namePaneOut = new JPanel();
		namePaneOut.setLayout(new BoxLayout(namePaneOut, BoxLayout.LINE_AXIS));
		namePaneOut.add(Box.createRigidArea(new Dimension(10, 1)));
		namePaneOut.add(namePaneIn);
		namePaneOut.add(Box.createRigidArea(new Dimension(10, 1)));
		namePaneOut.add(Box.createHorizontalGlue());

		namePane = new JPanel();
		namePane.setToolTipText(description);
		namePane.setLayout(new BoxLayout(namePane, BoxLayout.PAGE_AXIS));
		//namePane.add(Box.createRigidArea(new Dimension(1, 10)));
		namePane.add(namePaneOut);
		//namePane.add(Box.createRigidArea(new Dimension(1, 10)));
		namePane.add(Box.createVerticalGlue());
		//namePane.setBorder(BorderFactory.createLoweredBevelBorder());
		cornerPane = new JPanel();
		
		cornerPaneIn = new JPanel();
		cornerPaneIn.setLayout(new BoxLayout(cornerPaneIn, BoxLayout.PAGE_AXIS));
		cornerPaneIn.add(Box.createRigidArea(new Dimension(1, 30)));
		cornerPaneIn.add(cornerPane);
		//cornerPaneIn.add(Box.createRigidArea(new Dimension(1, 30)));
		cornerPaneIn.add(Box.createVerticalGlue());
		
		cornerPaneOut = new JPanel();
		cornerPaneOut.setLayout(new BoxLayout(cornerPaneOut, BoxLayout.LINE_AXIS));
		
		cornerPaneOut.add(Box.createRigidArea(new Dimension(30, 1)));
		cornerPaneOut.add(cornerPaneIn);
		cornerPaneOut.add(Box.createRigidArea(new Dimension(30, 1)));
		cornerPaneOut.add(Box.createHorizontalGlue());
		//cornerPaneOut.setBorder(BorderFactory.createLoweredBevelBorder());
		topPane = new JPanel();
		topPane.setLayout(new BoxLayout(topPane, BoxLayout.LINE_AXIS));
		topPane.add(namePane);
		topPane.add(cornerPaneOut);		
		
		bottomPane = new JPanel();
	
		add(topPane);
		add(bottomPane);
		//add(Box.createRigidArea(new Dimension(1, 20)));
		setVisible(true);
	} // end constructor Widget()
	public String getPaneAssign () { return paneAssign; }
	public String getName () { return name; }
	public String getValue () { return value; }
	public String toString () { return name + " " + value; }
	public String getDefau () { return ""; } // empty method
	public boolean setDefau (String fromPreset) { return true; } // empty method
	public void setParaToDefault () {} // empty method
	public boolean checkIfDefault () {	return true; } // empty method
	public boolean setValueRemotely (String s) { return true; } // empty method
	public void resetDefault () { } // empty method

	public void setSlider (int l, int h) { }
	public void disableWidget (boolean b) { }

	public DisableDependency getDisDep () { return null; }
	public ControlDependency getCtrDep () { return null; }
	public void insertDisableDependency (DisableDependency dD) { }
	public void insertControlList (String s) { }	
	
	
	public static Widget[] makeWidgets () {
		
		
		Widget[] widg = {
				
// to make:		new PamameterBoolean("pamameter name", "tooltip description", "paneAssignment", defaultBoolean),

// to make:		new PamameterChoice("parameter name", "tooltip description", "paneAssign", isHoriz, targetIsTop, new String[]{"value1", "value2"}, defaultValueIndex),

// to make:		new PamameterDouble("parameter name", "tooltip descript", "paneAssign", minimum, defaultDouble, maximum),

// to make:		new PamameterInteger("parameter name", "tooltip desc", "paneAss", withSlide, min, defaultInt, max),

// to make:		new PamameterString("parameter name", "tooltip desc", "paneAss", "defaultString"),


				
				
				new ParameterChoice("dggrid_operation", "specifies the operation to be performed by this run of DGGRID", G, true, true, new String[]{"GENERATE_GRID", "OUTPUT_STATS", "BIN_POINT_VALS", "BIN_POINT_PRESENCE", 
									"TRANSFORM_POINTS"}, 0),
				
				new ParameterChoice("dggs_type", "specify a preset DGG type", G, false, true, new String[]{"CUSTOM", "SUPERFUND", "ISEA3H", "ISEA4H", "ISEA43H", "ISEA4T", "ISEA4D", "FULLER3H", "FULLER4H", "FULLER43H", "FULLER4T", "FULLER4D"}, 0),

				new ParameterInteger("precision", "number of digits to right of decimal point when outputting floating point numbers", G, true, 0, 7, 30),
				
				new ParameterChoice("rng_type", "specifies the random number generator to use", G, true, true, new String[]{"RAND", "MOTHER"}, 0),

				new ParameterInteger("verbosity", "amount of debugging output to display", G, true, 0, 0, 3),



				new ParameterChoice("dggs_topology", "desired cell shape", GS1, true, false, new String[]{"HEXAGON", "TRIANGLE", "DIAMOND"}, 0),


				new ParameterChoice("dggs_proj", "projection used by the DGGS", GS2, true, true, new String[]{"ISEA", "FULLER"}, 0),

				new ParameterChoice("proj_datum", "desired earth radius datum", GS2, false, false, new String[]{"WGS84_AUTHALIC_SPHERE", "WGS84_MEAN_SPHERE", "CUSTOM_SPHERE"}, 0),
				
				new ParameterDouble("proj_datum_radius", "desired earth radius", GS2, 1.0, 6371.0071809185, 10000.0),
				
				
				new ParameterChoice("dggs_aperture_type", "is the aperture sequence constant or mixed?", GS3, true, true, new String[]{"PURE", "MIXED43"}, 0),
				
				new ParameterChoice("dggs_aperture", "desired DGGS aperture", GS3, true, true, new String[]{"3", "4"}, 1),

				new ParameterInteger("dggs_num_aperture_4_res", "number of aperture 4 resolutions in a mixed aperture sequence", GS3, true, 0, 0, 35),
				
				
				new ParameterChoice("dggs_orient_specify_type", "how is the DGG orientation specified?", GS4, false, true, new String[]{"RANDOM", "SPECIFIED", "REGION_CENTER"}, 1),


				new ParameterDouble("dggs_vert0_lat", "latitude of icosahedron vertex 0 (degrees)", GS4, -90.0, 58.28252559, 90.0),
				
				new ParameterDouble("dggs_vert0_lon", "longitude of icosahedron vertex 0 (degrees)", GS4, -180.0, 11.25, 180.0),

				new ParameterDouble("dggs_vert0_azimuth", "azimuth from icosahedron vertex 0 to vertex 1 (degrees)", GS4, 0.0, 0.0, 360.0),
				
				new ParameterDouble("region_center_lat", "latitude of study region (degrees)", GS4, -90.0, 0.0, 90.0),

				new ParameterDouble("region_center_lon", "longitude of study region (degrees)", GS4, -180.0, 0.0, 180.0),
				
				new ParameterInteger("dggs_num_placements", "number of grid placements to use", GS4, false, 1, 1, INTMAX),

				new ParameterInteger("dggs_orient_rand_seed", "seed for orientation random number generator", GS4, false, 0, 77316727, INTMAX),
				
				new ParameterString("dggs_orient_output_file_name", "name of file for output of multiple DGGS placement parameter values", GS4, "grid.meta"),

		
				new ParameterChoice("dggs_res_specify_type", "how is the DGGS resolution specified?", GS5, true, false, new String[]{"SPECIFIED", "CELL_AREA", "INTERCELL_DISTANCE"}, 0),

				new ParameterInteger("dggs_res_spec", "specified DGG resolution", GS5, true, 0, 9, 35),

				new ParameterBoolean("dggs_res_specify_rnd_down", "should the desired cell area or intercell distance be rounded down (or up) to the nearest DGGS resolution?", GS5, true),

				new ParameterDouble("dggs_res_specify_area", "desired cell area", GS5, 1.0, 100.0, DOUBLEMAX),

				new ParameterDouble("dggs_res_specify_intercell_distance", "desired intercell distance", GS5, 1.0, 100.0, DOUBLEMAX),

				
				

				new ParameterChoice("clip_type", "method for determining whether a cell is included by a clipping polygon", GG, true, true, new String[]{"POLY_INTERSECT"}, 0),

				new ParameterChoice("clip_subset_type", "specifies how portion of DGG to generate will be determined", GG, true, false, new String[]{"WHOLE_EARTH", "AIGEN", "SHAPEFILE"}, 0),
				
				new ParameterString("clip_region_files", "space delimited list of files that specify grid clipping", GG, "test.gen"),
				
				new ParameterDouble("geodetic_densify", "maximum degrees of arc for a clipping polygon line segment", GG, 0.0, 0.0, 360.0),
				
				new ParameterInteger("update_frequency", "number of cell inclusion tests to perform between outputting status updates", GG, false, 0, 100000, INTMAX),
				
				
				
				new ParameterChoice("output_cell_label_type", "output form for generated cell indexes", O1, false, false, new String[]{"GLOBAL_SEQUENCE", "ENUMERATION", "SUPERFUND"}, 0),

				new ParameterInteger("densification", "number of points-per-edge densification to use when generating cell boundaries", O1, true, 0, 0, 500),
				
				new ParameterInteger("max_cells_per_output_file", "maximum number of cells output to a single output file", O1, false, 0, 0, INTMAX),

				new ParameterInteger("shapefile_id_field_length", "number of digits in Shapefile output cell index strings", O1, true, 1, 11, 50),


				new ParameterChoice("cell_output_type", "cell boundary output file format", O2, true, false, new String[]{"NONE", "AIGEN", "SHAPEFILE", "KML", "GEOJSON"}, 1),

				new ParameterString("cell_output_file_name", "cell boundary output file name prefix", O2, "cells"),
				//Added in v6.2
				new ParameterString("kml_name", "name tag value in KML output file", O2, ""),
				
				new ParameterString("kml_description", "description tag value in KML output file", O2, ""),
				//end of added v6.2
				
				new ParameterString("kml_default_color", "color of cell boundaries in KML output", O2, "ffffffff"),
				
				new ParameterInteger("kml_default_width", "width of cell boundaries in KML output", O2, true, 1, 4, 100),

				

				new ParameterChoice("point_output_type", "cell point output file format", O3, false, true, new String[]{"NONE", "AIGEN", "KML", "SHAPEFILE", "TEXT", "GEOJSON"}, 0),
				
				new ParameterString("point_output_file_name", "cell point output file name prefix", O3, "centers"),


				new ParameterChoice("randpts_output_type", "random points-in-cell output file format", O4, false, true, new String[]{"NONE", "AIGEN", "KML", "SHAPEFILE", "TEXT", "GEOJSON"}, 0),

				new ParameterString("randpts_output_file_name", "random points-in-cell output file name prefix", O4, "randPts"),

				new ParameterInteger("randpts_seed", "seed for cell points random number generator", O4, false, 0, 77316727, INTMAX),
				
				new ParameterInteger("randpts_num_per_cell", "number of random points to generate per cell", O4, false, 0, 0, INTMAX),
				
				new ParameterBoolean("randpts_concatenate_output", "put random points for multiple DGG placements in a single file?", O4, true),
				
				//**************NEW CODE FOR PARAMETERS v6.2
//              written by Jeremy Anders
				
				//Input sub-heading
				new ParameterChoice("input_address_type", "cell address form in input file(s)", TB1, true, true, new String[]{"GEO", "Q2DI", "SEQNUM", "Q2DD", "PROJTRI", "VERTEX2DD"}, 0),
				
				new ParameterString("input_delimiter", "character that delimits address components and additional data in the input files", TB1, " "),
				
				new ParameterString("input_files", "name(s) of files containing lon/lat locations with associated values", TB1, "" ),
				//end sub-heading
				
				//Output sub-heading
				new ParameterChoice("bin_coverage", "are values distributed over most of the globe or only a relatively small portion?", TB2, true, true, new String[]{"GLOBAL", "PARTIAL"}, 0),
				
				new ParameterChoice("cell_output_control", "designates which cells to output", TB2, true, true, new String[]{"OUTPUT_ALL", "OUTPUT_OCCUPIED"}, 0),
				
				new ParameterChoice("output_address_type", "address form to use in output", TB2, true, true, new String[]{"GEO", "Q2DI", "SEQNUM", "INTERLEAVE", "PLANE", "Q2DD", "PROJTRI", "VERTEX2DD", "AIGEN"}, 2),
				
				new ParameterString("output_file_name", "name of file to use for output", TB2, "valsout.txt"),
				
				new ParameterBoolean("output_count", "output the count of classes which are present between the cell address and the presence vector?", TB2, true),
				
				new ParameterString("output_delimiter", "character that delimits address components and additional data in the output file", TB2, " "),
				//end sub-heading
				
				
				
//**************END OF NEW PARAMETERS v6.2
			
			
		};
		return widg;
	} // end makeWidgets()
	
	public static DependencyList [] makeDependencies() {
	/*
		When creating a new DependencyList object you need the following parameters in order:
		
		parameter	parameter
		position:	type:
		
		1).			String: 		a string that hold the NAME of the WIDGET that is to be DISABLED.
		
		2).			String[]: 	a string array of ALL of the VALUES that DISABLE the specific WIDGET.
		
		3).			String[]:	a string array of ALL the corresponding CONTROL WIDGETS whos VALUES disable the specific WIDGET.
		
		4).			boolean		a flag to indicate AND or OR functionality. Use the value FALSE as the default.  
				
		Example Layout: 
		
		new DependencyList(	"name of the widget that is to be disabled",
									
									new String[] {"name of the values that affects the disabling widget"},
									
									new String[] {"the widgets the correspond to the values according to their 
														value's indecies."})//repeated widget names are required if there are more than one of their values 
																				  //that affect the particular widget it is disabling.
		
		Note: MULTIPLE values and/or REPEATED, MULTIPLE Control Widgets: 								
										
										(The control widgets also must match their value indices when being passed as parameters)
													
													example disable widget
														"disable_widget"
														
													example value that disable the disable widget:
														new String[] {"CONTROL_VALUE"}
														
													example widget that holds the value "CONTROL_VALUE":	
														new String[] {"control_widget"}
										
										since "CONTROL_VALUE" is in index 0 in the string array of VALUES then,
										"control_widget" should ALSO be in index 0 for the string array of CONTROL WIDGETS.
										Their indicies must correspond even if there are MULTIPLE values from the SAME Control widget.
										The control must be repeated to match all of its disabling value's indecies. 
								
		Example when Creating a DependencyList Object taken from the info above: 
		
			new DependencyList("disable_widget", new String[]{"CONTROL_VALUE"}, new String[]{"control_widget"})					
		
		*/		
		/*		Dependencies	*/														
		DependencyList [] dep = {
						
    			new DependencyList("dggs_num_aperture_4_res", new String[]{"PURE", "TRIANGLE", "DIAMOND"}, new String[]{"dggs_aperture_type", "dggs_topology", "dggs_topology"}, false),
				
				new DependencyList("dggs_aperture", new String[]{"MIXED43", "TRIANGLE", "DIAMOND"}, new String[]{"dggs_aperture_type", "dggs_topology", "dggs_topology"}, false),
				
				new DependencyList("dggs_aperture_type", new String[]{"TRIANGLE", "DIAMOND"}, new String[]{"dggs_topology", "dggs_topology"}, false),

				new DependencyList("cell_output_file_name", new String[]{"NONE", "OUTPUT_STATS"}, new String[]{"cell_output_type", "dggrid_operation"}, false),
		
				new DependencyList("cell_output_type", new String[]{"OUTPUT_STATS"}, new String[]{"dggrid_operation"}, false),
				
				new DependencyList("clip_region_files", new String[]{"OUTPUT_STATS"}, new String[]{"dggrid_operation"}, false),
				
				new DependencyList("clip_subset_type", new String[]{"OUTPUT_STATS"}, new String[]{"dggrid_operation"}, false),
				
				new DependencyList("clip_type", new String[]{"OUTPUT_STATS"}, new String[]{"dggrid_operation"}, false),
				
				new DependencyList("densification", new String[]{"OUTPUT_STATS"}, new String[]{"dggrid_operation"}, false),
				
				new DependencyList("dggs_num_placements", new String[]{"OUTPUT_STATS"}, new String[]{"dggrid_operation"}, false),
				
				new DependencyList("dggs_orient_output_file_name", new String[]{"1", "OUTPUT_STATS"}, new String[]{"dggs_num_placements", "dggrid_operation"}, false),
		
				new DependencyList("dggs_orient_rand_seed", new String[]{"SPECIFIED", "REGION_CENTER", "OUTPUT_STATS"}, new String[]{"dggs_orient_specify_type", "dggs_orient_specify_type", "dggrid_operation"}, false),
		
				new DependencyList("dggs_orient_specify_type", new String[]{"OUTPUT_STATS"}, new String[]{"dggrid_operation"}, false),
				
				new DependencyList("dggs_res_spec", new String[]{"CELL_AREA", "INTERCELL_DISTANCE", "OUTPUT_STATS"}, new String[]{"dggs_res_specify_type", "dggs_res_specify_type", "dggrid_operation"}, false),

				new DependencyList("dggs_res_specify_area", new String[]{"SPECIFIED", "INTERCELL_DISTANCE", "OUTPUT_STATS"}, new String[]{"dggs_res_specify_type", "dggs_res_specify_type", "dggrid_operation"}, false),
				
				new DependencyList("dggs_res_specify_intercell_distance", new String[]{"SPECIFIED", "CELL_AREA", "OUTPUT_STATS"}, new String[]{"dggs_res_specify_type", "dggs_res_specify_type", "dggrid_operation"}, false),
				
				new DependencyList("dggs_res_specify_rnd_down", new String[]{"SPECIFIED", "OUTPUT_STATS"}, new String[]{"dggs_res_specify_type", "dggrid_operation"}, false),
				
				new DependencyList("dggs_res_specify_type", new String[]{"OUTPUT_STATS"}, new String[]{"dggrid_operation"}, false),
				
				new DependencyList("dggs_vert0_azimuth", new String[]{"RANDOM", "REGION_CENTER", "OUTPUT_STATS"}, new String[]{"dggs_orient_specify_type", "dggs_orient_specify_type", "dggrid_operation"}, false),
				
				new DependencyList("dggs_vert0_lat", new String[]{"RANDOM", "REGION_CENTER", "OUTPUT_STATS"}, new String[]{"dggs_orient_specify_type", "dggs_orient_specify_type", "dggrid_operation"}, false),
				
				new DependencyList("dggs_vert0_lon", new String[]{"RANDOM", "REGION_CENTER", "OUTPUT_STATS"}, new String[]{"dggs_orient_specify_type", "dggs_orient_specify_type", "dggrid_operation"}, false),
				
				new DependencyList("geodetic_densify", new String[]{"OUTPUT_STATS"}, new String[]{"dggrid_operation"}, false),
				
				new DependencyList("max_cells_per_output_file", new String[]{"OUTPUT_STATS"}, new String[]{"dggrid_operation"}, false),
				
				new DependencyList("output_cell_label_type", new String[]{"OUTPUT_STATS"}, new String[]{"dggrid_operation"}, false),
				
				new DependencyList("point_output_file_name", new String[]{"NONE", "OUPUT_STATS"}, new String[]{"point_output_type", "dggrid_operation"}, false),
				
				new DependencyList("point_output_type", new String[]{"OUTPUT_STATS"}, new String[]{"dggrid_operation"}, false),
				
				new DependencyList("proj_datum_radius", new String[]{"WGS84_AUTHALIC_SPHERE", "WGS84_MEAN_SPHERE"}, new String[]{"proj_datum", "proj_datum"}, false),
				
				new DependencyList("randpts_concatenate_output", new String[]{"NONE", "OUTPUT_STATS"}, new String[]{"randpts_output_type", "dggrid_operation"}, false),
				
				new DependencyList("randpts_num_per_cell", new String[]{"NONE", "OUTPUT_STATS"}, new String[]{"randpts_output_type", "dggrid_operation"}, false),
				
				new DependencyList("randpts_output_file_name", new String[]{"NONE", "0", "OUTPUT_STATS"}, new String[]{"randpts_output_type", "randpts_num_per_cell", "dggrid_operation"}, false),
				
				new DependencyList("randpts_output_type", new String[]{"OUTPUT_STATS"}, new String[]{"dggrid_operation"}, false),
				
				new DependencyList("randpts_seed", new String[]{"NONE", "OUTPUT_STATS"}, new String[]{"randpts_output_type", "dggrid_operation"}, false),
												
				new DependencyList("region_center_lat", new String[]{"RANDOM", "SPECIFIED", "OUTPUT_STATS"}, new String[]{"dggs_orient_specify_type", "dggs_orient_specify_type", "dggrid_operation"}, false),
		
				new DependencyList("region_center_lon", new String[]{"RANDOM", "SPECIFIED", "OUTPUT_STATS"}, new String[]{"dggs_orient_specify_type", "dggs_orient_specify_type", "dggrid_operation"}, false),
		
			//this dependency needs fixing
				new DependencyList("shapefile_id_field_length", new String[]{"SHAPEFILE", "SHAPEFILE", "SHAPEFILE", "OUTPUT_STATS"}, new String[]{"randpts_output_type", "point_output_type","cell_output_type", "dggrid_operation"}, true),	
				
				new DependencyList("update_frequency", new String[]{"OUTPUT_STATS"}, new String[]{"dggrid_operation"}, false),
				
				new DependencyList("kml_default_color", new String[]{"NONE", "AIGEN", "SHAPEFILE", "OUTPUT_STATS"}, new String[]{"cell_output_type","cell_output_type","cell_output_type", "dggrid_operation"}, false),
				
				new DependencyList("kml_default_width", new String[]{"NONE", "AIGEN", "SHAPEFILE", "OUTPUT_STATS"}, new String[]{"cell_output_type","cell_output_type","cell_output_type", "dggrid_operation"}, false),				
				
				new DependencyList("input_address_type", new String[]{"GENERATE_GRID", "OUTPUT_STATS" }, new String[]{"dggrid_operation", "dggrid_operation"}, false),
				
				new DependencyList("input_delimiter", new String[]{"GENERATE_GRID", "OUTPUT_STATS" }, new String[]{"dggrid_operation", "dggrid_operation"}, false),
				
				new DependencyList("input_files", new String[]{"GENERATE_GRID", "OUTPUT_STATS" }, new String[]{"dggrid_operation", "dggrid_operation"}, false),
				
				new DependencyList("bin_coverage", new String[]{"GENERATE_GRID", "OUTPUT_STATS" }, new String[]{"dggrid_operation", "dggrid_operation"}, false),
				
				new DependencyList("cell_output_control", new String[]{"GENERATE_GRID", "OUTPUT_STATS" }, new String[]{"dggrid_operation", "dggrid_operation"}, false),
				
				new DependencyList("output_address_type", new String[]{"GENERATE_GRID", "OUTPUT_STATS" }, new String[]{"dggrid_operation", "dggrid_operation"}, false),
				
				new DependencyList("output_file_name", new String[]{"GENERATE_GRID", "OUTPUT_STATS" }, new String[]{"dggrid_operation", "dggrid_operation"}, false),
				
				new DependencyList("output_count", new String[]{"GENERATE_GRID", "OUTPUT_STATS" }, new String[]{"dggrid_operation", "dggrid_operation"}, false),
				
				new DependencyList("output_delimiter", new String[]{"GENERATE_GRID", "OUTPUT_STATS" }, new String[]{"dggrid_operation", "dggrid_operation"}, false)
				
		};
		return dep;
	} //end of make dependencies method
  
} // end object class Widget

class DependencyList
{	
	public DisableDependency disTop;
	private String dListName;
	
	public DependencyList (String disWidget, String[] val, String[] contrlWidgs, boolean reverse) {
			//name of widget that is to be disabled by these given values and their corresponding widget
			this.dListName = disWidget; 
		 
		
			for( int i = 0; i < val.length; i++)
				insertContrl(val[i], contrlWidgs[i], reverse);
	}

	public void insertContrl (String val, String cw, boolean r) {
			//insert at start of list
			DisableDependency temp = new DisableDependency(val, cw, r); //make new link
			temp.next = disTop; //newlink --> old first
			disTop = temp; //first --> newlink
	}
	
	public String getListName() 			{return this.dListName;}

}


