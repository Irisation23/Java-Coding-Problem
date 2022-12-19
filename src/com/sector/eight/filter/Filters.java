package com.sector.eight.filter;

import java.util.ArrayList;
import java.util.List;

public class Filters {
    /**
     * (첫째날) 품종에 따라 멜론을 필터링 하는 기능의 추가 요청이 왔다.
     * Filters 클래스를 만들어 멜론 리스트와 필터링할 품목을 인수로 받는 static 메서드를 구현한다.
     */
    public static List<Melon> filterByType(List<Melon> melons, String type) {
        List<Melon> result= new ArrayList<>();

        for (Melon melon : melons) {
            if (melon != null && type.equalsIgnoreCase(melon.getType())) { //equalsIgnoreCase 는 대소문자 구분없이 비교한다.
                result.add(melon);
            }
        }

        return result;
        //List<Melon> bailans = Filters.filterByType(melons, "Bailan"); 의 코드 작성으로 이제 필터링을 할 수 있다.
    }

    /**
     * (둘째 날) 무게로 멜론 필터링을 요청했다.
     * 첫째 날과 같은 로직으로 구현된 코드를 추가했다.
     * 하지만 이렇게 필터링에 대해 추가적이 요구사항이 증가한다면 이는 보일러 플레이트 코드에 가까워 진다는것을 인지했다.
     */
    public static List<Melon> filterByWeight(List<Melon> melons, int weight) {
        List<Melon> result = new ArrayList<>();

        for (Melon melon : melons) {
            if (melon != null && melon.getWeight() == weight) {
                result.add(melon);
            }
        }

        return result;
    }

    /**
     * (셋째 날) 이젠 타입과 무게를 토대로 필터링이 추가되었다.
     * 앞으로 새 필터링 기준이 추가된다면 유지 보수가 어려워지고 코드 오류 발생 확률이 증가하게 된다.
     */
    public static List<Melon> filterByTypeAndWeight(List<Melon> melons, String type, int weight) {
        List<Melon> result = new ArrayList<>();

        for (Melon melon : melons) {
            if (melon != null && type.equalsIgnoreCase(melon.getType()) && melon.getWeight() == weight) {
                result.add(melon);
            }
        }

        return result;
    }

    public static List<Melon> filterMelons(List<Melon> melons, MelonPredicate predicate) {
        List<Melon> result = new ArrayList<>();

        for (Melon melon : melons) {
            if (melon != null && predicate.test(melon)) {
                result.add(melon);
            }
        }

        return result;

        /*
        List<Melon> gacs = Filters.filterMelons(
         */
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T t : list) {
            if (t != null && predicate.test(t)) {
                result.add(t);
            }
        }

        return result;
    }
}
