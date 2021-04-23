package services;

import api.APODApiFetcher;
import entities.APOD;
import config.Config;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class APODService {
    static APODApiFetcher apiFetcher = new APODApiFetcher();
    static Config config = new Config();

    public static void getMediaOfTheDay() throws IOException {
        APOD data = (APOD) apiFetcher.fetchData(config);
        System.out.println("Title: " + data.title);
        System.out.println("Explanation: " + data.explanation);

        boolean canOpenInBrowser = Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE);

        if (canOpenInBrowser) {
            System.out.println("Opening media: " + data.url);
            Desktop.getDesktop().browse(URI.create(data.url));
        }
    }
}
