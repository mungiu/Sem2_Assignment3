import java.util.ArrayList;
import java.util.List;

public class ArrayMap<K, V> implements MapADT<K, V>
{
	private class Entry<K, V>
	{
		K key;
		V val;

		public Entry(K key, V val)
		{
			this.key = key;
			this.val = val;
		}
	}

	private Object[] pairs;// = new Entry[3];
	private int nextIdx;
	private int count;

	public ArrayMap()
	{
		pairs = new Object[11];

		//Entry<K,V>[] es = Array.newInstance((Entry<K,V>).cl, 3);
		nextIdx = 0;
		count = 0;
	}

	@Override
	public void put(K key, V value)
	{
		if (key == null || value == null)
			throw new NullPointerException("Neither key nor value can be null");
		if (count == pairs.length)
			expand();
		if (containsKey(key))
			replace(key, value);

		else
		{
			pairs[nextIdx] = new Entry(key, value);
			nextIdx++;
			count++;
		}
	}

	private void expand()
	{
		Object[] tmp = new Object[pairs.length * 2];
		for (int i = 0; i < pairs.length; i++)
			tmp[i] = pairs[i];

		pairs = tmp;
	}


	@Override
	public V get(K key)
	{
		if (count == 0) return null;
		for (Object pair : pairs)
		{
			if (pair == null) return null;
			if (((Entry<K, V>) pair).key.equals(key)) return ((Entry<K, V>) pair).val;
		}
		return null;
	}

	@Override
	public boolean containsKey(K key)
	{
		if (count == 0) return false;
		for (Object pair : pairs)
		{
			if (pair == null) return false;
			if (((Entry<K, V>) pair).key.equals(key)) return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(V value)
	{
		for (Object pair : pairs)
			if (((Entry<K, V>) pair).val.equals(value)) return true;

		return false;
	}

	@Override
	public int size()
	{
		return count;
	}

	@Override
	public boolean isEmpty()
	{
		return count == 0;
	}

	@Override
	public List<K> keyList()
	{
		List<K> keys = new ArrayList<>(pairs.length);
		for (Object pair : pairs)
			keys.add(((Entry<K, V>) pair).key);

		return keys;
	}

	@Override
	public List<V> valueList()
	{
		List<V> vals = new ArrayList<>(pairs.length);
		for (Object pair : pairs)
			vals.add(((Entry<K, V>) pair).val);

		return vals;
	}

	@Override
	public V remove(K key)
	{
		if (key == null)
			throw new NullPointerException();
		if (!containsKey(key)) return null;
		boolean isFound = false;
		V tmp = null;
		for (int i = 0; i < count; i++)
		{
			if (!isFound)
				if (((Entry<K, V>) pairs[i]).key.equals(key))
				{
					tmp = ((Entry<K, V>) pairs[i]).val;
					isFound = true;
				}
			if (isFound)
				if (i + 1 < pairs.length)
					pairs[i] = pairs[i + 1];
		}
		if (tmp != null)
		{
			pairs[count - 1] = null;
			count--;
		}
		return tmp;
	}

	@Override
	public boolean remove(K key, V value)
	{
		if (!containsKey(key)) return false;
		boolean isFound = false;
		for (int i = 0; i < count; i++)
		{
			if (!isFound)
			{
				if (pairs[i] == null) return false;
				if (((Entry<K, V>) pairs[i]).key.equals(key) && ((Entry<K, V>) pairs[i]).val.equals(value))
					isFound = true;
			}
			if (isFound)
				if (i + 1 <= pairs.length)
					pairs[i] = pairs[i + 1];
		}
		if (isFound)
		{
			pairs[count - 1] = null;
			count--;
		}
		return isFound;
	}

	@Override
	public boolean replace(K key, V value)
	{
		if (!containsKey(key)) return false;

		for (Object pair : pairs)
			if (((Entry<K, V>) pair).key.equals(key))
			{
				((Entry<K, V>) pair).val = value;
				return true;
			}

		return false;
	}
}
