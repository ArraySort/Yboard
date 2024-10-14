package arraysort.project.yboard.member.dto;

import arraysort.project.yboard.member.entity.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Builder
public class MemberSignupReqDTO {

	@NotBlank(message = "아이디는 필수로 입력되어야 합니다.")
	@Size(min = 4, max = 20, message = "아이디는 최소 4글자 최대 20글자여야 합니다.")
	private String memberId;

	@NotBlank(message = "비밀번호는 필수로 입력되어야 합니다.")
	@Size(min = 4, max = 20, message = "비밀번호는 최소 4글자 최대 20글자여야 합니다.")
	private String memberPassword;

	@NotBlank(message = "비밀번호 확인은 필수로 입력되어야 합니다.")
	private String memberPasswordCheck;

	@NotBlank(message = "이름은 필수로 입력되어야 합니다.")
	@Size(min = 2, max = 10, message = "이름은 최소 2글자 최대 10글자여야 합니다")
	private String memberName;

	@NotBlank(message = "우편번호는 필수로 입력되어야 합니다.")
	private String zipcode;

	@NotBlank(message = "주소는 필수로 입력되어야 합니다.")
	private String address;

	private String addressDetail;

	// DTO -> Entity 변환
	public static Member toEntity(MemberSignupReqDTO dto) {
		return Member.builder()
				.id(dto.getMemberId())
				.memberPassword(dto.getMemberPassword())
				.memberName(dto.getMemberName())
				.zipcode(dto.getZipcode())
				.address(dto.getAddress())
				.addressDetail(dto.getAddressDetail())
				.provider(null)
				.build();
	}

	// 회원 가입 : 비밀번호 암호화
	public void encodePassword(PasswordEncoder passwordEncoder) {
		this.memberPassword = passwordEncoder.encode(memberPassword);
	}
}
