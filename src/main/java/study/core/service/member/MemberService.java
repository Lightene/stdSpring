package study.core.service.member;


import study.core.model.member.Member;

public interface MemberService {

    void join (Member member);

    Member findMember(Long memberId);

}
