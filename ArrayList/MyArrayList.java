class MyArrayList {
	public MyArrayList() {}
	
	Object[] array = new Object[10];
	int length = array.length;
	int cellsFilled = 0;

	public void setElements(int idx, Object e) {
		array[idx] = e;
	}

	public int getPhysicalSize() {
		return array.length;
	}

	public int getLogicalSize() {
//		for (int i = 0; i < array.length; I++) {
//			if (array[i] != null) {
//				cellsFilled++;
//			}
//		}

		for (Object e : array) {
			if (e != null) {
				cellsFilled++;
			}
		}
		return cellsFilled;
	}

	public void append(Object e) {
		array = Arrays.copyOf(array, array.length+1);
		array[array.length - 1] = e;
		length = array.length;
	}

	public void prepend(Object e) {
		array = Arrays.copyOf(array, array.length+1);
		array[0] = e;
		// shift everything else back
		for (int i = 1; i < array.length-1; i++) { // length-1 so no overflow
			array[i] = array[i + 1];
		}
		length = array.length;
	}

	
	public int doesExist(Object e) {
		int idx = 0;
		for (int i = 0; i < array.length; i++) {
			if (e.equals(array[i])) {
				idx++;
				return idx;
			}
		}
		return -1;
	}

	public int find(int idx) {
		return array[idx];
	}

	public int remove(int idx) {
			
	}


	public void display() {
		for (Object e : array) {
			System.out.println(e);
		}
	}
}
