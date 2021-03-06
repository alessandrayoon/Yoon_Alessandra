import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ToyStore
{
	public ArrayList<Toy>toyList;  

	public ToyStore()
	{
		toyList = new ArrayList<Toy>();
	}
	
	public ToyStore(String ts)
	{
		loadToys(ts);
	}
	
	public void loadToys(String ts)
	{
		toyList = new ArrayList<Toy>();
		ArrayList<String>toys = new ArrayList<String>(Arrays.asList(ts.split(", ")));
	
		for(int i=0; i < toys.size(); i+=1) 
		{
			String name = toys.get(i);
			String type = toys.get(i+=1);
			Toy alestoy = getThatToy(name);
			if(alestoy == null)
			{
				if(type.equals("Car"))
				{
					toyList.add(new Car(name));
				}
				else if(type.equals("AF"))
				{
					toyList.add(new AFigure(name));
				}
			}
			else
			{
				alestoy.setCount(alestoy.getCount()+1);
			}
		}
	}
	
	public Toy getThatToy(String nm)
	{
		for(Toy alestoy:toyList)
		{
			if(alestoy.getName().equals(nm))
			{
				return alestoy;
			}
		}
		return null;
	}
	
	public String getMostFrequentToy()
	{
		String name = "";
		int max = Integer.MIN_VALUE;
		for(Toy alestoy:toyList)
		{
			if (max < alestoy.getCount())
			{
				max = alestoy.getCount();
				name = alestoy.getName();
			}	
		}
		return name;		
	}
	
	public String getMostFrequentType()
	{
		int cars = 0;
		int figures = 0;
		
		for(Toy alestoy:toyList)
		{
			if(alestoy.getType().equals("Car"))
				cars+=1;
			if(alestoy.getType().equals("Action Figure"))
				figures+=1;
		}
		
		if(cars > figures)
		{
			return "Cars";
		}
		if(cars < figures)
		{
			return "Action Figures";
		}
		else
		{
			return "Equal amounts of action figures and cars!";
		}
	}
	
	public String toString()
	{
		String result = "";
		for(Toy alestoy:toyList)
		{
			result += " " + alestoy;
		}
		return result;
	}
} 
