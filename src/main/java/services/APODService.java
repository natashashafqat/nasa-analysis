package services;

import api.APODApiFetcher;
import entities.APOD;
import config.Config;

import java.io.IOException;

public class APODService {
    static APODApiFetcher apiFetcher = new APODApiFetcher();
    static Config config = new Config();

    public static void getPictureOfTheDay() throws IOException {
        APOD data = (APOD) apiFetcher.fetchData(config);
        System.out.println(data.explanation);
    }
}
