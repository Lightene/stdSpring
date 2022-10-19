package study.core.repository.member;

import study.core.model.member.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
