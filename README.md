# EPAM_test_automation_stage2

Это репозиторий с выполненными задачами уровня 2.

## 1. Java Error & Exceptions
В университете есть несколько факультетов, в которых учатся студенты, объединенные в группы. У каждого студента есть несколько учебных предметов по которым он получает оценки. Необходимо реализовать иерархию студентов, групп и факультетов.

* Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
* Посчитать средний балл по всем предметам студента
* Посчитать средний балл по предмету для всего университета

Реализовать следующие исключения:
* Оценка ниже 0 или выше 10
* Отсутствие предметов у студента (должен быть хотя бы один)
* Отсутствие групп на факультете
* Отсутствие факультетов в университете
* Отсутствие студентов в группе

## 2. Java I\O Fundamentals
Реализовать программу, которая будет получать в качестве аргумента командной строки путь к директории, например "D:/movies". Записать в текстовый файл структуру папок и файлов в виде, похожем на выполнение программы tree /F. Пример:
```
Amon Amarth
    |-----2004 - Fate Of Norns
    |       01 - An Ancient Sign Of Coming Storm.mp3
    |       02 - Where Death Seems To Dwell.mp3
    |       03 - The Fate Of Norns.mp3
    |       04 - The Pursuit Of Vikings.mp3
    |       05 - Valkyries Ride.mp3
    |       06 - The Beheading Of A King.mp3
    |       07 - Arson.mp3
    |       08 - Once Sealed In Blood.mp3
    |
    |-----2016 - Jomsviking
    |       01 First Kill.mp3
    |       02 Wanderer.mp3
    |       03 On A Sea Of Blood.mp3
    |       04 One Against All.mp3
    |       05 Raise Your Horns.mp3
    |       06 The Way Of Vikings.mp3
    |       07 At Dawn’s First Light.mp3
    |       08 One Thousand Burning Arrows.mp3
    |       09 Vengeance Is My Name.mp3
    |       10 A Dream That Cannot Be (feat. Doro Pesch).mp3
    |       11 Back On Northern Shores.mp3
    |       12 Death In Fire 2016.mp3
    |       13 Death In Fire (Live).mp3
    |
    |-----2019 - Berserker
            01 Fafner's Gold.mp3
            02 Crack the Sky.mp3
            03 Mjölner, Hammer of Thor.mp3
            04 Shield Wall.mp3
            05 Valkyria.mp3
            06 Raven's Flight.mp3
            07 Ironside.mp3
            08 The Berserker at Stamford Bridge.mp3
            09 When Once Again We Can Set Our Sails.mp3
            10 Skoll and Hati.mp3
            11 Wings of Eagles.mp3
            12 Into the Dark.mp3
```
Если в качестве параметра в программу передается не путь к директории, а путь к txt файлу по образцу выше - прочитать файл и вывести в консоль следующие данные:

* Количество папок
* Количество файлов
* Среднее количество файлов в папке
* Среднюю длину названия файла

## 3. Java Threads
Критерии успешного выполнения: Выполнен Main Task (1 вариант на выбор)
Достаточно выполнить одно задание.
Разработать консольное многопоточное приложение.
Использовать возможности, предоставляемые пакетом java.util.concurrent.
Все сущности, желающие получить доступ к ресурсу, должны быть потоками.

* Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров. Число контейнеров, находящихся в текущий момент в порту и на корабле, должно быть неотрицательным и превышающим заданную грузоподъемность судна и вместимость порта. В порту работает несколько причалов. У одного причала может стоять один корабль. Корабль может загружаться у причала, разгружаться или выполнять оба действия.
* Автостоянка. Доступно несколько машиномест. На одном месте может находиться только один автомобиль. Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.
* Тоннель. В горах существует два железнодорожных тоннеля, по которым поезда могут двигаться в обоих направлениях. По обоим концам тоннеля собралось много поездов. Обеспечить безопасное прохождение тоннелей в обоих направлениях. Поезд можно перенаправить из одного тоннеля в другой при превышении заданного времени ожидания на проезд.
* Аукцион. На торги выставляется несколько лотов. Участники аукциона делают заявки. Заявку можно корректировать в сторону увеличения несколько раз за торги одного лота. Аукцион определяет победителя и переходит к следующему лоту. Участник, не заплативший за лот в заданный промежуток времени, отстраняется на несколько лотов от торгов.
* Аэропорт. Посадка/высадка пассажиров может осуществляться через конечное число терминалов и наземным способом через конечное число трапов. Самолеты бывают разной вместимости и дальности полета. Организовать функционирование аэропорта, если пунктов назначения 4–6, и зон дальности 2–3.

