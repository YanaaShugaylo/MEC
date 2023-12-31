# MEC

# Работа с гитом в проекте
В этом гайде показано, как правильно создавать ветки, делать коммиты и ставить пул-реквесты

# Git-flow

В основе нашей работы будет лежать подход git-flow. При правильном его использовании можно избежать целый ряд проблем:

- Мерж-конфликты, возникающие когда над проектом параллельно работают несколько разработчиков
- Непонятная история коммитов, из-за чего невозможно отследить когда и какое изменение было сделано
- Невозможность полноценно провести код-ревью, так как все коммитится в master-ветку
- (На будущее) невозможно правильно настроить CI/CD и автотесты

## Основные правила

1. Запрещено делать коммиты в master-ветку
2. На каждую отдельно поставленную задачу необходимо создавать отдельную ветку с соответствующим типу задачи названием (см. ниже).
3. Запрещается мержить ветки напрямую в master. Необходимо ставить пул-реквесты.
4. Запрещается мержить пул-реквесты, не прошедшие код-ревью.

## Как правильно давать названия веткам

В общем виде название вашей ветки будет выглядеть следующим образом:
**<** *Тип работ* **>/<** *Какие работы проводились* **>**

*Тип работ* - одно слово
*Какие работы проводились* - слова разделяются символом "-"

### Возможные типы работ:

- **feature** - любые изменения, которые пользователь может физически увидеть
- **task** - соответственно изменения, которые пользователь не увидит (рефакторинг, тесты, поднятие версии библиотек)
- **release** - релизные ветки с номером версии
- **fix**, **bug**, **fix/bug** - исправление багов

Касательно того, какие работы проводились, строгих правил нет. Единственное что, человек должен понять что вы вообще в этой ветке делали

### Примеры
| Задача | Название ветки |
|--|--|
| Сверстать экран авторизации | feature/auth-screen-layout |
| Подключить экран авторизации | feature/auth-screen-integration |
| Сверстать и подключить главный экран | feature/main-screen |
| Сделать заглушку на главном экране | feature/main-screen-placeholder |
| Подключить пуши | feature/push-messaging-service |
| Написать тесты для раздела "Адреса" | task/addresses-tests |
| Сделать рефакторинг работы с адресами | task/addresses-refactoring |
| Подготовить и собрать сборку версии 1.2.5 | release/1.2.5 |
| Пофиксить баг с неверным часом поясом в таймпикером | fix/timepicker-locale или fix/bug/timepicker-locale |

## Как правильно ставить пул-реквесты

1. Коммиты в свои ветки можете обзывать как угодно.
2. После того, как вы посчитали что задача выполнена, необходимо поставить пул-реквест. Название этого пул-ревеста должно соответствовать названию ветки, но только с заглавной буквы и без тире. Пример: ветка feature/auth-screen-layout -> пул-реквест Feature/Auth screen layout.
3. Убедитесь что "source branch" и "target branch" выбраны правильно.
4. Если задача касалась верстки, необходимо в комментарии к пулу прикрепить скриншот/запись экрана результата работы
5. После того как пул поставлен необходимо как-нибудь оповестить ревьюера о готовности задачи (Тегнуть в мутиме, а лучше еще и сказать лично)
6. После проверки старший разработчик оповестит вас о результатах ревью.
7. После того как пул получил статус "Approved", необходимо нажать на стрелочку внутри зеленой кноки и в выпадающем списке выбрать "Squash and merge".
8. Замержите пул реквест)

## Как правильно именовать изображения, иконки
1. Имя для иконки начинается с префикса ic_название иконки
2. Имя для изображения начинается с префикса img_название изображения
3. Имя которое вы даете, полноценно дает понимание, что же на этом изображении нарисовано
