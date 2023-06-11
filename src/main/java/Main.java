
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


import javax.validation.groups.Default;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
public class Main {
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
         telegramBotsApi.registerBot(new FirstBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
