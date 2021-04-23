package services;

import epic.ImageUrlBuilder;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.List;

public class EpicService {
    public static void openEpicImages() throws IOException {
        ImageUrlBuilder epicImageUrlBuilder = new ImageUrlBuilder();
        List<String> epicImages = epicImageUrlBuilder.getImageUrls();

        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            for (String url : epicImages) {
                System.out.println("Opening: " + url);
                Desktop.getDesktop().browse(URI.create(url));
            }
        }
    }
}
