package ru.maslova.MySecondAppBak2024.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.maslova.MySecondAppBak2024.exception.UnsupportedCodeException;
import ru.maslova.MySecondAppBak2024.exception.ValidationFailedException;
import ru.maslova.MySecondAppBak2024.model.*;

import ru.maslova.MySecondAppBak2024.service.*;
import ru.maslova.MySecondAppBak2024.util.DateTimeUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;

    private final ModifyResponseService modifyResponseService;

    private final ModifyRequestService modifyRequestService;

    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                        ModifyRequestService modifyRequestService) {
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult) {

        long start = System.currentTimeMillis();

        request.setStart(start);

        log.info("request: {}", request);

        String uid = request.getUid();

        CalculateAnnualBonusService calculateAnnualBonusService = new CalculateAnnualBonusService();
        CalculateQuartBonusService calculateQuartBonusService = new CalculateQuartBonusService();

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemName(request.getSystemName())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .source(request.getSource())
                .annualBonus(calculateAnnualBonusService.calculate(Positions.valueOf(request.getPosition()), request.getSalary(), request.getBonus(), request.getWorkDays()))
                .quartBonus(calculateQuartBonusService.calculate(Positions.valueOf(request.getPosition()), request.getSalary(), request.getBonus(), request.getWorkDaysQuartIII()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .start(start)
                .build();

        log.info("response: {}", response);

        try {
            validationService.isValid(bindingResult);
        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.error("response: {}", response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.error("response: {}", response);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (uid.equals("123")) {
            try {
                throw new UnsupportedCodeException("Не поддерживаемая ошибка");
            } catch (UnsupportedCodeException e) {
                response.setCode(Codes.FAILED);
                response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
                response.setErrorMessage(ErrorMessages.UNSUPPORTED);
                log.error("response: {}", response);
            }
        }
        modifyRequestService.modify(request);
        modifyResponseService.modify(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}



