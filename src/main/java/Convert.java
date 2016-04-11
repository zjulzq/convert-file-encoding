import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Convert {
	private static String SOURCE_ENCODING = "GBK";
	private static String TARGET_ENCODING = "UTF-8";

	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println("please specify the source file name and target file name");
			return;
		} else if (args.length == 1) {
			System.out.println("please specify the target file name");
			return;
		}

		String sourceFileName = args[0];
		String targetFileName = args[1];
		System.out.println("the source file name is " + sourceFileName);
		System.out.println("the target file name is " + targetFileName);
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(sourceFileName), SOURCE_ENCODING));
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(targetFileName), TARGET_ENCODING))) {

			String line = reader.readLine();
			while (line != null) {
				writer.write(line);
				writer.newLine();
				line = reader.readLine();
			}
			System.out.println("convert successfully");
		}
	}

}
