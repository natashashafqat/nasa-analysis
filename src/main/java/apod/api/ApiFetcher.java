package apod.api;

import apod.entities.APOD;
import com.fasterxml.jackson.core.type.TypeReference;
import interfaces.Fetcher;

public class ApiFetcher extends Fetcher {

    @Override
    public TypeReference<APOD> getTypeReference() {
        return new TypeReference<APOD>() {
        };
    }

    public String projectName() {
        return "apod";
    }
}
