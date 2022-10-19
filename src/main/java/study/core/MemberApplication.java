package study.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.core.config.AppConfig;
import study.core.model.member.Grade;
import study.core.model.member.Member;
import study.core.service.member.MemberService;

public class MemberApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "A", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new : " + member.getName());
        System.out.println("find : " + findMember.getName());
    }
}
