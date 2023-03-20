# Тестовое задание
## Инвестиционная оценка портфеля

### Начальные условия

Модели данных:
1) Bond (облигации) и Stock (акции) - инвестиционные инструменты,
2) Position - позиция в инвестиционном портфеле,
3) Portfolio - инвестиционный портфель.

DataGateway - интерфейс для получения данных из хранилища данных.
MemoryDataGateway - реализация DataGateway, использующая оперативную память.

### Задача

Необходимо оценить инвестиционную привлекательность портфеля.

### Пояснения

Инвестиционная привлекательность - иначе говоря прибыльность портфеля.
Для расчета прибыльности портфеля необходимо расчитать абсолютные прибыли каждой позиции и просуммировать их.
Интерфейс DataGateway предоставляет метод getMultiplierByInstrumentId, который возвращает мультипликатор инструмента.

Для расчета прибыли акций достаточно:
1. Умножить цену открытия на мультипликатор - конечная цена инструмента.
2. Из конечной цены отнять цену открытия и умножить на кол-во инструмента  в позиции.

Для расчета прибыли облигаций достаточно:
1. Умножить цену открытия на мультипликатор - конечная цена инструмента,
2. Конечную цену умножить на размер купона, отнять конечную цену и умножить на кол-во инструмента - прибыль по купону,
3. Из конечной цены отнять цену номинала и умножить на кол-во инструмента в позиции - прибыль по номиналу,
4. Сложить прибыль по купону и прибыль по номиналу.
