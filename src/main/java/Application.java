import epic.ImageUrlBuilder;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.List;

public class Application {
    public static void main(String args[]) throws IOException {
        ImageUrlBuilder imageUrlBuilder = new ImageUrlBuilder();
        List<String> epicImages = imageUrlBuilder.getImageUrls();
        openEpicImages(epicImages);
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
