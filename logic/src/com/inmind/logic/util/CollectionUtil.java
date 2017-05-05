package com.inmind.logic.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CollectionUtil {

	private static void recon() {
		Set<String> set1 = new HashSet<>(Arrays.asList("1","3","2","4"));
		Set<String> set2 = new HashSet<>(Arrays.asList("3","5","4","9"));
		Set<String> set3 = new HashSet<>(Arrays.asList("2","13","3","4"));
		
		// print original values;
		System.out.println("set1:- " + set1);
		System.out.println("set2:- " + set2);
		System.out.println("set3:- " + set3);
		
		// start doing reconciliation
		Set<String> commonValues = new HashSet<>();
		commonValues.addAll(set1);
		commonValues.addAll(set2);
		commonValues.addAll(set3);

		commonValues.retainAll(set1);
		commonValues.retainAll(set2);
		commonValues.retainAll(set3);
		
		set1.removeAll(commonValues);
		set2.removeAll(commonValues);
		set3.removeAll(commonValues);
		
		// print recon values;
		System.out.println("Common values:- " + commonValues);
		System.out.println("Only in set1:- " + set1);
		System.out.println("Only in set2:- " + set2);
		System.out.println("Only in set3:- " + set3);
	}
	
	public static void main(String[] args) {
		recon();

	}

}

