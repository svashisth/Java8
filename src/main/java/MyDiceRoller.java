import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;


public class MyDiceRoller
implements IDiceRoller {
	// Using Arraylist to keep sets of valid values for number of sides per dice
	ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(4, 6, 8, 10, 12, 20,100));
    public int roll(int n, int n2) {
    	// Handling exceptions for n <= 0
        if (n <= 0) {
            throw new IllegalArgumentException("The number of dice " + n + " must be a positive integer");
        }
    	// Handling exceptions if n2 is not a valid value 
        if (!list.contains(n2)){
        	throw new IllegalArgumentException("The number of sides per dice " + n2 +" supplied is invalid");
        }
    	// Handling exceptions for n is not between 1 and n2
        if (!(n >= 1 && n <= n2)){
        	throw new IllegalArgumentException("The number of dice " + n +" supplied should be between 1 and number of sides per die " + n2);
        }
        // even distribution for the given inputs
        return 1+(int)(Math.random() * n2 * n);
    }
    
    static class StringData{

    	String data ;
    	
		public StringData(String string)
		{
			this.data = string;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			StringData other = (StringData) obj;
			if (data == null)
			{
				if (other.data != null)
					return false;
			}
			else if (!data.equals(other.data))
				return false;
			return true;
		}

		@Override
		public String toString()
		{
			return String.format("StringData [data=%s]", data);
		}
		
    }
    
    public static void main(String[] args){
    	Map<StringData, String> map =new HashMap<StringData, String>();
    	
    	for (int i = 0; i < 1000000; i++)
		{
    		String random = RandomStringUtils.randomAlphanumeric(6);
    		StringData stringData = new StringData(random);
        	if(map.get(stringData) != null)
        		System.out.println("Conflict\t" + stringData);
        	map.put(stringData, "http:\\ansfj.com");	
		}
    	System.out.println("main\t" + map.size());
    }
}