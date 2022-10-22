package study.core.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import study.core.config.AppConfig;
import study.core.model.member.Member;
import study.core.repository.member.MemberRepository;
import study.core.repository.member.MemoryMemberRepository;

@Component
public class MemberServiceImpl implements MemberService{

    AppConfig appConfig = new AppConfig();
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