## 4. WebDriver
### WebDriver create a simple paste at pastebin
При выполнении задания необходимо использовать возможности Selenium WebDriver, юнит-тест фреймворка и концепцию Page Object.

Steps
1. Открыть https://pastebin.com или аналогичный сервис в любом браузере
2. Создать New Paste со следующими деталями:
    * Код: "Hello from WebDriver"
    * Paste Expiration: "10 Minutes"
    * Paste Name / Title: "helloweb"
  
### WebDriver create a complex paste at pastebin and validate data
При выполнении задания необходимо использовать возможности Selenium WebDriver, юнит-тест фреймворка и концепцию Page Object.

Steps
1. Открыть https://pastebin.com или аналогичный сервис в любом браузере
2. Создать New Paste со следующими деталями:
    * Код: 
    ```
    git config --global user.name  "New Sheriff in Town"
    git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
    git push origin master --force
    ```
    * Syntax Highlighting: "Bash"
    * Paste Expiration: "10 Minutes"
    * Paste Name / Title: "how to gain dominance among developers"

3. Сохранить paste и проверить следующее:
    * Заголовок страницы браузера соответствует Paste Name / Title
    * Синтаксис подсвечен для bash
    * Проверить что код соответствует введенному в пункте 2  
    
### WebDriver Google Cloud calculator

При выполнении задания необходимо использовать возможности Selenium WebDriver, юнит-тест фреймворка и концепцию Page Object.

Steps
1. Открыть https://cloud.google.com/
2. Нажав кнопку поиска по порталу вверху страницы, ввести в поле поиска"Google Cloud Platform Pricing Calculator"
3. Запустить поиск, нажав кнопку поиска.
4. В результатах поиска кликнуть "Google Cloud Platform Pricing Calculator" и перейти на страницу калькулятора.
5. Активировать раздел COMPUTE ENGINE вверху страницы
6. Заполнить форму следующими данными:
    * Number of instances: 4
    * What are these instances for?: оставить пустым
    * Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
    * VM Class: Regular
    * Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
    * Выбрать Add GPUs
        * Number of GPUs: 1
        * GPU type: NVIDIA Tesla V100
    * Local SSD: 2x375 Gb
    * Datacenter location: Frankfurt (europe-west3)
    * Commited usage: 1 Year
7. Нажать Add to Estimate
8. Проверить соответствие данных следующих полей: VM Class, Instance type, Region, local SSD, commitment term
9. Проверить что сумма аренды в месяц совпадает с суммой получаемой при ручном прохождении теста. 

### WebDriver Google Cloud calculator with 10minute mail validation

При выполнении задания необходимо использовать возможности Selenium WebDriver, юнит-тест фреймворка и концепцию Page Object.

Steps
1. Открыть https://cloud.google.com/ 
2. Нажав кнопку поиска по порталу вверху страницы, ввести в поле поиска"Google Cloud Platform Pricing Calculator"
3. Запустить поиск, нажав кнопку поиска.
4. В результатах поиска кликнуть "Google Cloud Platform Pricing Calculator" и перейти на страницу калькулятора.
5. Активировать раздел COMPUTE ENGINE вверху страницы
6. Заполнить форму следующими данными:
    * Number of instances: 4
    * What are these instances for?: оставить пустым
    * Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
    * VM Class: Regular
    * Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
    * Выбрать Add GPUs
        * Number of GPUs: 1
        * GPU type: NVIDIA Tesla V100
    * Local SSD: 2x375 Gb
    * Datacenter location: Frankfurt (europe-west3)
    * Commited usage: 1 Year
7. Нажать Add to Estimate
8. Выбрать пункт EMAIL ESTIMATE
9. В новой вкладке открыть https://10minutemail.com или аналогичный сервис для генерации временных email'ов
10. Скопировать почтовый адрес сгенерированный в 10minutemail
11. Вернуться в калькулятор, в поле Email ввести адрес из предыдущего пункта
12. Нажать SEND EMAIL

## 5. Framework

Задача - построить фреймворк для автоматизации Hardcore  задания из курса WebDriver (WebDriver Google Cloud calculator в это документе)

Что должно быть в итоговом фреймворке:

* webdrivermanager для управления коннекторам к браузерам
* Page Object / Page Factory для абстракций страниц
* Модель для бизнес-объектов необходимых сущностей
* properties файлы с тестовыми данным для разных окружений (как минимум 2)
* xml suites для smoke тестов и всех тестов
* При падении теста должен быть сделан скриншот с датой и временем
* Фреймворк должен иметь возможность запуска с Jenkins и параметризацией браузера, тест suite, environment. Результаты тестов должны быть на графике джобы, скриншоты должны быть заархивированны как артефакты

Пример проекта: https://github.com/vitalliuss/github-automation

