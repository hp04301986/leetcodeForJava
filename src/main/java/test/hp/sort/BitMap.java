package test.hp.sort;

public class BitMap {
	byte[] bytes;
	
	public BitMap(int length) {
		int size = (length >>> 3) + 1;
		bytes = new byte[size];
	}
	
	private int getIndex(int index) {
		return index / 8;
	}
	
	private int getOffset(int index) {
		return index % 8;
	}
	
	private void set(int index) {
		bytes[getIndex(index)] = (byte)(bytes[getIndex(index)] | (1 << getOffset(index)));
	}
	
	private boolean test(int index) {
		return (bytes[getIndex(index)] & (1 << getOffset(index))) != 0;
	}
	
	public static void main(String[] args) {
		BitMap bitMap = new BitMap(2000000000);
		bitMap.set(100);
		System.out.println(bitMap.test(100));
		System.out.println(bitMap.test(101));
		System.out.println(bitMap.test(0));
	}
}
