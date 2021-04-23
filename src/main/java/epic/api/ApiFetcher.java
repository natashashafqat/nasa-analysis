package epic.api;

import com.fasterxml.jackson.core.type.TypeReference;
import epic.entities.Epic;
import interfaces.Fetcher;

public class ApiFetcher extends Fetcher {

    @Override
    public TypeReference<Epic[]> getTypeReference() {
        return new TypeReference<Epic[]>() {
        };
    }

    public String projectName() {
        return "epic";
    }
}
