package org.mql.java.crud;

public interface CrudOperations<T> {
	boolean add(T another);
	T get(int i);
	T update(int i, T element);
	T delete();
}
