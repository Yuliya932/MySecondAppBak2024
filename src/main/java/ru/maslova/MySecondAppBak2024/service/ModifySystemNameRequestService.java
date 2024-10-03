package ru.maslova.MySecondAppBak2024.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.maslova.MySecondAppBak2024.model.Request;
import ru.maslova.MySecondAppBak2024.model.Systems;

import static ru.maslova.MySecondAppBak2024.model.Systems.SRVC;

@Service
public class ModifySystemNameRequestService implements ModifyRequestService{

    @Override
    public void modify(Request request){
        request.setSystemName(SRVC);
        request.setSource("Service_1");
        request.setStart(request.getStart());

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        new RestTemplate().exchange("http://localhost:8084/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>() {
                });
    }
}
