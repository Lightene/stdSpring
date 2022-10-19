package study.core;

import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.core.config.AppConfig;
import study.core.model.member.Grade;
import study.core.model.member.Member;
import study.core.model.order.Order;
import study.core.service.member.MemberService;
import study.core.service.member.MemberServiceImpl;
import study.core.service.order.OrderService;
import study.core.service.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "A", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "iA", 10000);

        System.out.println("Order = " + order);
    }
}
