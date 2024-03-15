package com.example.springinaction;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data // final 속성들을 초기화하는 생성자 및 게터 세터 등을 생성하도록 Lombok에 알려준다. 런타임 시 자동 생성
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
