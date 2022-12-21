# ✨ 함수형 스타일 프로그래밍의 기초와 디자인 패턴

아래의 답변을 할 수 있다면 해당 단원은 무시해도 된다.

- 함수형 인터페이스 작성하기
- 람다 요약
- 실행 어라운드 패턴 구현
- 팩터리 패턴 구현
- 전략 패턴 구현
- 템플릿 메서드 패턴 구현
- 옵저버 패턴 구현
- 론 패턴 구현
- 데코레이터 패턴 구현
- 캐스케이드 빌더 패턴 구현
- 커맨드 패턴 구현   

위의 답변에서 막히는 경우 해당 단원의 정리가 필요함을 인지하고 정리해야한다.   
즉 위의 목차가 단원의 목표이다.

#### 보일러플레이트 코드
- 코드가 변화없이 여러 군데에서 반복되는 코드를 말함

#### 동작 매개변수
- 보일러플레이트 코드를 한 번만 작성하고 동작을 인자로 넣기 위한 방법에는 뭐가 있을까?
- 바로 `동작 매개변수화(Behavior Parameterization)`라 부른다.
- 선택 조건이나 기준을 하나의 동작으로 보면 직관적으로 각 동작의 인터페이스 구현으로 간주할 수 있다.
- 기본적으로 모든 동작에는 선택 조건이나 기준과 boolean 타입 반환 `프레디케이트(predicate)`라는 공통점이 있다. 

## 🖼️ 전략 디자인 패턴(Strategy Design Pattern)
- 같은 목적의 `알고리즘군`을 정의하고 각 알고리즘을 캡슐화 하여 상호 교환이 가능하게 한다.
- 전략 패턴을 사용하면 고객마다 다양하게 독립적으로 알고리즘을 사용할 수 있다.
- 런타임에 동적으로 알고리즘의 동작을 선택하는 것이 핵심 개념이다.

## ＠FunctionalInterface
- 함수형 인터페이스를 표시하는 애너테이션 타입이다.
- 표시된 인터페이스가 함수형이 아니면 오류를 발생시켜준다.

#### Predicate<T>
```java
@FunctionalInterface
public interface Predicate<T> {

    /**
     * Evaluates this predicate on the given argument.
     *
     * @param t the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    boolean test(T t);
}
```
#### Consumer<T>
```java
@FunctionalInterface
public interface Consumer<T> {

    /**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     */
    void accept(T t);
}
```
#### Supplier<T>
```java
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Gets a result.
     *
     * @return a result
     */
    T get();
}
```
- Function<T, R>
```java
@FunctionalInterface
public interface Function<T, R> {

    /**
     * Applies this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     */
    R apply(T t);
}
```
- UnaryOperator<T>
```java
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> {

    /**
     * Returns a unary operator that always returns its input argument.
     *
     * @param <T> the type of the input and output of the operator
     * @return a unary operator that always returns its input argument
     */
    static <T> UnaryOperator<T> identity() {
        return t -> t;
    }
}
```
#### BinaryOperator<T>
```java
@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T,T,T> {

    /**
     * Returns a {@link BinaryOperator} which returns the lesser of two elements
     * according to the specified {@code Comparator}.
     *
     * @param <T> the type of the input arguments of the comparator
     * @param comparator a {@code Comparator} for comparing the two values
     * @return a {@code BinaryOperator} which returns the lesser of its operands,
     *         according to the supplied {@code Comparator}
     * @throws NullPointerException if the argument is null
     */
    public static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator);
        return (a, b) -> comparator.compare(a, b) <= 0 ? a : b;
    }
}
```

- 람다와 람다의 익명 클래스 버전으 비교해보면 메서드에 인수로 전달하거나 변수로 저장할 수 있는 간결한 익명 함수를 람다식이라고 결론지을 수 있다.
- 익명
  - 명시적 이름이 없다.
- 함수
  - 클래스에 속하지 않는다.
- 간결성
  - 짧고, 간단하다.
- 전달성
  - 인수로 전달하거나 저장한다.

## 🖼️ 실행 어라운드 패턴(Execute Around Pattern)
- 특정 작업을 둘러싼 `보일러플레이트` 코드를 제거하는 것이다.
- 실행 어라운드 패턴은 자원을 여닫는 사이에 발생하는 작업을 수행할 때 유용하다.
- 예를 들어 Scanner를 사용해 파일로부터 double 값을 읽는다고 가정해보자.

```java
try(Scanner scanner = new Scanner(Path.of("double.txt"), StandardCharsets.UTF_8)) {
    if (scanner.hasNext()) {
        double value = scanner.nextDouble();
    }
}
```

이어서 모든 double 값을 출력해보자.
```java
try(Scanner scanner = new Scanner(Path.of("double.txt"), StandardCharsets.UTF_8)) {
    while (scanner.hasDouble()) {
        System.out.println(scanner.nextDouble());
    }
}
```

```java
try(Scanner scanner = new Scanner(Path.of("double.txt"), StandardCharsets.UTF_8)){
}
```
- 보일러 코드 발생 🚨
- 해결 과정은 실행 어라운드 패키지의 코드를 참조하기 바람.

## 🖼️ 팩터리 패턴(Factory Pattern)
- 호출자에게 인스턴스 생성 프로세스를 제공하지 않고도 여러 종류의 객체를 생성하게 해주는 패턴이다.
- 복잡하고 민감한 객체 생성 프로세는 감추면서 직관적이고 사용하기 쉬운 객체 팩터리를 호출자에게 제공한다.

## 🖼️ 전략 패턴(Strategy Pattern) 
- 알고리즘군(전략)을 표현한 인터페이스와 그 인터페이스의 몇 가지 구현으로(각 구현이 전략이다) 구성된다.

## 🖼️ 템플릿 메서드 패턴(Template Method)
- 알고리즘의 스켈레톤을 메서드로 작성한 후 알고리짐의 특정 단계들을 클라이언트 하위 클래스로 넘기는 디자인 메서드다.
  - 예를 들어 피자 만들기는 크게 세 단계로 나뉜다. 반죽하고 토핑을 얹어서 피자를 굽는다. 첫 단계와 마지막 단계는
  - 어떤 피자든 똑같지만(고정 단계) 두 번째 단계는 피자 종류마다 다르다(변형 단계)

## 🖼️ 옵저버 패턴(Observer Pattern)
- 객체(`대상(subject)`)를 하나 정의해 특정 이벤트가 발생하면 그 객체의 구독자(`옵저버(observer)`)에게 자동으로 알린다. 