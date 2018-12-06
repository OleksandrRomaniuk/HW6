import java.util.Iterator;

public class DefaultMyList implements MyList, ListIterable {

	private Object[] myList;
	private int currentIndicator = 0;
	private boolean trigger = false;
	private int lastReturned = 0;

	public DefaultMyList() {
		myList = new Object[] { null };
	}

	@Override
	public void add(Object e) {

		if (e != null)
			addNewElement(e);
		else
			throw new IllegalArgumentException();
	}

	private void addNewElement(Object e) {
		{
			if (myList[0] == null)
				myList[0] = e;
			else {
				Object[] temp = myList;
				myList = new Object[myList.length + 1];

				for (int i = 0; i < myList.length; i++)
					if (i < temp.length)
						myList[i] = temp[i];
					else {
						myList[i] = e;
						break;
					}
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
				for (int j = 0; j < myList.length; j++)
					if (j != i)
						temp[j - skipper] = myList[j];
					else {
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
		if (myList[0] != null) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < myList.length; i++)
				if (myList[i] != null)
					sb.append(myList[i].toString() + ";");

			return sb.toString();
		} else
			return "";
	}

	@Override
	public Iterator<Object> iterator() {
		IteratorImpl iterator = new IteratorImpl();

		return iterator;
	}

	private class IteratorImpl implements Iterator<Object> {

		@Override
		public boolean hasNext() { // returns true if the iteration has more elements
			return currentIndicator < size();
		}

		@Override
		public Object next() { // returns the next element in the iteration
			trigger = true;
			if(currentIndicator < 0)
				currentIndicator = 0;
			lastReturned = currentIndicator;
			return myList[currentIndicator++];
		}

		@Override
		public void remove() { // removes from the underlying collection the last element returned by this
			if (trigger) {
				if (currentIndicator < 0)
					DefaultMyList.this.remove(myList[0]);
				else if (currentIndicator > (size() - 1))
					DefaultMyList.this.remove(myList[size() - 1]);
				else
					DefaultMyList.this.remove(myList[currentIndicator]);
				trigger = false;

			} else
				throw new IllegalStateException();
		}
	}

	@Override
	public ListIterator listIterator() {
		return new ListIteratorImpl();
	}

	private class ListIteratorImpl extends IteratorImpl implements ListIterator {

		@Override
		public boolean hasPrevious() {
			return currentIndicator > -1;
		}

		@Override
		public Object previous() {
			trigger = true;
			if (currentIndicator > (size() - 1))
				currentIndicator = (size() - 1);
			lastReturned = currentIndicator;
			return myList[currentIndicator--];
		}

		@Override
		public void set(Object e) {
				myList[lastReturned] = e;

		}
	}
}
