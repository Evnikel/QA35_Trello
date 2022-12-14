package tests;

import manage.MyDataProvider;
import model.Card;
import org.testng.annotations.Test;

public class CardCreation extends TestBase {

    @Test(dataProvider = "dataCardCSV",dataProviderClass = MyDataProvider.class, groups = "group")
    public void cardCreation(Card card) {
        //Card card = Card.builder().cardName("new test QA35").color("green").build();
        app.getBoard().pause(2000);
        app.getBoard().clickOnTheFirstBoard();
        app.getList().createList("testqa35");
        app.getCard().initCardCreation();
        app.getCard().fillCreationForm(card);
        app.getCard().submitCardCreation();
        app.getBoard().returnToHomePage();
    }

    @Test(enabled = false)
    public void cardCreation2(Card card) {
        //Card card = Card.builder().cardName("new test QA35").color("green").build();
        app.getBoard().clickOnTheFirstBoard();
        app.getList().createList("testqa35");
        app.getCard().initCardCreation();
        app.getCard().fillCreationForm(card);
        app.getCard().submitCardCreation();
        app.getBoard().returnToHomePage();
    }
}
