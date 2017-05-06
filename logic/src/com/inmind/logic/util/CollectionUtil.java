package com.inmind.logic.util;

import java.util.*;

public class CollectionUtil {

	public static void recon() {
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
	
	private static String data[][] = {{"nitin","rane"}, {"tanvi","rane"}, {"nitin","b+"}};
	
	private static class FlyweightMap extends AbstractMap<String, String> {
		EntrySet entries = new EntrySet(data.length-1);
		
		@Override
		public Set<Map.Entry<String, String>> entrySet() {
			return entries;
		}
		
		private static class Entry implements Map.Entry<String, String> {
			int index = -1;
			
			Entry(int i) {
				this.index = i;
			}
			
			@Override
			public String getKey() {			
				return data[index][0];
			}

			@Override
			public String getValue() {
				return data[index][1];
			}

			@Override
			public String setValue(String value) {
				throw new UnsupportedOperationException();
			}
			
			@Override
			public boolean equals(Object arg0) {
				return data[index][0].equals(arg0);
			}
			
			@Override
			public int hashCode() {
				return data[index][0].hashCode();
			}
		}	
		
		private static class EntrySet extends AbstractSet<Map.Entry<String, String>> {
			int size;
			
			EntrySet(int s) {
				if (s < 0) {
					size = 0;
				} else if (s > data.length) {
					size = data.length - 1;
				} else {
					size = s;
				}
			}

			private class Iter implements Iterator<Map.Entry<String, String>> {

				Entry entry = new Entry(-1);
				
				@Override
				public boolean hasNext() {
					return entry.index < size;
				}

				@Override
				public Map.Entry<String, String> next() {
					entry.index++;
					return entry;
				}
				
			}
			
			@Override
			public Iterator<Map.Entry<String, String>> iterator() {			
				return new Iter();
			}

			@Override
			public int size() {
				return this.size;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		//recon();
		
		FlyweightMap map = new FlyweightMap();
		System.out.println(map);

	}

}

