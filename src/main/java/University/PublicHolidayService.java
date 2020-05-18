package University;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PublicHolidayService {

    private static final String COUNTRY_CODE = "EE";
    private static final String API_URL = "https://date.nager.at/api/v2/PublicHolidays/";


    public List<ZonedDateTime> getPublicHolidays(int year) {
        List<ZonedDateTime> result = new ArrayList<>();
        String composedUrl = API_URL + year + "/" + COUNTRY_CODE;
        try {
            URL url = new URL(composedUrl);
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine = in.readLine();
            in.close();
            List<HashMap> itemList = new Gson().fromJson(inputLine, new TypeToken<List<HashMap>>() {}.getType());

            for (HashMap value : itemList) { result.add(Utils.dateToTypeZoneDateTime(value.get("date").toString())); }

        } catch (Exception ex) {
            System.out.println("Error with reading holidays");
            return null;
        }
        return result;
    }
    public int getWeekDayHolidayCount(ZonedDateTime startDay, ZonedDateTime finalDay) {
        startDay = startDay.minusDays(1); //includes start day
        finalDay = finalDay.plusDays(1); //includes final day
        int holidays = 0;
        for (int i = 0; i < (finalDay.getYear() - startDay.getYear()); i++) {
            for (ZonedDateTime date : getPublicHolidays(startDay.plusYears(i).getYear())) {
                if (date.toLocalDate().isAfter(startDay.toLocalDate())
                        && ((date.toLocalDate()).isBefore(finalDay.toLocalDate()))
                        && ((date.getDayOfWeek().getValue()) != 6)
                        && ((date.getDayOfWeek().getValue()) != 7)) {
                    holidays++;
                }
            }
        }
        return holidays;
    }

}
