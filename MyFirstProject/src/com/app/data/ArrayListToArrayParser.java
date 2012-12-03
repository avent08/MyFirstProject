package com.app.data;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListToArrayParser {

	public String[] toStringArray(ArrayList<String> arrayListString)
	{
		return Arrays.asList(arrayListString.toArray()).toArray(new String[arrayListString.toArray().length]);
	}
	
	public Integer[] toIntArray(ArrayList<Integer> arrayListInt)
	{		
		return Arrays.asList(arrayListInt.toArray()).toArray(new Integer[arrayListInt.toArray().length]);
	}
	
}
