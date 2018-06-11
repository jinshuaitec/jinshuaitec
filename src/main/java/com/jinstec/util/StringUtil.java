package com.jinstec.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;

/**
 * @author PC
 */
public class StringUtil {

	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}

	public static boolean isEmpty(CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

}
