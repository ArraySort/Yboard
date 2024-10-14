package arraysort.project.yboard.member.repository;

import arraysort.project.yboard.common.enums.Flag;
import arraysort.project.yboard.member.entity.Member;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class MemberRepositoryTest {

	@Autowired
	EntityManager em;

	@Autowired
	MemberRepository memberRepository;

	@Test
	void 회원가입_회원저장() {
		Member member = Member.builder()
				.id("test")
				.memberPassword("1234")
				.memberName("testName")
				.zipcode("1234")
				.address("address")
				.addressDetail("1234")
				.build();

		memberRepository.save(member);

		em.flush();
		em.clear();

		Member foundMember = memberRepository.findById("test").orElse(null);

		// 사용자 입력 값
		assertThat(foundMember.getId()).isEqualTo("test");
		assertThat(foundMember.getMemberPassword()).isEqualTo("1234");
		assertThat(foundMember.getMemberName()).isEqualTo("testName");
		assertThat(foundMember.getZipcode()).isEqualTo("1234");
		assertThat(foundMember.getAddress()).isEqualTo("address");
		assertThat(foundMember.getAddressDetail()).isEqualTo("1234");

		// DB 초기화 값
		assertThat(foundMember.getAccessLevel()).isEqualTo(1);
		assertThat(foundMember.getDeleteFlag()).isEqualTo(Flag.N);
		assertThat(foundMember.getActivateFlag()).isEqualTo(Flag.Y);

		log.info("CreatedAt : {}", foundMember.getCreatedAt());
		log.info("UpdatedAt : {}", foundMember.getUpdatedAt());
	}
}