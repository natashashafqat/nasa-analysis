import apod.api.ApiFetcher;
import apod.entities.APOD;
import epic.Config;
import epic.ImageUrlBuilder;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.List;

public class Application {
    public static void main(String args[]) throws IOException {
        ApiFetcher apiFetcher = new ApiFetcher();
        Config config = new Config();

        ImageUrlBuilder epicImageUrlBuilder = new ImageUrlBuilder();
        List<String> epicImages = epicImageUrlBuilder.getImageUrls();
        openEpicImages(epicImages);

        APOD data = (APOD) apiFetcher.fetchData(config);
        System.out.println(data.explanation);
    }

    private static void openEpicImages(List<String> imageUrls) throws IOException {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            for (String url : imageUrls) {
                System.out.println("Opening: " + url);
                Desktop.getDesktop().browse(URI.create(url));
            }
        }
    }
}
