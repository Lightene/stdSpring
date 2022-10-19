package study.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.core.config.AppConfig;
import study.core.model.member.Grade;
import study.core.model.member.Member;
import study.core.service.member.MemberService;
import study.core.service.member.MemberServiceImpl;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void before(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        Member member = new Member(1L, "A", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
