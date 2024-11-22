package Widgets;

import Interfaces.IWidget;
import java.util.UUID;
import Mediator.Mediator;
public class PrayerTimeSettings implements IWidget {

    public String prayerTimeSettings;

    public String uniqueID;

    private Mediator mediator;

    public PrayerTimeSettings(Mediator mediator){
        this.uniqueID = UUID.randomUUID().toString();
        this.mediator = mediator;
    }


    @Override
    public void update() {
        System.out.println("Prayer Time Settings has been updated.");
        mediator.notify(uniqueID);
    }
}
