
import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login extends TestBase {



    @BeforeTest
    public void preConditions() {
        if (app.getUser().isLogged()) {
            app.getUser().logOut();
        }
    }



    @Test
    public void loginPositive1() {
        //User user = new User().withEmail("evnikel@gmail.com").withPassword("EB106201!");

        User user = User.builder()
                .email("evnikel@gmail.com")
                .password("EB106201!")
                .build();
        logger.info("Test login positive 1"+user.getEmail()+ ""+user.getPassword());
        app.getUser().initLogin();
        app.getUser().pause(2000);
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(2000);


        Assert.assertTrue(app.getUser().isLogged());

    }

    @Test
    public void loginPositive2() {

        app.getUser().initLogin();
        app.getUser().pause(2000);
        app.getUser().fillLoginForm2("evnikel@gmail.com","EB106201eb!");
        app.getUser().submitLogin();
        app.getUser().pause(2000);
        logger.info("Logged ----");


        Assert.assertTrue(app.getUser().isLogged());


    }

}

