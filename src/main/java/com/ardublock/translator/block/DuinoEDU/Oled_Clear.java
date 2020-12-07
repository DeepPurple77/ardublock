package com.ardublock.translator.block.Duinoedu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Oled_Clear  extends TranslatorBlock {

	public Oled_Clear (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			translator.addHeaderFile("Wire.h");
			translator.addHeaderFile("U8x8lib.h");
			translator.addDefinitionCommand("U8X8_SSD1306_128X64_ALT0_HW_I2C u8x8(/* reset=*/ U8X8_PIN_NONE);");
			translator.addSetupCommand("u8x8.begin();\nu8x8.setPowerSave(0);\nu8x8.setFlipMode(1);\nu8x8.setFont(u8x8_font_chroma48medium8_r);\n");
			
		
			String ret = "u8x8.clearDisplay();\n";

			return ret ;	
		}
}
