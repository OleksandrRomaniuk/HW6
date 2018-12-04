
public class DefaultMyList implements MyList {

	private Object[] myList;

	public DefaultMyList() {
		myList = new Object[] {null};
	}

	@Override
	public void add(Object e) {
		if (myList[0] == null)
			myList[0] = e;
		else {
			Object[] temp = myList;
			myList = new Object[myList.length + 1];

			for (int i = 0; i < myList.length; i++)
				if(i < temp.length)
					myList[i] = temp[i];
				else
				{
					myList[i] = e;
					break;
				}
		}
	}

	@Override
	public void clear() {
		myList = new Object[1];
	}

	@Override
	public boolean remove(Object o) {
		Object[] temp;
		int skipper = 0;
		for (int i = 0; i < myList.length; i++) {
			if (myList[i].equals(o)) {
				temp = new Object[myList.length - 1];
				for(int j = 0; j < myList.length; j++)
					if(j != i)
						temp[j - skipper] = myList[j];
					else
					{
						skipper = 1;
					}
				myList = temp;
				return true;
				}
			}
		
		return false;
		}
	
	@Override
	public Object[] toArray() {
		Object[] temp = new Object[size()];
		for (int i = 0; i < myList.length; i++) {
			if (myList[i] != null)
				temp[i] = myList[i];
			else
				return temp;
		}
		return temp;
	}

	@Override
	public int size() {
		return myList.length;
	}

	@Override
	public boolean contains(Object o) {
		for (int i = 0; i < myList.length; i++) 
			if (myList[i].equals(o))
				return true;
		return false;
	}

	@Override
	public boolean containsAll(MyList c) {
		boolean contains = true;
		for (int i = 0; i < myList.length; i++) 
			if (myList[i].equals(c.toArray()[i]))
				contains = true;
		return contains;
	}

	@Override
	public String toString() {
		if(myList[0] != null)
		{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < myList.length; i++) 
			if (myList[i] != null)
				sb.append(myList[i].toString() + ";");
		
		return sb.toString();
		}
		else return "";
	}

}
