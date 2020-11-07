import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class IBLDecrypt {

	
	public static void main(String[] args) throws Exception {
		System.out.println("Hello");
		//String encryptedText = "lx4fMnKtUXr78yZDe9mzDfNSBuT1GgX3B3bRkpqbefl4UN6W5PqdImD5gbkwJhPgdF4PVTgkoacmuG2aZSjZOkjWtip0KG2Q3GoWkRjY0YIsjzkftE4+SP5oz7lLtji69G6165XnEx6MxPamTMDUeKjRdzbpnFO+8E3utAWQ6ijm5bXNCGfVhSMCQVQhlDKvMlSUPJzgrA7Va1fTGZQ1U9xhg5uHGgnS+MsPpW0ZRLrwSe3MwySYa4XsPOU7XPjzmKRCWCW0e/5luKHzbzFr3rYdQwtN6qFvw1u0Mem38ZKZH07jyEE06e+aUREWmeg5ez1X5LPtBtHt/tNnQfKPwvFhHVzGQJMe1GJL01fezkiI3fIoXsSOEk9XJqTvPHP2uI06ET5rk1j9ZzuoemcI6V46KDQHQ2lFGdG1WV0YWbIhcnhcYaro0Zp/LbTqVUafzJY3Vdg2ItFtV6okOcfRbHWFxoW/XkE1ONhhDYQScBtUS8dU96u+1tu03IzQ4X7csjAueXJSCH6ztfZyvkfrmCBTCqgjXhHXLezRG6wINHR0UquZjfvU8I67gVziIUdBMueCrJwvewpF7l+XiThy2vs3m5wN6QIsJ5a3F35R+yjWaACM/vIx9o+PIbY/f2cgc976hjk10USFH6fN/taqWIChcCE92umbieR0qCR/gI/9rGQSKmVaOf767Q+b5kIngtcsep5uXt5PnDeGvVEHirW+R07NA37IkBAiFskOBBt9gGX6SM8WHJog7hV9r0DFeBH3fVdaVfkeRZ9J2rc9YrrFc0F1zuddJ7YD/tfm+9WT+v7Pnxr5wThjRKxm3dbCpyWCHME33kQyn2kffEDu79WpRSBsB5CiMKF23R+Z2jg6d5UBxyZ7t8AZBHZ08k79hJyIqSuAoH6gpkhMoaVMkD8h1OYr7f43nm9GH/X0RDJ/5ssvCbhztLjc6D6FAU40PF47AHdaLPBCsi2+QwCOK6zISD5G0x0z4JtJ7YOwLg3J3lcYeKx0DKuRL5R+5pdZ0uwuRm2SZ/32GXUdpyTaap3uaPQc/imbixsKHfgsb9JBozS/l0mTW2YkcUuwgeNv";
		//String encryptedText = "lx4fMnKtUXr78yZDe9mzDfNSBuT1GgX3B3bRkpqbefl4UN6W5PqdImD5gbkwJhPgdF4PVTgkoacmuG2aZSjZOkjWtip0KG2Q3GoWkRjY0YIsjzkftE4+SP5oz7lLtji69G6165XnEx6MxPamTMDUeKjRdzbpnFO+8E3utAWQ6ijm5bXNCGfVhSMCQVQhlDKvMlSUPJzgrA7Va1fTGZQ1U9xhg5uHGgnS+MsPpW0ZRLrwSe3MwySYa4XsPOU7XPjzmKRCWCW0e/5luKHzbzFr3rYdQwtN6qFvw1u0Mem38ZKZH07jyEE06e+aUREWmeg5ez1X5LPtBtHt/tNnQfKPwvFhHVzGQJMe1GJL01fezkiI3fIoXsSOEk9XJqTvPHP2uI06ET5rk1j9ZzuoemcI6V46KDQHQ2lFGdG1WV0YWbIhcnhcYaro0Zp/LbTqVUafzJY3Vdg2ItFtV6okOcfRbHWFxoW/XkE1ONhhDYQScBtUS8dU96u+1tu03IzQ4X7csjAueXJSCH6ztfZyvkfrmCBTCqgjXhHXLezRG6wINHR0UquZjfvU8I67gVziIUdBMueCrJwvewpF7l+XiThy2vs3m5wN6QIsJ5a3F35R+yjWaACM/vIx9o+PIbY/f2cgc976hjk10USFH6fN/taqWIChcCE92umbieR0qCR/gI/9rGQSKmVaOf767Q+b5kIngtcsep5uXt5PnDeGvVEHirW+R07NA37IkBAiFskOBBt9gGX6SM8WHJog7hV9r0DFeBH3fVdaVfkeRZ9J2rc9YrrFc0F1zuddJ7YD/tfm+9WT+v7Pnxr5wThjRKxm3dbCpyWCHME33kQyn2kffEDu79WpRSBsB5CiMKF23R+Z2jg6d5UBxyZ7t8AZBHZ08k79hJyIqSuAoH6gpkhMoaVMkD8h1OYr7f43nm9GH/X0RDJ/5ssvCbhztLjc6D6FAU40PF47AHdaLPBCsi2+QwCOK6zISD5G0x0z4JtJ7YOwLg3J3lcYeKx0DKuRL5R+5pdZ0uwuRm2SZ/32GXUdpyTaap3uaPQc/imbixsKHfgsb9JBozS/l0mTW2YkcUuwgeNv";
		//String encodedEncryptedText = "lx4fMnKtUXr78yZDe9mzDfNSBuT1GgX3B3bRkpqbefmB9w%2BPknalZ4p19x7iSIT7Z1uKAPs2tThoPCYq6ZNpkEjWtip0KG2Q3GoWkRjY0YIqrZ0v0czTdvViQnj7aCciPUYib4IuyovU0UCtiRBcBo429XbCB9I3lNII99CB25y5nnwMz%2FNOyNgbkUBXGG03U8gHqX5AsvbBv7Z9%2Fqq3%2FiPyCUcJgvnmH84vEJ2jktr5fitTy5YI2r%2BY6cLTDl6AugPtsooJhnOCXBgPSYpFfZdkFbhGLNT1bxu2TYt5f7Qf%2BSeiJIVKYL3f36azRaDd6erfMWUac5RLkdbYinU9v0qXv3cTXTJKaBjZF33Wdh0fBqQSuzmcjOlwpwEiDuc4mQuU59c3dPdQjHYtKveJ27KyqrRiIYbeupgn84qPMcT%2Ffp4%2FNWSIZ0ababrjO4vcUH3CcaVFWRFRUQ5ilMNkR%2FRDDq5vHFcrXtRa5Y0jLd25UiE1lrk2kbg4QEFKwL9oQh70HMZzdMopplRBcqW9NGwMrjnlq9K6g7%2B16lOVmJQDTALiVzC%2BtqJ24QUqaIeR%2FXV%2B7d3nbOSoWctmraEvb4TNZbuh1lgRKf25s2ydIUTVRvDrCMcvwQ2ZwGUTsFWbJi2ezTT67BEx7vz4%2BOLlBmzZCQ06p3%2B49MYO0Hictebpspr2xXJotgQDZa9E68UC5B0DFQBHSBYdR%2FQEVe8quufA9u3S0Kxbai8CqW6aTR9%2FkfZ%2FRZAfilaFa%2Frro2jtwe8vkgpO37He7sVGsLh3ay6lY3G%2BCQDjcLmK04HZOyb%2FBr2NFeQz8uKVCSZco3mCNMbDvr907num1G1LbK3J3N7MgyUMA07KserRzBp%2Fn51Qlf90hxHe9vec4LBlYU5KMpVSWjiTBvHx99LRzpKKxmsTsimSX2EzBYKiuK42jukGnU4dBBDGw2jJ35spMddUp746Umap6aG4zvrMGiPFzbZpmBwHQYQfavcP5KFLW4DGARfsjOhUbmTKoKlRbRyH1EA6ICzc%2BZ2K7qqzAEH1TVWg5mqG9SIFwqevIau08wWAnQw6HzNaUB6GhvzpGjctZ4EwJJP08J%2Fiy0sMmvqD3n4CTkV3TjHJYnmvxbcJO%2Bc%3D";
		//String encodedEncryptedText = "U2FsdGVkX183VV44lt37N7me8TE1q2vhYKnmurauaFmPOtg3XLu8Qbe2oO6jZdtQpWhL9N6jeZJWBvNQjFl31rxIzHO8Gu3g4w1WdI/fWgtVMLYQ0PBxHx0Rd95ou0/8";
		String encodedEncryptedText = "U2FsdGVkX18xbWr3keKbH+PaxCgYk8WEkxeSaZfBJ62ndyCAO9Z2TY9ObU3ZRWMYOnG2mNugjE/yrTs5Zfl0nhiBKX94Qmb3DI/o9EBDXZX1w1L1uw3Dh5mICILt1l3B";
		
		
		/*
		 * System.out.println("Sending --> "+URLDecoder.decode(encodedEncryptedText));
		 * 
		 * byte[] keyBytes = "tata123456789123".getBytes(); SecretKey key = new
		 * SecretKeySpec(keyBytes, "AES"); Cipher c = Cipher.getInstance("AES");
		 * c.init(Cipher.DECRYPT_MODE, key, ); byte[] decValue =
		 * c.doFinal(Base64.getDecoder().decode(encodedEncryptedText)); String
		 * decryptedValue = new String(decValue); System.out.println(decryptedValue);
		 */
		
		String secret = "tata123456789123";
		String cipherText = "U2FsdGVkX1+tsmZvCEFa/iGeSA0K7gvgs9KXeZKwbCDNCs2zPo+BXjvKYLrJutMK+hxTwl/hyaQLOaD7LLIRo2I5fyeRMPnroo6k8N9uwKk=";
		byte[] cipherData = Base64.getDecoder().decode(cipherText);
		byte[] saltData = Arrays.copyOfRange(cipherData, 8, 16);
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		final byte[][] keyAndIV = GenerateKeyAndIV(32, 16, 1, saltData, secret.getBytes(StandardCharsets.UTF_8), md5);
		SecretKeySpec key = new SecretKeySpec(keyAndIV[0], "AES");
		IvParameterSpec iv = new IvParameterSpec(keyAndIV[1]);
		byte[] encrypted = Arrays.copyOfRange(cipherData, 16, cipherData.length);
		Cipher aesCBC = Cipher.getInstance("AES/CBC/PKCS5Padding");
		aesCBC.init(Cipher.DECRYPT_MODE, key, iv);
		byte[] decryptedData = aesCBC.doFinal(encrypted);
		String decryptedText = new String(decryptedData, StandardCharsets.UTF_8);
		System.out.println(decryptedText);
	
	}
	
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
	        Arrays.fill(generatedData, (byte)0);
	    }
	}
}
