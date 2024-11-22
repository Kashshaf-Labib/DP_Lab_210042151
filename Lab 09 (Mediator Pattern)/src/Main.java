import Widgets.*;
import Mediator.Mediator;

public class Main {
    public static void main(String[] args) {

        Mediator mediator = new Mediator();

        CurrentTime currentTime = new CurrentTime(mediator);
        CurrentWaqt currentWaqt = new CurrentWaqt(mediator);
        Location location = new Location(mediator);
        NextPrayer nextPrayer = new NextPrayer(mediator);
        PrayerTimeSettings prayerTimeSettings = new PrayerTimeSettings(mediator);
        PrayerTimeTable prayerTimeTable = new PrayerTimeTable(mediator);
        TimeZone timeZone = new TimeZone(mediator);
        WaqtTimeTable waqtTimeTable = new WaqtTimeTable(mediator);

        mediator.addWidgets(currentTime, currentWaqt, location, nextPrayer, prayerTimeSettings, prayerTimeTable, timeZone, waqtTimeTable);
        timeZone.update();

    }
}