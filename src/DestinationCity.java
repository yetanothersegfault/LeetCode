import java.util.ArrayList;
import java.util.List;

public class DestinationCity {
	
	public static void main(String[] args)
	{
		List<String> path = new ArrayList<>();
		List<List<String>> paths = new ArrayList<>();
		path.add("A");
		path.add("Z");
		paths.add(path);
		
//		path = new ArrayList<>();
//		path.add("New York");
//		path.add("Lima");
//		paths.add(path);
//
//		path = new ArrayList<>();
//		path.add("Lima");
//		path.add("Sao Paulo");
//		paths.add(path);
		
		DestinationCity solution = new DestinationCity();
		System.out.println(solution.destCity(paths));
		
	}
	
	public String destCity(List<List<String>> paths)
	{
		boolean notFound = true;
		int i = 0;
		String ans = null;
		while(notFound)
		{
			List<String> path = paths.get(i);
			String dest = path.get(1);
			boolean hasNext = false;
			int j = 0;
			while(!hasNext && j < paths.size())
			{
				//check current dest to see if there is a path leading from the city
				if(dest.equals(paths.get(j).get(0)))
				{
					hasNext = true;
					i = j;
				}
				j++;
			}
			if(!hasNext)
			{
				//found dest city that has no paths away
				notFound = false;
				ans = dest;
			}
		}
		return ans;
	}
}
