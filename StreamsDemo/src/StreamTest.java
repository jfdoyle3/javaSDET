	import java.util.ArrayList;
	import java.util.List;
import java.util.stream.Stream;

import org.testng.annotations.Test;

	public class StreamTest {
		
		// Count the number of names starting with the letter A in the list
		@Test
		public void regular()
		{
			ArrayList<String> names=new ArrayList<String>();
			names.add("Albert");
			names.add("Jim");
			names.add("Sue");
			names.add("Adam");
			names.add("Ant");
			int count=0;
		
			for (int idx=0; idx<names.size(); idx++)
			{
				String name=names.get(idx);
				if(name.startsWith("A"))
				{
					count++;
				}
			}
			
			System.out.println(count);
	    }
		
		@Test
		public void StreamFilter()
		{
			ArrayList<String> names=new ArrayList<String>();
			names.add("Albert");
			names.add("Jim");
			names.add("Sue");
			names.add("Adam");
			names.add("Andrea");
			//  there's no life for intermediate operation if there's no terminal operation
			//  terminal operation will continue to .count .filter returns true.
			// we can create stream.
			// how to use .filter in stream API
			Long count=names.stream().filter(list->list.startsWith("A")).count();
			System.out.println(count);
			
			Long streamCount=Stream.of("Albert","Jim","Sue","Adam","Andrea").filter(list->
			{
				list.startsWith("A");
				return true;
			}).count();
			System.out.println(streamCount);
			// Print all names in ArrayList
			
		}
	}

