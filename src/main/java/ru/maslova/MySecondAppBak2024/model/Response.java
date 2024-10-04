package ru.maslova.MySecondAppBak2024.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    /***
     * Уникальный идентификатор сообщение
     */
    private String uid;
    /***
     * Уникальный идентификатор операции
     */
    private String operationUid;
    /***
     * Имя системы отправителя
     */
    private Systems systemName;
    /***
     * Время создания сообщения
     */
    private String systemTime;
    /***
     * Наименование ресурса
     */
    private String source;
    /***
     * Код операции
     */
    private Codes code;
    /***
     * Квартальный бонус
     */
    private Double quartBonus;
    /***
     * Годовой бонус
     */
    private Double annualBonus;
    /***
     * Код ошибки
     */
    private ErrorCodes errorCode;
    /***
     * Сообщение об ошибке
     */
    private ErrorMessages errorMessage;
    /***
     * Время начала в милисекундах
     */
    private long start;

}
