package com.ardublock.translator.block.Duinoedu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Barometer_Temperature  extends TranslatorBlock {

	public Barometer_Temperature (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{		
			translator.addHeaderFile("Wire.h");
			translator.addHeaderFile("Seeed_BMP280.h");
			translator.addDefinitionCommand("BMP280 bmp280;");
			translator.addSetupCommand("if (!bmp280.init()) Serial.println(\"Device not connected or broken!\");");
			
			return codePrefix +"bmp280.getTemperature()" + codeSuffix;	
		}
}
