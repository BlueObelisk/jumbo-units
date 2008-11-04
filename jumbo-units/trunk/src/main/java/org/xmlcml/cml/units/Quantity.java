package org.xmlcml.cml.units;

import java.util.Map;
import java.util.regex.Matcher;
/**
 * 
 * @author pm286
 *
 */
public class Quantity {

	/**
	 * @param matcher
	 * @param role
	 * @return unit
	 * @throws RuntimeException
	 */
	protected static JumboUnit getUnit(Matcher matcher, String role, int group, Map<String, JumboUnit> unitMap) throws RuntimeException {
		String unitS = matcher.group(group);
		JumboUnit unit = unitMap.get(unitS.toLowerCase());
		if (unit == null) {
			throw new RuntimeException("Unknown unit for "+role+": "+unitS);
		}
		return unit;
	}

	protected JumboUnit units;
	protected double value;
	
	protected Quantity(double value, JumboUnit units) {
		this.value = value;
		if (units == null) {
			throw new RuntimeException("must give units");
		}
		this.units = units;
	}

	/**
	 * @return the units
	 */
	public JumboUnit getUnits() {
		return units;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}
}

