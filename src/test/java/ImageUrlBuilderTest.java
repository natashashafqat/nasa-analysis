import enums.Collection;
import enums.ImageType;
import entities.ImageUrl;
import nasa.ImageUrlBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImageUrlBuilderTest {
    ImageUrlBuilder imageUrlBuilder = new ImageUrlBuilder();
    @Test
    public void itShouldExtractDateFromImageName() {
        String imageName = "epic_RGB_20151031003633_01";
        String result = imageUrlBuilder.getDateFromImageName(imageName);
        assertEquals("20151031", result);
    }

    @Test
    public void itShouldBuildTheCorrectUrl() {
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
