package api;

import com.fasterxml.jackson.core.type.TypeReference;
import entities.Epic;

public class EpicApiFetcher extends ApiFetcher {

    @Override
    public TypeReference<Epic[]> getTypeReference() {
        return new TypeReference<Epic[]>() {
        };
    }

    public String projectName() {
        return "epic";
    }
}
