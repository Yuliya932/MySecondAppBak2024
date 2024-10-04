package ru.maslova.MySecondAppBak2024.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    /***
     * Уникальный идентификатор сообщения
     */
    @NotBlank
    @Size (max = 32)
    private String uid;

    /***
     * Уникальный идентификатор операции
     */
    @NotBlank
    @Size (max = 32)
    private String operationUid;

    /***
     * Имя системы отправителя
     */
    private Systems systemName;

    /***
     * Время создания сообщения
     */
    @NotBlank
    private String systemTime ;

    /***
     * Наименование ресурса
     */
    private String source;
    /***
     * Должность
     */
    private String position;

    /***
     * Оклад
     */
    private Integer salary;

    /***
     * Коэффициент бонуса
     */
    private Double bonus;

    /***
     * Количество отработанных дней для годового бонуса
     */
    private Integer workDays;

    /***
     * Количество отработанных дней для квартального бонуса
     */
    private Integer workDaysQuartIII;

    /***
     * Уникальный идентификатор коммуникации
     */
    @Min(1)
    @Max(100000)
    private Integer communicationId;

    /***
     * Уникальный идентификатор шаблона
     */
    private Integer templateId;

    /***
     * Код продукта
     */
    private Integer productCode;

    /***
     * Смс код
     */
    private Integer smsCode;

    /***
     * Время начала в милисекундах
     */
    private long start;

}
