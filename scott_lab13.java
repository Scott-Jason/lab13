import java.util.ArrayList;

public class scott_lab13 {
	public ArrayList<Integer> myList = new ArrayList<Integer>();

	public static void main(String[] args) {
		scott_lab13 ok = new scott_lab13();
		ok.readData(args[0]);
	}

	public void readData(String filename){
		try {
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
			String inn;
			while((inn = input.readLine()) != null){
				myList.add(Integer.parseInt(inn));
			}
		}
		catch(Exception e) {
		}
	}
	
	public long getTotalCount(){
		return myList.stream().count();
	}
	
	public long getOddCount() {
		return myList.stream().filter(num -> num % 2 == 1).count();
	}
	
	public long getEvenCount() {
		return myList.stream().filter(num -> num % 2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount() {
		return myList.stream().distinct().filter(x -> x > 5).count();
	}
	
	public Integer[] getResult1() {
		return myList.stream().filter(x -> x % 2 == 0).filter(x -> x > 5).filter(x -> x < 50).sorted().toArray(Integer[]::new);
	}
	
	public Integer[] getResult2() {
		return myList.stream().limit(50).map(x -> x*x).map(x -> x*3).toArray(Integer[]::new);
	}
	
	public Integer[] getResult3() {
		return myList.stream().filter(x -> x % 2 == 1).map(x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}
}
