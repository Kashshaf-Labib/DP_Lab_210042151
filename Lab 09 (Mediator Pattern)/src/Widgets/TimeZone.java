package Widgets;

import Interfaces.IWidget;
import java.util.UUID;
import Mediator.Mediator;

public class TimeZone implements IWidget {

    public String timezone;

    public String uniqueID;

    private Mediator mediator;

    public TimeZone(Mediator mediator){
        this.uniqueID = UUID.randomUUID().toString();
        this.mediator = mediator;
    }

    @Override
    public void update() {
        System.out.println("Time Zone has been updated.");
        mediator.notify(this.uniqueID);

    }
}
