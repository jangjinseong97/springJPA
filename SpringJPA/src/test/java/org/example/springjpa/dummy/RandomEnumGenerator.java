package org.example.springjpa.dummy;


public class RandomEnumGenerator <T extends Enum<T>> {
    private final T[] values;

    public RandomEnumGenerator(Class<T> e) {
        this.values = e.getEnumConstants();
        // e가 가진 enum의 내용을 배열로 리턴(아래에 쓰기 위해)
    }

    public T getRandomEnum() {
        return values[(int)(Math.random()*values.length)];
        // 리턴바은 배열의 크기를 최대로 하는 랜덤값을 뽑음
    }
}
