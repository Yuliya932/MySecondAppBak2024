package ru.maslova.MySecondAppBak2024.service;

import org.springframework.stereotype.Service;
import ru.maslova.MySecondAppBak2024.model.Request;

@Service
public interface ModifyRequestService {
    void modify(Request request);
}
