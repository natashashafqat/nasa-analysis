package services;

import apod.api.ApiFetcher;
import apod.entities.APOD;
import epic.Config;

import java.io.IOException;

public class APODService {
    static ApiFetcher apiFetcher = new ApiFetcher();
    static Config config = new Config();

    public static void getPictureOfTheDay() throws IOException {
        APOD data = (APOD) apiFetcher.fetchData(config);
        System.out.println(data.explanation);
    }
}
