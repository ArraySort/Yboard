package arraysort.jasypt;


import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

@Slf4j
@ContextConfiguration(classes = JasyptTest.class)
class JasyptTest {

	@Test
	void jasyptTest() {
		// 암호화 하려는 텍스트
		String text = "암호화 텍스트";

		// 인코딩 된 텍스트
		String encryptText = getEncrypt(text);
		// 디코딩 된 텍스트
		String decryptText = getDecrypt(encryptText);


		log.info("Encrypt : {}", encryptText);
		log.info("Decrypt : {}", decryptText);

		Assertions.assertThat(text).isEqualTo(decryptText);
	}

	// Encrypt
	private String getEncrypt(String input) {
		StandardPBEStringEncryptor encryptor = getStandardPBEStringEncryptor();
		return encryptor.encrypt(input);
	}

	// Decrypt
	private String getDecrypt(String input) {
		StandardPBEStringEncryptor encryptor = getStandardPBEStringEncryptor();
		return encryptor.decrypt(input);
	}

	// Encryptor
	private StandardPBEStringEncryptor getStandardPBEStringEncryptor() {
		String key = System.getProperty("jasypt.encryptor.password");
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setAlgorithm("PBEWithMD5AndDES");
		encryptor.setPassword(key);
		return encryptor;
	}
}
