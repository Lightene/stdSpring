package study.core.service.policy;

import study.core.model.member.Grade;
import study.core.model.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmout = 1000;


    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmout;
        }else{
            return 0;
        }
    }
}
