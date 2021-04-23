package api;

import entities.APOD;
import com.fasterxml.jackson.core.type.TypeReference;

public class APODApiFetcher extends ApiFetcher {

    @Override
    public TypeReference<APOD> getTypeReference() {
        return new TypeReference<APOD>() {
        };
    }

    public String projectName() {
        return "apod";
    }
}
