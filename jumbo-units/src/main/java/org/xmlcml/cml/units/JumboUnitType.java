package org.xmlcml.cml.units;

import java.io.IOException;
import java.io.Writer;

import nu.xom.Element;
import nu.xom.Node;


/**
 * user-modifiable class supporting unitType. * autogenerated from schema use as
 * a shell which can be edited
 *
 */
public class JumboUnitType extends Element {

	/** namespaced element name.*/
//	public final static String NS = C_E+TAG;
	
    /** common units in chemistry */
    public enum UnitType {
    	/** amount*/
    	AMOUNT			("unitType:amount"),
    	/** mass*/
    	DENSITY			("unitType:density"),
    	/** mass*/
    	MASS			("unitType:mass"),
    	/** time*/
    	TIME			("unitType:time"),
    	/** temperature*/
    	TEMP			("unitType:temp"),
    	/** volume*/
    	VOL				("unitType:volume"),
    	;
        /** dewisott */
    	public final String value;
    	private UnitType(String s) {
    		value = s;
    	}
    };

	/** amount*/
    public final static JumboUnitType UNKNOWN = 
    	new JumboUnitType("unitType:unk", "unk", "unk", JumboUnit.UNKNOWN);
	/** amount*/
    public final static JumboUnitType AMOUNT = 
    	new JumboUnitType("unitType:amount", "amount", "amt", JumboUnit.MOLE);
	/** mass*/
    public final static JumboUnitType DENSITY =
    	new JumboUnitType("unitType:density", "density", "rho", JumboUnit.KGPERM3);
	/** mass*/
    public final static JumboUnitType MASS =
    	new JumboUnitType("unitType:mass", "mass", "m", JumboUnit.KG);
	/** time*/
    public final static JumboUnitType TIME =
    	new JumboUnitType("unitType:time", "time", "t", JumboUnit.SECOND);
	/** time*/
    public final static JumboUnitType PRESSURE =
    	new JumboUnitType("unitType:pressure", "pressure", "P", JumboUnit.PASCAL);
	/** temperature*/
    public final static JumboUnitType TEMP =
    	new JumboUnitType("unitType:temp", "temperature", "T", JumboUnit.KELVIN);
	/** volume*/
    public final static JumboUnitType VOL =
    	new JumboUnitType("unitType:volume", "volume", "vol", JumboUnit.M3);
	;

    /**
     * unit without valis JumboUnitType.
     *
     */
    public static JumboUnitType UNKNOWN_PARENT = null;
    

    static {
        UNKNOWN_PARENT = new JumboUnitType();
        UNKNOWN_PARENT.setId("unknownParentSI");
        UNKNOWN_PARENT.setTitle("unknown parentSI");
    };
    
    private String id;
    private String title;
    private String abbreviation;
    private JumboUnit parentSI;

    public JumboUnitType(String id, String title,
			String abbreviation, JumboUnit parentSI) {
		this();
		this.id = id;
		this.title = title;
		this.abbreviation = abbreviation;
		this.parentSI = parentSI;
	}


	/**
     * contructor.
     */
    public JumboUnitType() {
    	this(JumboUnitType.UNKNOWN);
    }


    /**
     * contructor.
     *
     * @param old
     */
    public JumboUnitType(JumboUnitType old) {
        super(old.getLocalName());

    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Node copy() {
        return new JumboUnitType(this);

    }

    /**
     * writes table header for units dictionary as HTML.
     *
     * @param w
     *            writer
     * @throws IOException
     */
    static void writeHTMLTableHeader(Writer w) throws IOException {
        w.write("<tr>" + "<th>id</th>" + "<th>name</th>" + "<th>abbrev</th>"
                + "<th>type</th>" + "<th>title</th>" + "<th>multSI</th>"
                + "<th>SI</th>" + "<th>description</th>" + "</tr>\n");
    }

    /**
     * writes units dictionary as HTML.
     *
     * @param w
     *            writer
     * @throws IOException
     */
    public void writeHTML(Writer w) throws IOException {
//        CMLElements<CMLDefinition> definitions = this.getDefinitionElements();
//        CMLDefinition definition = (definitions.size() > 0) ? definitions
//                .get(0) : null;
//        String def = (definition == null) ? "" : definition.getStringContent();
        w.write("<tr>" + "<td><b>" + this.getId() + "</b></td>" + "<td><b>"
               /* + this.getName()*/ + "</b></td>" + "<td>"
                + this.getAbbreviation() + "</td>" + "<td>" + this.getTitle()
                + "</td>" + "<td>" /*+ this.getParentSI() */+ "</td>" + "<td>"
                + /*def +*/ "</td>" + "</tr>\n");
    }

    /**
     * gets id. traps missing id and throws runtime.
     *
     * @return id
     * @throws RuntimeException
     *             missing id
     */
    public String getId() {
    	return id;
    }

//    /** gets containing JumboUnitTypeList.
//     *
//     * @return parent unitList
//     * @throws RuntimeException does not have a parent list
//     */
//    public JumboUnitTypeList getParentJumboUnitTypeList() {
//        Node parent = this.getParent();
//        JumboUnitTypeList parentUnitTypeList = (
//                parent != null && parent instanceof JumboUnitTypeList) ?
//                        (JumboUnitTypeList) parent
//                : null;
//        if (parentUnitTypeList == null) {
//            throw new RuntimeException("unit " + this.getId()
//                    + " must be contained within a unitTypeList");
//        }
//        return (parent instanceof JumboUnitTypeList) ? (JumboUnitTypeList) parent : null;
//    }

//    /**
//     * adds dimensions from another unitType. normally 'this' is a new UnitType
//     * to which dimensions are added when units are composed.
//     *
//     * @param unitType
//     *            to provide dimensions
//     * @param power
//     *            to multiply unitType dimensions
//     */
//    public void composeDimensionsFrom(JumboUnitType unitType, int power) {
//        if (unitType != null) {
//            CMLElements<JumboDimension> dimensions = unitType
//                    .getDimensionElements();
//            for (JumboDimension dimension : dimensions) {
//                this.composeDimensionsFrom(dimension, power);
//            }
//        }
//    }

//    /**
//     * incorporate dimension into dimensions of this. if dimension has name 'dd'
//     * and this has a dimenesion of the same name with power pp, the power will
//     * be incremented to pp+(dimension.getPower()*power) and re-stored. If there
//     * is no dimension, then a new child is added with power
//     * dimension.getPower()*power
//     *
//     * @param dimension
//     *            to compose
//     * @param power
//     *            of composed dimension. This multiplies the power in
//     *            dimension.getPower();
//     */
//    public void composeDimensionsFrom(JumboDimension dimension, int power) {
//        if (dimension == null) {
//            throw new RuntimeException("dimension must not be null");
//        }
//        String newName = dimension.getName();
//        if (newName == null) {
//            throw new RuntimeException("dimension " + dimension.getId()
//                    + " must have name");
//        }
//        CMLElements<JumboDimension> thisDimensions = this.getDimensionElements();
//        boolean found = false;
//        for (JumboDimension thisDimension : thisDimensions) {
//            if (newName.equals(thisDimension.getName())) {
//                int pp = (int) Math.round(thisDimension.getPower() + power);
//                thisDimension.setPower(pp);
//                found = true;
//                break;
//            }
//        }
//        if (!found) {
//            JumboDimension newDimension = new JumboDimension(dimension);
//            int pp = (int) Math.round(dimension.getPower() * power);
//            newDimension.setPower(pp);
//            this.appendChild(newDimension);
//        }
//    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public void setId(String id) {
		this.id = id;
	}
}
