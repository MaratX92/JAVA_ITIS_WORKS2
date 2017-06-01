package models;

import java.util.List;

/**
 * Created by Marat on 31.05.2017.
 */
public class CountryResponse {
    private List<Country> response;
    public CountryResponse() {
    }

    public List<Country> getResponse() {
        return response;
    }

    public void setResponse(List<Country> response) {
        this.response = response;
    }
}

