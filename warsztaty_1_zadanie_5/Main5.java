package warsztaty_1_zadanie_5;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main5 {
    public static void main(String args[]) {
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        try (PrintWriter wr = new PrintWriter("popular_words.txt")) {
            Document document = connect.get();
            Elements links = document.select("span.title");
            String str = new String();
            for (Element elem : links) {
                StringTokenizer st = new StringTokenizer(elem.text(), ",. !:?");
                while (st.hasMoreTokens()) {
                    str = st.nextToken();
                    if (str.length() > 3) {
                        System.out.println(str);
                        wr.println(str);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter wrf = new PrintWriter("filtered_popular_words.txt")) {
            File file = new File("popular_words.txt");
            Scanner scanner = new Scanner(file);
            String[] outWords = {"oraz", "ponieważ", "gdyż", "przed", "żeby", "mimo"};
            String strToFiltr = new String();
            boolean strOut = false;
            while (scanner.hasNextLine()) {
                strToFiltr = scanner.nextLine();
                for (int i = 0; i < outWords.length; i++) {
                    if (strToFiltr.equals(outWords[i])) {
                        strOut = true;
                        break;
                    }
                }
                if(!strOut) {
                    wrf.println(strToFiltr);
                }
                strOut = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
