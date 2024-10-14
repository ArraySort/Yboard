package arraysort.project.yboard.member.service;

import arraysort.project.yboard.member.dto.MemberSignupReqDTO;
import arraysort.project.yboard.member.entity.Member;
import arraysort.project.yboard.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	private final PasswordEncoder passwordEncoder;

	@Transactional
	public void addMember(MemberSignupReqDTO dto) throws Exception {

		if (memberRepository.existsById(dto.getMemberId())) {
			throw new Exception(); // TODO : 예외 변경
		}

		// 비밀번호 암호화
		dto.encodePassword(passwordEncoder);

		Member member = MemberSignupReqDTO.toEntity(dto);

		memberRepository.save(member);
	}
}
