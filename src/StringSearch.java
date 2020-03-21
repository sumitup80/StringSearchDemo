import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StringSearch {

	public static void main(String[] args) {
		int count = 0, countBuffer = 0, countLine = 0;
		String lineNumber = "";
		String filePath = "./TestFile.txt";
		 
		BufferedReader br;
		String inputSearch = "Alpha";
		String line = "";

		try {
			InputStream in = StringSearch.class.getResourceAsStream("TestFile.txt");
			br = new BufferedReader(new InputStreamReader(in));
			try {
				while ((line = br.readLine()) != null) {
					countLine++;
					String[] words = line.split(" ");

					for (String word : words) {
						if (word.equals(inputSearch)) {
							count++;
							countBuffer++;
						}
					}

					if (countBuffer > 0) {
						countBuffer = 0;
						lineNumber += countLine + ",";
					}

				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		finally{
			// TODO Auto-generated catch block
		}

		System.out.println("Number of time string found--" + count);
		System.out.println("String found at line number--" + lineNumber);
	}
}
