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

