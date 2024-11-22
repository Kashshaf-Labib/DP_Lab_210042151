package Widgets;

import Interfaces.IWidget;
import java.time.LocalTime;
import java.util.UUID;
import Mediator.Mediator;

public class CurrentTime implements IWidget {

    public LocalTime currentTime;

    public String uniqueID;

    private Mediator mediator;

    public CurrentTime(Mediator mediator) {
        this.uniqueID = UUID.randomUUID().toString();
        currentTime = LocalTime.now();
        this.mediator = mediator;
    }


    @Override
    public void update() {
        System.out.println("Current Time has been updated.");
        mediator.notify(uniqueID);
    }
}
