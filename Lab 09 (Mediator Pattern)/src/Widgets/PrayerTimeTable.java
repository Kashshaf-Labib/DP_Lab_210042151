package Widgets;

import Interfaces.IWidget;
import java.util.UUID;
import Mediator.Mediator;

public class PrayerTimeTable implements IWidget {
    public String prayerTimeTable;
    private Mediator mediator;
    public String uniqueID;

    public PrayerTimeTable(Mediator mediator) {
        this.uniqueID = UUID.randomUUID().toString();
        prayerTimeTable = "Fajr: 5:00 AM, Dhuhr: 1:00 PM, Asr: 5:00 PM, Maghrib: 7:00 PM, Isha: 9:00 PM";
        this.mediator = mediator;
    }
    @Override
    public void update() {
        System.out.println("Prayer Time Table has been updated.");
        mediator.notify(uniqueID);
    }
}
