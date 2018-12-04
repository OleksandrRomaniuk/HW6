
public class Main {

	public static void main(String[] args) {
		MyList list = new DefaultMyList();
		System.out.println(list.toString());
		list.add(1);
		list.add(2);
		list.add(3);
		
		System.out.println(list.toString());
		
		list.remove(2);
		
		System.out.println(list.toString());
		
		list.add(4);
		
		System.out.println(list.toString());
		
		System.out.println(list.size());
		System.out.println(list.toArray()[2]);
		System.out.println(list.contains(3));
		System.out.println(list.contains(7));
		
		for(Object o: list.toArray())
			System.out.println(o);
	}

}
