import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Predicate;

public class Coursera_code {
	// election name and candidate winner find
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
        int size = sc.nextInt();
        char[][] iMap = new char[size][size];
        
        char temp[] = new char[size];
        String vals="";
        for(int i=1; i<=size; i++)
        {
        	 vals= sc.next();
            temp= vals.toCharArray();   
            for(int j=0;j<temp.length;j++){
                iMap[i-1][j]= temp[j];
            }
        }
        
        for(int i=0;i<size;i++)
        {
        	for(int j=0;j<size;j++){
        		System.out.print(iMap[i][j]);
        	}
        	System.out.println();
        }

//		TreeMap<String, Integer> namesTMap = new TreeMap<String, Integer>();
//		
//		String name = "";
//		int totalNames= sc.nextInt();
//		
//		for (int i = 0; i <totalNames ; i++) {
//			name = sc.next();
//			if (namesTMap.containsKey(name))
//				namesTMap.put(name, namesTMap.get(name) + 1);
//			else
//				namesTMap.put(name, 1);
//		}
//		int maxValue =Collections.max(namesTMap.values());
//
//		Iterator<Entry<String, Integer>> it = namesTMap.entrySet().iterator();
//	    while (it.hasNext()) {
//	        Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)it.next();
//	        if(Integer.parseInt(entry.getValue().toString())!= maxValue)
//	        	it.remove();
//	    }
//	    System.out.println(namesTMap.lastKey());
//	    
	
	}

}
