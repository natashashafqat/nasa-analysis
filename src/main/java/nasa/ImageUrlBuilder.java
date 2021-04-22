package nasa;

import api.ApiFetcher;
import enums.Collection;
import enums.ImageType;
import entities.Epic;
import entities.ImageUrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageUrlBuilder {
    Integer LENGTH_OF_DATE = 8;

    public List<String> getImageUrls() throws IOException {
        ApiFetcher apiFetcher = new ApiFetcher();
        Epic[] epicData = apiFetcher.fetchData();
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

    public String buildUrl(ImageUrl imageUrl, String imageName) {
        String baseUrl = "https://epic.gsfc.nasa.gov/archive/";
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
