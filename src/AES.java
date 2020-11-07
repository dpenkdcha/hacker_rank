
import java.nio.charset.StandardCharsets;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONObject;

/**
 * This class provides the method to encrypt and decrypt the data
 * 
 * @author Mohammad Ashfaq Memon
 */
public class AES {

	private static final String CLASS_NAME = AES.class.getName();
	private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);

	private static final String ALGORITHM_NAME = "AES/CBC/PKCS5Padding";
	private String secret = null;
	private byte[] sBytes = null;

	public AES(String secret) {
		this.secret = secret;
		sBytes = "Salted__".getBytes();
	}

	public static void main(String[] args) {
		System.out.println("Hello");
		AES aes = new AES("tata123456789123");
        String decryptedParameter = aes.decrypt("U2FsdGVkX1/C+9EpW+5o23LfRXAt90zoy15q3wrMxvENQrECZpLGMzUWh0Aqe9Sz9Eb6y6w3MfuG1Kez9c86gGMka0Ft8OmBsNNGsqYSNiHIKPi00yyzL162C6JVlth6");
        decryptedParameter = decryptedParameter.toString();
        decryptedParameter = decryptedParameter.replaceAll("\"", "\'");
        String a = JSONObject.quote(decryptedParameter);
        System.out.println("decryptedParameter = " + decryptedParameter );
        System.out.println("a = " + a );
	}
	
	/**
	 * Encrypt the string data using AES256 encryption algorithm
	 * 
	 * @param messageToEncrypt String message that you want to encrypt
	 * @return Encrypted message, null in case of exception
	 */
	public String encrypt(String messageToEncrypt) {
		String methodName = "encrypt";
		LOGGER.entering(CLASS_NAME, methodName, messageToEncrypt);

		String encryptedText = null;

		MessageDigest md5;
		try {
			byte[] cipherData = messageToEncrypt.getBytes();
			byte[] saltData = Arrays.copyOfRange(cipherData, 8, 16);
			md5 = MessageDigest.getInstance("MD5");
			final byte[][] keyAndIV = GenerateKeyAndIV(32, 16, 1, saltData, secret.getBytes(StandardCharsets.UTF_8), md5);
			SecretKeySpec key = new SecretKeySpec(keyAndIV[0], "AES");
			IvParameterSpec iv = new IvParameterSpec(keyAndIV[1]);

			Cipher aesCBC = Cipher.getInstance(ALGORITHM_NAME);
			aesCBC.init(Cipher.ENCRYPT_MODE, key, iv);
			byte[] encryptedData = aesCBC.doFinal(cipherData);

			byte[] b = new byte[sBytes.length + saltData.length + encryptedData.length];

			// Appending suffix bytes, salt bytes and encrypted bytes in the CryptoJS way
			System.arraycopy(sBytes, 0, b, 0, sBytes.length);
			System.arraycopy(saltData, 0, b, sBytes.length, saltData.length);
			System.arraycopy(encryptedData, 0, b, sBytes.length + saltData.length, encryptedData.length);

			encryptedText = new String(Base64.getEncoder().encode(b));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		LOGGER.exiting(CLASS_NAME, methodName, encryptedText);
		return encryptedText;
	}

	/**
	 * Decrypt the message that has been encrypted using the encrypt method
	 * 
	 * @param encryptedMessage Message that you want to decrypt
	 * @return Decrypted message, null in case of exception
	 * @author Mohammad Ashfaq Memon
	 */
	public String decrypt(String encryptedMessage) {
		String methodName = "decrypt";
		LOGGER.entering(CLASS_NAME, methodName, encryptedMessage);

		String decryptedText = null;

		MessageDigest md5;
		try {
			byte[] cipherData = Base64.getDecoder().decode(encryptedMessage);
			byte[] saltData = Arrays.copyOfRange(cipherData, 8, 16);
			md5 = MessageDigest.getInstance("MD5");
			// Get the key and IV
			final byte[][] keyAndIV = GenerateKeyAndIV(32, 16, 1, saltData, secret.getBytes(StandardCharsets.UTF_8), md5);
			SecretKeySpec key = new SecretKeySpec(keyAndIV[0], "AES");
			IvParameterSpec iv = new IvParameterSpec(keyAndIV[1]);

			// Remove the 16 bytes from the start of array as they are appended for security
			// purpose and randomness
			byte[] encrypted = Arrays.copyOfRange(cipherData, 16, cipherData.length);

			// Perform the decryption
			Cipher aesCBC = Cipher.getInstance(ALGORITHM_NAME);
			aesCBC.init(Cipher.DECRYPT_MODE, key, iv);
			byte[] decryptedData = aesCBC.doFinal(encrypted);
			decryptedText = new String(decryptedData, StandardCharsets.UTF_8);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		LOGGER.exiting(CLASS_NAME, methodName, decryptedText);
		return decryptedText;
	}

	/**
	 * Generates a key and an initialization vector (IV) with the given salt and
	 * password.
	 * <p>
	 * This method is equivalent to OpenSSL's EVP_BytesToKey function (see
	 * https://github.com/openssl/openssl/blob/master/crypto/evp/evp_key.c). By
	 * default, OpenSSL uses a single iteration, MD5 as the algorithm and UTF-8
	 * encoded password data.
	 * </p>
	 * 
	 * @param keyLength  the length of the generated key (in bytes)
	 * @param ivLength   the length of the generated IV (in bytes)
	 * @param iterations the number of digestion rounds
	 * @param salt       the salt data (8 bytes of data or <code>null</code>)
	 * @param password   the password data (optional)
	 * @param md         the message digest algorithm to use
	 * @return an two-element array with the generated key and IV
	 */
	public static byte[][] GenerateKeyAndIV(int keyLength, int ivLength, int iterations, byte[] salt, byte[] password, MessageDigest md) {

		int digestLength = md.getDigestLength();
		int requiredLength = (keyLength + ivLength + digestLength - 1) / digestLength * digestLength;
		byte[] generatedData = new byte[requiredLength];
		int generatedLength = 0;

		try {
			md.reset();

			// Repeat process until sufficient data has been generated
			while (generatedLength < keyLength + ivLength) {

				// Digest data (last digest if available, password data, salt if available)
				if (generatedLength > 0)
					md.update(generatedData, generatedLength - digestLength, digestLength);
				md.update(password);
				if (salt != null)
					md.update(salt, 0, 8);
				md.digest(generatedData, generatedLength, digestLength);

				// additional rounds
				for (int i = 1; i < iterations; i++) {
					md.update(generatedData, generatedLength, digestLength);
					md.digest(generatedData, generatedLength, digestLength);
				}

				generatedLength += digestLength;
			}

			// Copy key and IV into separate byte arrays
			byte[][] result = new byte[2][];
			result[0] = Arrays.copyOfRange(generatedData, 0, keyLength);
			if (ivLength > 0)
				result[1] = Arrays.copyOfRange(generatedData, keyLength, keyLength + ivLength);

			return result;

		} catch (DigestException e) {
			throw new RuntimeException(e);

		} finally {
			// Clean out temporary data
			Arrays.fill(generatedData, (byte) 0);
		}
	}

}
