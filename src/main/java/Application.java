import services.APODService;
import services.EpicService;

import java.io.IOException;
import java.util.Scanner;

public class Application {

    public static void main(String args[]) throws IOException {
        System.out.println(
            "Select the NASA content you wish to view." +
                " Enter 'apod' for Media of the Day, or 'epic' to open multiple photos of Earth in your browser:");

        Scanner scanner = new Scanner(System.in);
        String contentSelector = scanner.next();

        switch (contentSelector) {
            case "epic":
                EpicService.openEpicImages();
                break;
            case "apod":
                APODService.getMediaOfTheDay();
                break;
        }
    }
}
