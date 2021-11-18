package com.gratex.docs.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.gratex.docs.exceptions.UnexpectedDataCount;

public class StringMap implements Map<String, String> {

	private Map<String, String> innerMap = new HashMap<>();

	public StringMap() {
		// empty map
	}

	public StringMap(String...keyValuePairs) {
		if (keyValuePairs.length != 0) {
			validateDataParity(keyValuePairs);
			populaterMap(innerMap, keyValuePairs);
		}
	}

	private static void validateDataParity(String... pairs) {
		if (pairs.length % 2 != 0) {
			throw new UnexpectedDataCount("InsufficientMapContent");
		}
	}

	private static void populaterMap(Map<String, String> map, String... keyValuePairs) {
		for (int i = 0; i < keyValuePairs.length; i += 2) {
			map.put(keyValuePairs[i], keyValuePairs[i + 1]);
		}
	}

	@Override
	public int size() {
		return innerMap.size();
	}

	@Override
	public boolean isEmpty() {
		return innerMap.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return innerMap.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return innerMap.containsValue(value);
	}

	@Override
	public String get(Object key) {
		return innerMap.get(key);
	}

	@Override
	public String put(String key, String value) {
		return innerMap.put(key, value);
	}

	@Override
	public String remove(Object key) {
		return innerMap.remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends String> m) {
		innerMap.putAll(m);
	}

	@Override
	public void clear() {
		innerMap.clear();
	}

	@Override
	public Set<String> keySet() {
		return innerMap.keySet();
	}

	@Override
	public Collection<String> values() {
		return innerMap.values();
	}

	@Override
	public Set<Entry<String, String>> entrySet() {
		return innerMap.entrySet();
	}

}
