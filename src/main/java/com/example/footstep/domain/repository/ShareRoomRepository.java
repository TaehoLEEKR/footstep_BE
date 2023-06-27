package com.example.footstep.domain.repository;

import static com.example.footstep.exception.ErrorCode.NOT_FIND_SHARE_ID;

import com.example.footstep.domain.entity.ShareRoom;
import com.example.footstep.exception.GlobalException;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareRoomRepository extends JpaRepository<ShareRoom, Long> {

    List<ShareRoom> findByMember_MemberId(Long memberId, Pageable pageable);

    Optional<ShareRoom> findByShareCode(String shareCode);

    Optional<ShareRoom> findByShareId(Long shareId);

    default ShareRoom getShareById(Long shareId) {
        return findByShareId(shareId)
            .orElseThrow(() -> new GlobalException(NOT_FIND_SHARE_ID));
    }

    boolean existsByShareCode(String shareCode);

    boolean existsByShareIdAndMember_MemberId(Long shareId, Long memberId);
}
