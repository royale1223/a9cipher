//    Copyright 2010 Daniel James Kotowski
//
//    This file is part of A9Cipher.
//
//    A9Cipher is free software: you can redistribute it and/or modify
//    it under the terms of the GNU Lesser General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    A9Cipher is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU Lesser General Public License for more details.
//
//    You should have received a copy of the GNU Lesser General Public License
//    along with A9Cipher.  If not, see <http://www.gnu.org/licenses/>.

package cosc385final;

import static org.junit.Assert.*;

import org.junit.Test;

@Deprecated
public class RijndaelCipherTests {

	private final byte[] PT1 = {(byte) 0x01, (byte) 0x23, (byte) 0x45, (byte) 0x67, (byte) 0x89, (byte) 0xab, (byte) 0xcd, (byte) 0xef, (byte) 0xfe, (byte) 0xdc, (byte) 0xba, (byte) 0x98, (byte) 0x76, (byte) 0x54, (byte) 0x32, (byte) 0x10};
	private final byte[] K1 = {(byte) 0x0f, (byte) 0x15, (byte) 0x71, (byte) 0xc9, (byte) 0x47, (byte) 0xd9, (byte) 0xe8, (byte) 0x59, (byte) 0x0c, (byte) 0xb7, (byte) 0xad, (byte) 0xd6, (byte) 0xaf, (byte) 0x7f, (byte) 0x67, (byte) 0x98};
	private final byte[] CT1 = {(byte) 0xff, (byte) 0x0b, (byte) 0x84, (byte) 0x4a, (byte) 0x08, (byte) 0x53, (byte) 0xbf, (byte) 0x7c, (byte) 0x69, (byte) 0x34, (byte) 0xab, (byte) 0x43, (byte) 0x64, (byte) 0x14, (byte) 0x8f, (byte) 0xb9};
	private final String PT1STRING = "01234567 89abcdef fedcba98 76543210";
	private final String CT1STRING = "ff0b844a 0853bf7c 6934ab43 64148fb9";
	
	@Test
	public void testEncrypt() throws Exception {
		RijndaelCipher rijndaelTester1 = new RijndaelCipher(K1);
		byte[] result = rijndaelTester1.encrypt(PT1);
		String resultString = A9Utility.bytesToHex(result);
		assertEquals("Result", CT1STRING, resultString);
	}

	@Test
	public void testDecrypt() throws Exception {
		RijndaelCipher rijndaelTester1 = new RijndaelCipher(K1);
		byte[] result = rijndaelTester1.decrypt(CT1);
		String resultString = A9Utility.bytesToHex(result);
		assertEquals("Result", PT1STRING, resultString);
	}

}
