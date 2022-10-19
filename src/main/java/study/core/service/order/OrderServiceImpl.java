package study.core.service.order;

import study.core.model.member.Member;
import study.core.model.order.Order;
import study.core.repository.member.MemberRepository;
import study.core.repository.member.MemoryMemberRepository;
import study.core.service.policy.DiscountPolicy;
import study.core.service.policy.FixDiscountPolicy;
import study.core.service.policy.RateDiscountPolicy;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
