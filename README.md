# Code Review ИКМ
## Проект "Аэропорт" Дрямина Ивана (3 семестр Java & DBMS) 

## Описание Задачи

`Используя требования к стилю написания кода, которые вы определили ранее для самостоятельных работ 4 и 5, выполнить код-ревью итоговой лабораторной работы, которую выполнял ВАШ напарник (напарника назначает преподаватель!).'`

---

## Ошибки которые были найдены мной:
- Пакеты были названы с большой буквы (некоторые), что является нарушением код-стиля;
- Файлы были названы с маленькой буквы (некоторые), что является нарушением код-стиля;
- Не был создан `README`-файл, где нужно было бы написать: **Описание и Развертывание проекта**;
- Не работало создание полётов для календаря. Ошибка: Невозможно десериализовать значение типа `java.time.LocalDate` из строки.

## Что я исправила:
- Переименовала пакеты и файлы в соответствии с код-стилем;
- Написала Javadoc-документацию для каждого файла;
- Добавила Json-паттерн для корректной сериализации даты;
- Отформатировала код;
- Проверила исправность проекта со стороны пользователя (CRUD операции);

---

  ## Вывод:
  `Проект Вани был написан с некоторыми недочетами, но в целом его структура рабочая. Я усовершенствовала код в силу своих возможностей, и теперь проект "Аэропорт «Дрямино»" работает лучше прежнего!`
