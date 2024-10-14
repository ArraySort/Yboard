package arraysort.project.yboard.member.entity;

import arraysort.project.yboard.common.enums.Flag;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

	@Id
	@Column(name = "member_id", nullable = false, length = 200)
	private String id;

	@Column(name = "member_password")
	private String memberPassword;

	@Column(name = "member_name", nullable = false, length = 50)
	private String memberName;

	@Column(name = "zipcode", nullable = false)
	private String zipcode;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "address_detail")
	private String addressDetail;

	@Column(name = "provider", length = 10)
	private String provider;

	@Column(name = "access_level", nullable = false, insertable = false)
	@ColumnDefault("1")
	private Integer accessLevel;

	@CreatedDate
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	@Enumerated(EnumType.STRING)
	@Column(name = "activate_flag", nullable = false, insertable = false)
	@ColumnDefault("'Y'")
	private Flag activateFlag;

	@Enumerated(EnumType.STRING)
	@Column(name = "delete_flag", nullable = false, insertable = false)
	@ColumnDefault("'N'")
	private Flag deleteFlag;

	@Builder
	public Member(String id, String memberPassword, String memberName, String zipcode, String address, String addressDetail, String provider) {
		this.id = id;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.zipcode = zipcode;
		this.address = address;
		this.addressDetail = addressDetail;
		this.provider = provider;
	}
}
