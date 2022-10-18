package manage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    WebDriver wd;

    UserHelper user;
    BoardHelper board;
    manage.CardHelper card;
    manage.ListHelper list;

    public void init(){
        wd = new ChromeDriver();
        logger.info("Test starts---->");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        wd.navigate().to("https://trello.com/");


        user = new UserHelper(wd);
        board = new BoardHelper(wd);
        list = new manage.ListHelper(wd);
        card= new manage.CardHelper(wd);

        user.login("evnikel@gmail.com","EB106201eb!");

    }

    public void quit(){
        wd.close();
        wd.quit();
    }

    public UserHelper getUser() {
        return user;
    }

    public BoardHelper getBoard(){
        return board;
    }

    public manage.CardHelper getCard() {
        return card;
    }

    public manage.ListHelper getList() {
        return list;
    }


}
