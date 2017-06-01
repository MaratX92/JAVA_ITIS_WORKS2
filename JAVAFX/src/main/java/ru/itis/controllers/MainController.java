
package ru.itis.controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import models.CountryResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

/**

 * 26.05.2017

 * MainController

 *

 * @author Ayupov Ayaz (First Software Engineering Platform)

 * @version v1.0

 */

public class MainController {
@FXML
private ListView text_list;
@FXML
private Button button;

@FXML
TextField ins_id;
@FXML

    public void initialize(){

        button.setOnAction(event -> {

            RestTemplate template = new RestTemplate();

            List<HttpMessageConverter<?>> converters = new ArrayList<>();

            converters.add(new MappingJackson2HttpMessageConverter());

            template.setMessageConverters(converters);

            String country_id = ins_id.getText();

            CountryResponse response = template.getForObject("https://api.vk.com/method/database.getCities?country_id="

                            + country_id,

                    CountryResponse.class);

            text_list.getItems().clear();

            for (int i = 0; i < response.getResponse().size(); i++){

                text_list.getItems().addAll(response.getResponse().get(i).getTitle());

            }

        });

    }

}

