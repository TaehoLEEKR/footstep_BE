package com.example.footstep.domain.repository;

import static com.example.footstep.exception.ErrorCode.NOT_FIND_MEMBER_ID;

import com.example.footstep.domain.entity.Member;
import com.example.footstep.exception.GlobalException;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByLoginEmail(String email);

    Optional<Member> findByMemberId(Long memberId);

    default Member getMemberById(Long memberId) {
        return findByMemberId(memberId)
            .orElseThrow(() -> new GlobalException(NOT_FIND_MEMBER_ID));
    }
}
