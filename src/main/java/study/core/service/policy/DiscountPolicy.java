package study.core.service.policy;

import study.core.model.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
