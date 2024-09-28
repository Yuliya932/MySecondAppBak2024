package ru.maslova.MySecondAppBak2024.service;

import org.springframework.validation.BindingResult;
import ru.maslova.MySecondAppBak2024.exception.ValidationFailedException;

public interface ValidationService {

    void isValid (BindingResult bindingResult) throws ValidationFailedException;

}
