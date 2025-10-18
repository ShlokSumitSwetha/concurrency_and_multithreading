package Complete_Concurrent_Collections.structured_concurrency.loom.util;

import static Complete_Concurrent_Collections.structured_concurrency.loom.util.ThreadUtil.logAndWait;

public class WeatherUtil {

    public static Weather getWeatherFromSource1(String city) {
        logAndWait("getWeatherFromSource1");
        return new Weather("25 C");
    }

    public static Weather getWeatherFromSource2(String city) {
        logAndWait("getWeatherFromSource2");
        return new Weather("26 C");
    }

    public static Weather getWeatherFromSource3(String city) {
        logAndWait("getWeatherFromSource3");
        return new Weather("27 C");
    }

    public record Weather(String temperature) {}

}