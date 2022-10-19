package study.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.core.config.AppConfig;
import study.core.model.member.Grade;
import study.core.model.member.Member;
import study.core.model.order.Order;
import study.core.service.member.MemberService;
import study.core.service.member.MemberServiceImpl;
import study.core.service.order.OrderService;
import study.core.service.order.OrderServiceImpl;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void before(){
        AppConfig appConfig = new AppConfig();

        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "A", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "iA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
