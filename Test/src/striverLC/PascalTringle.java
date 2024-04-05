package striverLC;


	import java.util.ArrayList;
	import java.util.List;

	public class PascalTringle {

		public List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> triangle = new ArrayList<>();

	        if (numRows == 0) {
	            return triangle;
	        }

	        List<Integer> firstRow = new ArrayList<>();
	        firstRow.add(1);
	        triangle.add(firstRow);

	        for (int rowNum = 1; rowNum < numRows; rowNum++) {
	            List<Integer> prevRow = triangle.get(rowNum - 1);
	            List<Integer> row = new ArrayList<>();

	            row.add(1);

	            for (int j = 1; j < rowNum; j++) {
	                row.add(prevRow.get(j - 1) + prevRow.get(j));
	            }

	            row.add(1);
	            triangle.add(row);
	        }

	        return triangle;
	    }

	    public static void main(String[] args) {
	    	PascalTringle pascalTriangle = new PascalTringle();
	        int numRows = 5;
	        List<List<Integer>> result = pascalTriangle.generate(numRows);

	        for (List<Integer> row : result) {
	            System.out.println(row);
	        }
	    }

}
