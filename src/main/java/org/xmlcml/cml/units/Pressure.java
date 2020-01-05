/**
 * Copyright (C) 2008 Peter Murray-Rust (pm286@cam.ac.uk)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
public class Pressure extends Quantity {
	
	private static final Pattern pressurePattern = 
		Pattern.compile("(\\-?\\d+(\\.\\d+)?) *(atm|Pa|gPa)");
	private static Map<String, Pressure> pressureMap;
	static {
//		CMLUnit.ensure();
		pressureMap = new HashMap<String, Pressure>();
		pressureMap.put("default", new Pressure(1.0, JumboUnit.BAR));
	};
	
	protected static String getRole() {
		return "pressure";
	}
	
	private Pressure(double val, JumboUnit units) {
		super(val, units);
	}

	/**
	 * 
	 * @param s pressure string
	 * @return time or null
	 */
	public static Quantity getPressure(String s) {
		Quantity pressure = null;
		Matcher matcher = pressurePattern.matcher(s);
		if (matcher.matches()) {
			JumboUnit unit = getUnit(matcher, getRole(), 3, JumboUnit.pressureMap);
			pressure = new Pressure(
					new Double(matcher.group(1)).doubleValue(), unit);
		} else {
			pressure = pressureMap.get(s.toLowerCase());
		}
		return pressure;
	}
}

