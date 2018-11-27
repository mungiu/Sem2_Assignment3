import java.util.List;

public interface MapADT<K, V>
{
	void put(K key, V value);

	V get(K key);

	boolean containsKey(K key);

	boolean containsValue(V value);

	int size();

	boolean isEmpty();

	List<K> keyList();

	List<V> valueList();

	V remove(K key);

	boolean remove(K key, V value);

	boolean replace(K key, V value);
}
