package Mediator;

import Interfaces.IWidget;
import Widgets.*;

import java.util.HashMap;
import java.util.List;

public class Mediator {

    private HashMap<String, List<IWidget>> dependency= new HashMap<>();

    public CurrentTime currentTime;
    public CurrentWaqt currentWaqt;
    public Location location;
    public NextPrayer nextPrayer;

    public PrayerTimeSettings prayerTimeSettings;

    public PrayerTimeTable prayerTimeTable;

    public TimeZone timeZone;

    public WaqtTimeTable waqtTimeTable;

    public void addWidgets(CurrentTime currentTime, CurrentWaqt currentWaqt, Location location, NextPrayer nextPrayer, PrayerTimeSettings prayerTimeSettings, PrayerTimeTable prayerTimeTable, TimeZone timeZone, WaqtTimeTable waqtTimeTable){
        this.currentTime = currentTime;
        this.currentWaqt = currentWaqt;
        this.location = location;
        this.nextPrayer = nextPrayer;
        this.prayerTimeSettings = prayerTimeSettings;
        this.prayerTimeTable = prayerTimeTable;
        this.timeZone = timeZone;
        this.waqtTimeTable = waqtTimeTable;
        this.register();
    }

    public void register()
    {
        dependency.put(timeZone.uniqueID, List.of(currentTime,waqtTimeTable));
        dependency.put(location.uniqueID, List.of(waqtTimeTable));
        dependency.put(prayerTimeSettings.uniqueID, List.of(prayerTimeTable));
        dependency.put(currentTime.uniqueID, List.of(nextPrayer,currentWaqt));
        dependency.put(waqtTimeTable.uniqueID, List.of(currentWaqt));
        dependency.put(prayerTimeTable.uniqueID, List.of(nextPrayer));
        dependency.put(currentWaqt.uniqueID,List.of());
        dependency.put(nextPrayer.uniqueID,List.of());
    }

    public void notify(String uniqueID){
        for (IWidget widget : dependency.get(uniqueID)) {
            widget.update();
        }
    }


    public void update(String uniqueID){
        for (IWidget widget : dependency.get(uniqueID)) {
            widget.update();
        }
    }

}
