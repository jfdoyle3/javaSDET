	import java.util.ArrayList;
	import java.util.List;

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
			names.add("Ant");
			
			Long count=names.stream().filter(list->list.startsWith("A")).count();
			System.out.println(count);
			
		}
	}

