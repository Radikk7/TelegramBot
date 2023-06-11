import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FirstBot extends TelegramLongPollingBot {
    int count = 0;

    @Override
    public String getBotUsername() {
        return "moin77_bot";
    }

    @Override
    public String getBotToken() {
        return "6118636277:AAGCNmY463ZZPgTQjxo8vjapgZ9wxk3dgC8";
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        Long id = update.getMessage().getChatId();
        sendMessage.setChatId(String.valueOf(id));
        String message_text = update.getMessage().getText();


        if (message_text.equals("/time")) {
            Date date = new Date();
            // sendMessage.setText("Time Hamburg");
            sendMessage.setText(String.valueOf(date));
        } else if (message_text.equals("/news")) {
            try {
                String answer = News.newsListParsing();//

                sendMessage.setText(answer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(message_text);
            System.out.println(id);
        } else if (message_text.equals("/weather") && count == 0) {
            sendMessage.setText("Введите город");
            count = count + 1;


            //    try {
            //    String answer = Weather.weatherParsing();
            //   sendMessage.setText(answer);
            //  } catch (IOException e) {
            //       e.printStackTrace();
            // }
        } else if (count > 0) {
            List<String> stringListCities = new ArrayList<>();
            try {
                stringListCities = Weather.listOfCities();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String answer = Weather.citySearch(stringListCities, message_text);
            sendMessage.setText(answer);
        }

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
