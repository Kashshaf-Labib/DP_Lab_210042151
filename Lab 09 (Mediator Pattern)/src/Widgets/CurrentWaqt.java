package Widgets;

import Interfaces.IWidget;

import java.time.LocalTime;
import java.util.UUID;
import Mediator.Mediator;

public class CurrentWaqt implements IWidget {

    public String currentWaqt;

    public String uniqueID;

    private Mediator mediator;

    public CurrentWaqt(Mediator mediator) {
        this.uniqueID = UUID.randomUUID().toString();
        //currentWaqt = LocalTime.now().toString();
        this.mediator = mediator;
    }

    @Override
    public void update() {
        System.out.println("Current Waqt has been updated.");
        mediator.notify(uniqueID);
    }
}
