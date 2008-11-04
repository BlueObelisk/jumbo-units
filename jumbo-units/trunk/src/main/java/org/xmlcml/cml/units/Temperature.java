package org.xmlcml.cml.units;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author pm286
 *
 */
public class Temperature extends Quantity {

	// FIXME don't think this is required
	
	/** left escape for non-ASCII */
	public final static String LESCAPE = "{{";
	/** right escape for non-ASCII */
	public final static String RESCAPE = "}}";
	/** left escape in regex */
	public final static String LESCAPEREGEX = "\\{\\{";
	/** right escape in regex */
	public final static String RESCAPEREGEX = "\\}\\}";
	
	/** degree */
	public final static String ESCAPE_DEGREE = LESCAPE+"176"+RESCAPE;
	/** degree in regex */
	public final static String REGEX_DEGREE = LESCAPEREGEX+"176"+RESCAPEREGEX;
	/** */
	
	private static final Pattern temperaturePattern = 
		Pattern.compile("(\\-?\\d+(\\.\\d+)?) *(o|deg|"+REGEX_DEGREE+")?(C|K)");
	private static Map<String, Temperature> temperatureMap;
	static {
//		CMLUnit.ensure();
		temperatureMap = new HashMap<String, Temperature>();
		temperatureMap.put("rt", new Temperature(298.0, JumboUnit.KELVIN));
	};
	protected static String getRole() {
		return "temperature";
	}
	
	
	private Temperature(double val, JumboUnit units) {
		super(val, units);
	}

	/**
	 * 
	 * @param s timestring
	 * @return time or null
	 */
	public static Temperature getTemperature(String s) {
		Temperature temperature = null;
		Matcher matcher = temperaturePattern.matcher(s);
		if (matcher.matches()) {
			JumboUnit unit = getUnit(matcher, getRole(), 4, JumboUnit.temperatureMap);
			temperature = new Temperature(
					new Double(matcher.group(1)).doubleValue(), unit);
		} else {
			temperature = temperatureMap.get(s.toLowerCase());
		}
		return temperature;
	}
}
