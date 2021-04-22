package entities;

import enums.Collection;
import enums.ImageType;

public class ImageUrl {
    public Collection collection;
    public String date;
    public ImageType imageType;
    public String imageName;

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getYear() {
        return this.date.substring(0, 4);
    }

    public String getMonth() {
        return this.date.substring(4, 6);
    }

    public String getDay() {
        return this.date.substring(6);
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public ImageType getImageType() {
        return imageType;
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
    }
}
