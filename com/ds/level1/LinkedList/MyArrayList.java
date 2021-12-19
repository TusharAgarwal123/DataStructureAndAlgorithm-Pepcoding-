package com.ds.level1.LinkedList;

public class MyArrayList {

	public static class ArrayList {
		int size;
		int data[];

		static final int DEFAULT_CAPACITY = 5;

		public ArrayList() {
			this(DEFAULT_CAPACITY);
		}

		public ArrayList(int cap) {
			size = 0;
			data = new int[cap];
		}

		public int size() {
			return size;
		}

		public void display() {
			for (int i = 0; i < size; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}

		public int get(int id) {
			if (id < 0 || id >= size) {
				System.out.print("Invalid Arguments");
				return -1;
			}

			return data[id];
		}

		public void set(int id, int val) {
			if (id < 0 || id >= size) {
				System.out.print("Invalid Arguments");
				return;
			}

			data[id] = val;
		}

		public void add(int id, int val) {

			if (id < 0 || id > size) {
				System.out.print("Invalid Arguments");
				return;
			}

			// resizing the array.

			if (size == data.length) {
				System.out.println("Resizing...");
				int ndata[] = new int[data.length * 2];
				for (int i = 0; i < size; i++) {
					ndata[i] = data[i];
				}
				data = ndata;
			}

			for (int i = size; i >= id + 1; i--) {
				data[i] = data[i - 1];
			}

			data[id] = val;
			size++;

		}

		public void remove(int id) {
			if (id < 0 || id >= size) {
				System.out.print("Invalid Arguments");
				return;
			}

			for (int i = id; i < size - 1; i++) {
				data[i] = data[i + 1];
			}

			data[size - 1] = 0;
			size--;

			// resizing array
			if (size == data.length / 4) {
				int ndata[] = new int[data.length / 2];
				for (int i = 0; i < size; i++) {
					ndata[i] = data[i];
				}
				data = ndata;
			}

		}

		// this method add the value at the end.
		public void add(int val) {

			// resizing the array.

			if (size == data.length) {
				int ndata[] = new int[data.length * 2];
				for (int i = 0; i < size; i++) {
					ndata[i] = data[i];
				}
				data = ndata;
			}

			data[size] = val;
			size++;

		}

	}

	public static void main(String[] args) {

		ArrayList list = new ArrayList();

		list.add(10);
		list.add(20);
		list.display();

		list.add(1, 30);
		list.add(40);
		list.display();
		list.add(50);
		list.display();
		list.set(3, 100);
		list.set(4, 23);
		list.display();
		list.add(5, 300);
		list.display();
		System.out.println(list.get(4));

		list.remove(3);
		list.display();

		list.remove(1);
		list.display();

	}

}
