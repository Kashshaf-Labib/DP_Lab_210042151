package Widgets;

import Interfaces.IWidget;
import java.util.UUID;
import Mediator.Mediator;



public class WaqtTimeTable implements IWidget {

    public String waqtTimeTable;
    public String uniqueID;

    private Mediator mediator;

    public WaqtTimeTable(Mediator mediator)
    {
        this.uniqueID = UUID.randomUUID().toString();
        this.mediator = mediator;
    }

    @Override
    public void update() {
        System.out.println("Waqt Time Table has been updated.");
        mediator.notify(uniqueID);
    }
}
