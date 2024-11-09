# Event Booking Application

## Опис на проектот

Креирајте нов Spring Boot проект со група mk.ecode и artefactId=events

Дефинирајте пакет mk.ecode.events.model и во него креирајте ја EventBooking класата. Таа треба да содржи:
- String eventName
- String attendeeName
- String attendeeAddress
- Long numberOfTickets

Во mk.ecode.events.model креирајте Event класа која ќе содржи:
- String name
- String description
- double popularityScore

Креирајте класа EventRepository во пакетот mk.ecode.events.repository, во која ќе чувате List<Event> иницијализирана со 10 вредности.
Имплементирајте метод public List<Event> findAll(); кој само ќе ја врати листата.
Имплементирајте метод public List<Event> searchEvents(String text); кој ќе направи пребарување низ листата на настани и ќе ги врати оние во чие име или опис се содржи текстот text кој се праќа како аргумент на методот.

Дефинирајте ги следните интерфејси во mk.ecode.events.service кои ќе ги претставуваат бизнис функционалностите на апликацијата:

```java
public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text);
}

public interface EventBookingService {
    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets);
}
```

Имплементирајте ги сервисите (EventService треба да зависи од EventRepository).

Креирајте сервлет EventListServlet во пакетот mk.ecode.events.web и мапирајте го на патеката /. Овој сервлет треба да зависи од EventService и да ги прикаже сите добиени настани од методот listAll().

Овозможете корисникот да избере еден од настаните и за истиот да наведе број на карти што сака да ги нарача. Креирајте по едно радио копче за секој настан каде што вредноста на копчето ќе биде името на настанот, а текстот кој ќе се прикаже ќе биде во форматот:
Name: <event_name>, Description: <event_description>, Rating: <popularity_score>

Прилагодете го фајлот listEvents.html за изгледот на оваа страница.

```html
<html>
    <head>
        <meta charset="utf-8">
        <title>Event Booking page - Welcome and choose an Event</title>
        <style type="text/css">
            body {
                width: 800px;
                margin: auto;
            }
        </style>
    </head>
    <body>
        <header>
            <h1>Welcome to our Event Booking App</h1>
        </header>
        <main>
            <h2>Choose an event:</h2>
            <!-- Display radio buttons for each event,
                    the value should be the event name 
                    and the displayed text should be Name: <event_name>, Description: <event_description>, Rating: <popularity_score> -->
            
            <h2>Choose number of tickets:</h2>
            <input type="number" name="numTickets" min="1" max="10"><br/>
            <br/>
            <input type="submit" value="Submit">
        </main>
    </body>
</html>
```
При избор на настан, треба да ја прикажете резервацијата на корисникот. За оваа цел креирајте сервлет EventBookingServlet мапиран на /eventBooking.

Овој сервлет треба да ја прикажете страната за потврда на резервацијата. Во фолдерот src/main/resources/templates додадете фајл bookingConfirmation.html.

Прилагодете го фајлот bookingConfirmation.html за изгледот на оваа страница.

```html
<html>
    <head>
        <meta charset="utf-8">
        <title>Booking - Confirmation</title>
        <style type="text/css">
            body {
                width: 800px;
                margin: auto;
            }
            table {
                width: 100%;
            }
            table, td, th {
                border: 1px solid black;
                padding: 3px 2px;
            }
        </style>
    </head>
    <body>
        <section>
            <header>
                <h1>Event Booking page - Booking confirmation </h1>
            </header>
            <table>
                <tr>
                    <th colspan="2">
                        Your Booking Status
                    </th>
                </tr>
                <tr>
                    <td><b>Attendee Name </b></td>
                    <td>Petko Petkov</td>
                </tr>
                <tr>
                    <td><b>Client IP Address</b></td>
                    <td>127.0.0.1</td>
                </tr>
                <tr>
                    <td><b>Booking for Event</b></td>
                    <td>Oppenheimer</td>
                </tr>
                <tr>
                    <td><b>Number of tickets</b></td>
                    <td>2</td>
                </tr>
            </table>
        </section>
    </body>
</html>
```

