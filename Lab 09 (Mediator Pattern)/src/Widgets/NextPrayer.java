package Widgets;

import Interfaces.IWidget;
import java.util.UUID;
import Mediator.Mediator;

public class NextPrayer implements IWidget {

    public String nextPrayer;

    public String uniqueID;

    private Mediator mediator;

    public NextPrayer(Mediator mediator) {
        this.uniqueID = UUID.randomUUID().toString();
        this.mediator = mediator;
    }

    @Override
    public void update() {
        System.out.println("Next Prayer has been updated.");
        mediator.notify(uniqueID);
    }
}
