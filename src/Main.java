import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		DefaultMyList list = new DefaultMyList();
		System.out.println(list.toString());
		list.add("one");
		list.add(2);
		list.add("three");
		list.add("four");

		System.out.println(list.toString());

		list.remove("three");

		System.out.println(list.toString());

		list.remove("four");

		System.out.println(list.toString());

		System.out.println(list.size());
		System.out.println(list.toArray()[1]);
		System.out.println(list.contains(3));
		System.out.println(list.contains(7));

		System.out.println("Size:"+list.size());
		System.out.println();
		
		for (Object o : list.toArray())
			System.out.println(o);

		list.add("three");
		list.add("four");

		System.out.println("Size:"+list.size());

		for (Object o : list) {
			System.out.println(o);
		}
		System.out.println("Size:"+list.size());
		System.out.println();
		
		Iterator<Object> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());

		System.out.println("previous");
		int i = 4;
		while (list.listIterator().hasPrevious()) {
			System.out.println(list.listIterator().previous());
			list.listIterator().set("Item: " + i--);
		}

		System.out.println();
		for (Object e : list) {
			System.out.println(e);
		}
		
		System.out.println(list.size());
		/*
		ArrayList l = new ArrayList();
		l.add("1");
		l.add("1");
		l.add("1");
		l.add("1");
		int j = 0;
		for(Object o: l)
			l.listIterator().set(j++);
		
		
		for(Object o: l)
			System.out.println(o);
			*/
	}

}
