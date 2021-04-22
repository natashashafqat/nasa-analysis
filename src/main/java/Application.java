import nasa.ImageUrlBuilder;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String args[]) throws IOException {
        ImageUrlBuilder imageUrlBuilder = new ImageUrlBuilder();
        List<String> imageUrls = imageUrlBuilder.getImageUrls();
        for (String url : imageUrls) {
            System.out.println(url);
        }
    }
}
