import enums.Collection;
import enums.ImageType;
import entities.ImageUrl;
import org.junit.Test;
import utils.EpicImageUrlBuilder;

import java.io.IOException;

import static org.junit.Assert.*;

public class ImageUrlBuilderTest {
    EpicImageUrlBuilder imageUrlBuilder = new EpicImageUrlBuilder();
    @Test
    public void itShouldExtractDateFromImageName() {
        String imageName = "epic_RGB_20151031003633_01";
        String result = imageUrlBuilder.getDateFromImageName(imageName);
        assertEquals("20151031", result);
    }

    @Test
    public void itShouldBuildTheCorrectUrl() throws IOException {
        String imageName = "epic_RGB_20151031003633_01";

        ImageUrl imageUrl = new ImageUrl();
        imageUrl.setImageName(imageName);
        imageUrl.setImageType(ImageType.png);
        imageUrl.setCollection(Collection.natural);
        imageUrl.setDate("20151031");

        String expected = "https://epic.gsfc.nasa.gov/archive/natural/2015/10/31/png/epic_RGB_20151031003633_01.png";
        String result = imageUrlBuilder.buildUrl(imageUrl, imageName);
        assertEquals(expected, result);
    }
}
