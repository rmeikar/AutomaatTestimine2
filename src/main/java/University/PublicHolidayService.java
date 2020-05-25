package University;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PublicHolidayService {

    private static final String COUNTRY_CODE = "EE";
    private static final String API_URL = "https://date.nager.at/api/v2/PublicHolidays";

    private String baseUrl;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public PublicHolidayService() {
        this.baseUrl = API_URL;
    }

    public PublicHolidayService(String url) {
        this.baseUrl = url;
    }

    public List<ZonedDateTime> getPublicHolidays(int year) throws IOException, JSONException {
        return getPublicHolidays(year, baseUrl);
    }

    public List<ZonedDateTime> getPublicHolidays(int year, String apiUrl) throws IOException, JSONException {
        List<ZonedDateTime> result = new ArrayList<>();
        String composedUrl = apiUrl + "/" + year + "/" + COUNTRY_CODE;

        URL url = new URL(composedUrl);
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine;
        String dateString;

        while ((inputLine = in.readLine()) != null) {

            System.out.println(inputLine);

            JSONArray jsonArray = new JSONArray(inputLine);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                dateString = jsonObject.getString("date");
                LocalDate date = LocalDate.parse(dateString, formatter);
                ZonedDateTime zonedResult = date.atStartOfDay(ZoneId.of("UTC"));

                result.add(zonedResult);

                System.out.println(zonedResult);
            }
        }
        in.close();

        return result;

    }

/*
    public List<ZonedDateTime> getPublicHolidays(int year) {
        List<ZonedDateTime> result = new ArrayList<>();
        String composedUrl = baseUrl + "/" + year + "/" + COUNTRY_CODE;
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

        }
        return result;
    }

 */
    public int getWeekDayHolidayCount(ZonedDateTime startDay, ZonedDateTime finalDay) throws IOException, JSONException {
        startDay = startDay.minusDays(1); //includes start day
        finalDay = finalDay.plusDays(1); //includes final day
        int holidays = 0;
        for (int i = 0; i-1 < (finalDay.getYear() - startDay.getYear()); i++) {
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
