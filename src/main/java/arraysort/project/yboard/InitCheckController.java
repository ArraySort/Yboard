package arraysort.project.yboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitCheckController {

	@GetMapping("/")
	public String InitCheck() {
		return "user/signup";
	}
}
