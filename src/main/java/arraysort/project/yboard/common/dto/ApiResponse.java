package arraysort.project.yboard.common.dto;

import arraysort.project.yboard.common.enums.Status;
import lombok.Builder;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Builder
public class ApiResponse<T> {

	private Status status;
	private int statusCode;
	private String message;
	private T data;
	private String errorCode;
	private LocalDateTime timestamp;

	public static <T> ResponseEntity<ApiResponse<T>> success(String message) {
		return ResponseEntity.ok(ApiResponse.<T>builder()
				.status(Status.SUCCESS)
				.statusCode(200)
				.message(message)
				.timestamp(LocalDateTime.now())
				.build()
		);
	}

	public static <T> ResponseEntity<ApiResponse<T>> fail(String message) {
		return ResponseEntity.ok(ApiResponse.<T>builder()
				.status(Status.FAIL)
				.statusCode(400)
				.message(message)
				.timestamp(LocalDateTime.now())
				.build()
		);
	}
}
