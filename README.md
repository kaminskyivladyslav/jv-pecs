# jv-pecs

1. У тебе є абстрактний клас `Machine` і три підкласи: `Bulldozer`, `Excavator`, та `Truck`. Можеш додати будь-які специфічні поля до цих класів.

2. Кожна машина має можливість почати працювати.

3. Створено інтерфейс `MachineProducer`.
Мета реалізації цього інтерфейсу - створити список конкретних машин (`Bulldozer`, `Excavator`, та `Truck`). 
Ти маєш мати принаймні 3 реалізації: `BulldozerProducer`, `ExcavatorProducer`, `TruckProducer`;
Будь ласка, параметризуй свій `MachineProducer` і заміни `Object` в `get()` на підходящий варіант.
```java
public interface MachineProducer<ПАРАМЕТРИЗУЙ МЕНЕ>{ ... }
```

4. В реалізаціях `MachineProducer` твій метод `get()` має повертати список конкретних машин. 
Наприклад: 
```java
List<Bulldozer> get();
```
    або 
```java
List<Truck> get();
```
    або 
```java
List<Excavator> get();
```

5. Також створено інтерфейс `MachineService`. Тобі потрібно його також параметризувати і 
замінити `Object` в сигнатурі методу на правильний варіант (використовуй PECS):

    - метод `getAll(Class type)` створює список машин на основі вхідного параметра.
    - метод `fill(List<Object> machines, Object value)` заповнює список машин переданим значенням.
    - метод `startWorking()` має приймати список, що містить будь-яку Machine.

Коли параметризуєш інтерфейс `MachineService`, пам'ятай, що ми хочемо обмежити типи, які можна з ним використовувати.

Не дозволяти:  
~~`MachineServiceImpl implements MachineService<Dog>`~~  
Дозволяти:  
`MachineServiceImpl implements MachineService<Truck>`  

6. Використай створений клас `MachineServiceImpl`, що реалізує MachineService, і реалізуй ці методи:
- `getAll(Class type)` - на основі вхідного типу класу обери правильну реалізацію MachineProducer і викликай її метод `get()`.

Наприклад: `if (type == Bulldozer.class)` - ми маємо викликати метод `get()` з правильної реалізації MachineProducer (тієї, що поверне `List<Bulldozer>`) і повернути ці машини.

- `fill(List<Object> machines, Object value)` - оновити всі елементи в списку `machines` на передане значення (**яке може бути будь-яким підтипом Machine**).

- `startWorking()` - викликати `doWork` на кожній Machine в списку.

#### [Намагайся уникати цих поширених помилок під час виконання завдання](./checklist.md)