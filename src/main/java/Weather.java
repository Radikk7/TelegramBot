import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Weather {
    public static void main(String[] args) throws IOException {
        System.out.println(weatherParsing());
    }
    public static String weatherParsing() throws IOException {
        String link = "https://weather.rambler.ru/world/germaniya/";
        Document doc = Jsoup.connect(link).maxBodySize(0).get();
        List<String> stringList = new ArrayList<>();
        Elements lines = doc.getElementsByClass("K5tk");
        for (Element i: lines) {
           // String [] array =  i.text().split("\\d\\d:\\d\\
          //  String [] array =  i.text().;
            stringList.add(i.text());
            System.out.println(i.text());
            //System.out.println(array[2]);
          //  for (String j:array) {
          //      stringList.add(j);
          //  }

        }
        String answer = convector(stringList);
        return answer;
    }
    public static List<String> listOfCities() throws IOException {
        String link = "https://weather.rambler.ru/world/germaniya/";
        Document doc = Jsoup.connect(link).maxBodySize(0).get();
        List<String> stringList = new ArrayList<>();
        Elements lines = doc.getElementsByClass("K5tk");
        for (Element i: lines) {
            // String [] array =  i.text().split("\\d\\d:\\d\\
            //  String [] array =  i.text().;
            stringList.add(i.text());
        }
        return stringList;
    }





    public static String convector(List<String>stringList){
        String stringNews = "";
        for (int i =0; i < stringList.size() -1; i++){

            stringNews += stringList.get(i) + "\n" + "\n";
        }
        return stringNews;
    }
    public static String citySearch(List<String>stringList,String cityName){
        for (String i: stringList) {
            if (i.contains(cityName)){
                return i;
            }
        }
        return "Введите другой город , такого нет в списке";
    }



}
