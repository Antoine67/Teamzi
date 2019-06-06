package fr.teamzi.dev.utils;

import java.text.Normalizer;

public class Utils {
	public static boolean isInteger(String str) {
		return str.matches("-?\\d+");
	}
	
	
	public static String cleanName(String initStr) {
		if (initStr == null) return null;
		String finalStr = Normalizer.normalize(initStr, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		
		finalStr=finalStr.replaceAll("\\s+","");
		finalStr=finalStr.replaceAll(" ","");
		finalStr=finalStr.toLowerCase();
		
		return finalStr;
	}
}
