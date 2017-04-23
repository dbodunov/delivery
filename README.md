## Customer feature
>Данный функционал призван обеспечить управление (создание, получение, изменение, удаление) сущностью заказчика в базе данных.

*Реализован на уровнях:*
- [**Entity**](#entity)
- [**Dao**](#dao)
- **Service**
- **Controller**
_____

### <a name="entity">Entity</a>
>Реализацией Entity является **Customer.java**. Данный класс описывает сущность заказчика, помечен аннотацией @Entity, имеет приватные поля, являющиеся колонками таблицы customers, доступ к которым организован с помощью гетторв и сеттеров.
##### Класс *Customer.java* содержит следующие поля:
1. ***id** - (доступ private, тип long) характеризует уникальный идентификационный номер заказчика. Является первичным ключом таблицы customers. Не может иметь нулевого значения. Автоинкрементируемо на стороне хибернейта. Имеет кастомизированное имя колонки **"customer_id"** в таблице customers.*
2. ***name** - (доступ private, тип String) содержит наименование заказчика.*
3. ***address** - (доступ private, тип String) содержит адрес заказчика. Не может иметь нулевого значения.*
4. ***phoneNumber** - (доступ private, тип String) содержит номер телефона заказчика. Не может иметь нулевого значения. Имеет кастомизированное имя колонки **"phone_number"** в таблице customers. Содержит только уникальные данные.*
5. ***eMail** - (доступ private, тип String) содержит адрес электронной почты заказчика. Не может иметь нулевого значения. Имеет кастомизированное имя колонки **"e_mail"** в таблице customers. Содержит только уникальные данные.*

##### Класс *Customer.java* имеет методы:
###### *Сеттеры:*
- ***public void setId(Long id)** - сеттер для поля **id**.* 
- ***public void setName(String name)** - сеттер для поля **name**.*
- ***public void setAddress(String address)** - сеттер для поля **address**.*
- ***public void setPhoneNumber(String phoneNumber)** - сеттер для поля **phoneNumber**.*
- ***public void seteMail(String eMail)** - сеттер для поля **eMail**.*
>Сеттеры задают значение соответствующего поля класса равным переданному в них значению аргумента.
###### *Геттеры:*
- ***public long getId()** - геттер для поля **id**.*
- ***public String getName()** - геттер для поля **Name**.*
- ***public String getAddress()** - геттер для поля **Address**.*
- ***public String getPhoneNumber()** - геттер для поля **PhoneNumber**.*
- ***public String geteMail()** - геттер для поля **eMail**.*
>Геттеры возвращают значение соответствующего поля класса.

______

### <a name="dao">DAO</a>
> DAO слой непосредственно взаимодействует с базой данных. 
###### *Включает в себя интерфейсы:*
- ***BasicDao** - дженерик интерфейс, описывающий базовые CRUD-операции.*
- ***CustomerDao** - интерфейс, унаследованный от BasicDao и расширяющий его функционал дополнительными методами взаимодействия сущности заказчика с базой данных*

#### *To be continued...*

## Order feature
## Заказ
Реализованы сущности ***Заказ*** и связанная с ним сущность ***Корзина***

Заказ реализован классом **Order.java** и таблицей **orders** в базе **delivery**

### Структура полей класса Order:

| Назначение      | Тип              | Имя в классе     | Имя в таблице   |
| --------------- | ---------------- | ---------------- | --------------- |
| Ид заказа       | Long	           | id               | id              |
| Дата доставки	  | Date             | deliveryDate	    | delivery_date   |
| Время доставки  | Time             | deliveryTime	    | delivery_time   |
| Ид клиента			| Long             | userId		        | user_id         |
| Адрес доставки  | String           | deliveryAddress  | delivery_address|
| Ид исполнителя  | Long             | executorId	      | executor_id     |
| Комментарий		  | String           | comment		      | comment         |
| Корзина  			  | List<BasketUnit> | basketUnitList   |                 |

Корзина реализована классом **BasketUnit.java** и таблицей **basket** в базе **delivery**

### Структура полей класса BasketUnit:
| Назначение	       | Тип	    | Имя в классе	| Имя в таблице |
| ------------------ | -------- | ------------- | ------------  |
| Ид заказа          |Long	    | Order			    | order_id      |
| Ид единицы корзины |Long      | id		        | id            |
| Ид товара          |Long	    | itemId		    | item_id       |
| Количество	       |quantity  | quantity      |               |

Таблицы связаны двусторонней связью ОдинКоМногим по ключу order_id  

### REST сервис
* /order/add - добавить заказ
```web
http://localhost.com/order/add
```
* /order/get/id/ - получить заказ по ID
```web
http://localhost.com/order/get/id/35
```
* /order/get/uid/ - получить заказ по  ID пользователя
```web
http://localhost.com/order/order/get/uid/100
```
* /order/update - обновить заказ
```web
http://localhost.com/order/update
```
* /order/delete/ - удалить заказ по ID
```web
http://localhost.com/order/delete/35
```
* /order/basket/delete/id/ - удалить единицу корзины по ID
```web
http://localhost.com/order/basket/delete/id/35
```
* /order/basket/get/id/ - получить единицу корзины по ID
```web
http://localhost.com/order/basket/get/id/72
```
