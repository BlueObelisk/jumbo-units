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
public class Time extends Quantity {
	private static Pattern timePattern = null;
	private static Map<String, Time> timeMap;
	static void ensurePattern() {
		if (timePattern == null) {
			timePattern = 
				Pattern.compile("(\\d+(\\.\\d+)?) *(wk|week|weeks|h|hr|hours|m|min|mins|s|sec)");
			timeMap = new HashMap<String, Time>();
			timeMap.put("weekend", new Time(60, JumboUnit.HOUR));
			timeMap.put("overnight", new Time(12, JumboUnit.HOUR));
		}
	}
	protected static String getRole() {
		return "time";
	}
	
	private Time(double val, JumboUnit units) {
		super(val, units);
	}

	/**
	 * 
	 * @param s timestring
	 * @return time or null
	 */
	public static Quantity getTime(String s) {
		ensurePattern();
		Quantity time = null;
		Matcher matcher = timePattern.matcher(s);
		if (matcher.matches()) {
			JumboUnit unit = getUnit(matcher, getRole(), 3, JumboUnit.timeMap);
			time = new Time(
					new Double(matcher.group(1)).doubleValue(), unit);
		} else {
			time = timeMap.get(s.toLowerCase());
		}
		return time;
	}
}

