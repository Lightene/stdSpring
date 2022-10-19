package study.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.core.repository.member.MemberRepository;
import study.core.repository.member.MemoryMemberRepository;
import study.core.service.member.MemberService;
import study.core.service.member.MemberServiceImpl;
import study.core.service.order.OrderService;
import study.core.service.order.OrderServiceImpl;
import study.core.service.policy.DiscountPolicy;
import study.core.service.policy.FixDiscountPolicy;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
