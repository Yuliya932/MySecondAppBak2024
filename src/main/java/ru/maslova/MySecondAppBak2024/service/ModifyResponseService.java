package ru.maslova.MySecondAppBak2024.service;

import org.springframework.stereotype.Service;
import ru.maslova.MySecondAppBak2024.model.Response;

@Service
public interface ModifyResponseService {

    Response modify (Response response);
}
