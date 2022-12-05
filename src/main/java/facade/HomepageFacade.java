package facade;

import pages.HomePage;

public class HomepageFacade {

    public HomePage nagivateToHomePage(){
       return new HomePage().openHomepage("");
    }

    public HomePage getHomePage(){
        return new HomePage();
    }

}
