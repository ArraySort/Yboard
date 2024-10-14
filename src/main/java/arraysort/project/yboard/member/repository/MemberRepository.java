package arraysort.project.yboard.member.repository;

import arraysort.project.yboard.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

}
