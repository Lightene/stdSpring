package study.core.service.policy;

import org.springframework.stereotype.Component;
import study.core.model.member.Grade;
import study.core.model.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else{
            return 0;
        }
    }
}
