package lab2ass;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class GenerateInvoice {
	 public static void main(String[] args) {

	        generateStudentInvoice();
	    }
	 public static void  generateStudentInvoice() {
		 PrintWriter writer = null;
		try {
			writer = new PrintWriter("the-file-name.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 writer.println("The first line");
		 writer.println("The second line");
		 writer.close();

	 }
}
