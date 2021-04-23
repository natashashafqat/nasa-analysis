package epic;

import epic.api.ApiFetcher;
import epic.enums.Collection;
import epic.enums.ImageType;
import epic.entities.Epic;
import epic.entities.ImageUrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImageUrlBuilder {
    Config config = new Config();
    Integer LENGTH_OF_DATE = 8;
    ApiFetcher apiFetcher = new ApiFetcher();

    public List<String> getImageUrls() throws IOException {
        Epic[] epicData = (Epic[]) apiFetcher.fetchData(config);
        List<String> imageUrls = new ArrayList<String>(epicData.length);

        for (Epic epicImage : epicData) {
            String imageName = epicImage.image;
            String date = getDateFromImageName(imageName);

            ImageUrl imageBuilder = new ImageUrl();
            imageBuilder.setDate(date);
            imageBuilder.setCollection(Collection.natural);
            imageBuilder.setImageType(ImageType.png);
            imageBuilder.setImageName(imageName);

            String imageUrl = buildUrl(imageBuilder, imageName);
            imageUrls.add(imageUrl);
        }

        return imageUrls;
    }

    public String buildUrl(ImageUrl imageUrl, String imageName) throws IOException {
        Properties properties = config.getProperties(apiFetcher.projectName());
        String baseUrl = properties.getProperty("BASE_URL");
        StringBuilder fullUrl = new StringBuilder();

        fullUrl
            .append(baseUrl)
            .append(imageUrl.getCollection()).append('/')
            .append(imageUrl.getYear()).append('/')
            .append(imageUrl.getMonth()).append('/')
            .append(imageUrl.getDay()).append('/')
            .append(imageUrl.getImageType()).append('/')
            .append(imageName).append('.')
            .append(imageUrl.getImageType());

        return fullUrl.toString();
    }

    public String getDateFromImageName(String imageName) {
        int firstUnderscore = imageName.indexOf('_');
        int secondUnderscore = imageName.indexOf('_', firstUnderscore + 1);
        return imageName.substring(secondUnderscore + 1, secondUnderscore + LENGTH_OF_DATE + 1);
    }
}
