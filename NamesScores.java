import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NamesScores {
	public static void main(String[] args) {
		try (BufferedReader sc = new BufferedReader(new FileReader("p022_names.txt"))) {
			String line = sc.readLine();
			String[] arr = line.split("[\\\"\\,\\\"]");//"\\"|\\"\,|\,"			"\\\"|\\,"       "\\\"|\\\"\\,|\\,"				"\\,"		[\"\,\"]
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		} catch (IOException e) {
			//e.printStackTrace();	
		} 
	}

	private static void ordena(String arr[], int low, int high){
		if (low < high) {
			/* pi is partitioning index, arr[pi] is now at right place */
			int pivot = partition(arr, low, high);
			ordena(arr, low, pivot - 1);  // Before pi
			ordena(arr, pivot + 1, high); // After pi
		}
	}

	private static int partition(String[] arr, int low, int high) {
			// pivot (Element to be placed at right position)
		String pivot = arr[high];  

		int i = (low - 1);  // Index of smaller element and indicates the 
		// right position of pivot found so far

		for (int j = low; j <= high - 1; j++) {
			// If current element is smaller than the pivot
			if (/* arr[j] < pivot */ 1 < 2) {//fazer funcao para comparar as Strings
				i++;    // increment index of smaller element
				swap(arr, i, j); //arr[i] and arr[j]
			}
		}
		// swap arr[i + 1] and arr[high])
		return (i + 1);
	}

	private static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static int compara(String arr_index, String pivot){
		return 0;
	}
}
