



import static org.junit.Assert.*;

public class RomanToDecimalTest {
    /**
     * This will test the outcomes of illogical, valid, and invalid statements
     * and whether they actually  true,
     */
    @org.junit.Test
    /**
     * This is where I put in statements and what I believe their outcomes would be
     */
    public void romanToDecimal() {
        assertEquals(RomanToDecimal.romanToDecimal("I"), 1);
        assertEquals(RomanToDecimal.romanToDecimal("IV"), 4);
        assertEquals(RomanToDecimal.romanToDecimal("IX"), 9);
        assertEquals(RomanToDecimal.romanToDecimal("XV"), 15);
        assertEquals(RomanToDecimal.romanToDecimal("XX"), 20);
        assertEquals(RomanToDecimal.romanToDecimal("XL"), 40);
        assertEquals(RomanToDecimal.romanToDecimal("LV"), 55);
        assertEquals(RomanToDecimal.romanToDecimal("XC"), 90);
        assertEquals(RomanToDecimal.romanToDecimal("CL"), 150);
        assertEquals(RomanToDecimal.romanToDecimal("MCMLIV"), 2154);
        assertEquals(RomanToDecimal.romanToDecimal("IVIVXXI"), 31);
        assertEquals(RomanToDecimal.romanToDecimal("IVVCMDL"), 1659);
        assertEquals(RomanToDecimal.romanToDecimal("IIIMMMIII"), 3006);
        assertEquals(RomanToDecimal.romanToDecimal("LCVIV"),159 );
        assertEquals(RomanToDecimal.romanToDecimal("HELLO"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("JKHSFJKH"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("LION"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("YOURMOM"), -1);
        assertNotEquals(RomanToDecimal.romanToDecimal("IVIVIV"), 12);
        assertNotEquals(RomanToDecimal.romanToDecimal("JIBERIB"), 2);

    }
}