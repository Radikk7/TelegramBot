import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.sound.sampled.Line;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class News {
    public static void main(String[] args) throws IOException {
      //newsListParsing().stream().forEach(x-> System.out.println(x));
    }


    public static String newsListParsing() throws IOException {
        String link = "https://lenta.ru/";
        Document doc = Jsoup.connect(link).maxBodySize(0).get();
        List<String> stringList = new ArrayList<>();
        Elements lines = doc.getElementsByClass("topnews");
        for (Element i: lines) {
            String [] array =  i.text().split("\\d\\d:\\d\\d");
             //System.out.println(array[2]);
            for (String j:array) {
                stringList.add(j);
            }
        }
        String answer = convector(stringList);
        return answer;
    }
    public static String convector(List<String>stringList){
        String stringNews = "";
        for (int i =0; i < stringList.size() -1; i++){

            stringNews += stringList.get(i) + "\n" + "\n";
        }
        return stringNews;
    }


}