Да се имплементира можност за пребарување на настаните на почетната страна listEvents.html. Треба да се прикажат само настаните кои ги исполнуваат условите од пребарувањето. Пребарувањето треба да се изврши според два параметри:

настани кои го содржат текстот испратен од страна на корисникот во нивното име
настани кои имаат рејтинг поголем или еднаков на внесената вредност од страна на корисникот

# Продолжение

# Опис на задачата

Во оваа вежба ќе продолжиме со работа во рамки на проектот.

1. Во класата `Event` додадете ново својство `private Long id`, кое е уникатно за секој настан. Идентификаторот (`id`) треба автоматски да се генерира за секој настан.

2. Додадете класа `Location` во пакетот `mk.ecode.events.model`. Во оваа класа ќе се чуваат следниве атрибути:
    - `private Long id`
    - `private String name`
    - `private String address`
    - `private String capacity`
    - `private String description`

3. Во класата `Event` додадете врска до класата `Location` како посебно својство:
    - `private Location location`

4. Креирајте класа `LocationRepository` во пакетот `mk.ecode.events.repository` и иницијализирајте листа со 5 локации. Во оваа класа, дефинирајте метод `public List<Location> findAll()`, кој ги враќа сите локации во системот. За секој настан иницијализирајте соодветна локација во атрибутот `location`.

5. Во пакетот `mk.ecode.events.service` креирајте интерфејс `LocationService` и класа `LocationServiceImpl` (во потпакетот `impl`), која го имплементира интерфејсот. Во сервисот дефинирајте метод `public List<Location> findAll()`, кој го повикува методот од `LocationRepository`.

6. Дефинирајте пакет `mk.ecode.events.web.controller` и во него креирајте ја класата `EventController`:
    - Имплементирајте метод `public String getEventsPage(@RequestParam(required = false) String error, Model model)`, 
    - кој го прикажува погледот за сите настани. Нека одговара на mapping `/events`. Погледот за сите настани треба да биде `listEvents.html`, 
    - каде ќе се прикаже името на локацијата, функционалност за избор на настан и број на билети за нарачка. 
    - Додадете копчиња за уредување и бришење на настани.

7. Имплементирајте метод `public String saveEvent()`, кој овозможува додавање на нов настан и прима параметри: `name`, `description`, `popularityScore`,
и `id` на локацијата (корисникот го избира од `<select>` таг). Овој метод треба да одговара на mapping `/events/add` 
и по успешно додавање на настанот да редиректира кон погледот со сите настани.

8. Имплементирајте метод `public String editEvent(@PathVariable Long eventId)`, кој овозможува ажурирање на настани, 
примајќи ги параметрите: `name`, `description`, `popularityScore`, и `id` на локацијата (избрана од `<select>` таг). 
Овој метод треба да одговара на mapping `/events/edit/{eventId}`, каде `eventId` е ID-то на настанот што се уредува. 
По успешно ажурирање редиректира кон погледот со сите настани.

9. Имплементирајте метод `public String deleteEvent(@PathVariable Long id)`, кој одговара на mapping `/events/delete/{id}`. 
По успешно бришење на настанот, повторно ја прикажува листата со настани.

10. Имплементирајте метод `public String getEditEventForm(@PathVariable Long id)`, кој одговара на mapping `/events/edit-form/{id}` 
и ја прикажува страната `add-event.html` за уредување. Доколку ID-то на настанот не постои, редиректира кон листата со настани и прикажува порака за грешка.

11. Имплементирајте метод `public String getAddEventPage()`, кој одговара на mapping `/events/add-form` и ја прикажува страната `add-event.html`.

12. Страната `add-event.html` прикажува форма за додавање или уредување на настан, каде локацијата се избира од `<select>` таг.

13. Функционалноста на `EventBookingServlet` за додавање на нова нарачка заменете ја со `EventBookingController`, 
кој овозможува креирање на резервација и прикажување на потврда.

14. Тестирање:
- Проверете дали листата со настани се прикажува успешно.
- Проверете дали е можно да се креира, едитира и избрише настан.
- Проверете дали функционалностите од претходната вежба (резервација) работат.
- Проверете дали се прикажува резервацијата на моменталниот корисник.
