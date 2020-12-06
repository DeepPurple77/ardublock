package com.ardublock.translator.block.Duinoedu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class threeAxisZ extends TranslatorBlock {
	public threeAxisZ(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		
		translator.addHeaderFile("LIS3DHTR.h");
		
		translator.addDefinitionCommand("#ifdef SOFTWAREWIRE\n #include <SoftwareWire.h>\n SoftwareWire myWire(3, 2);\n LIS3DHTR<SoftwareWire> LIS;\n #define WIRE myWire\n#else\n #include <Wire.h>\n LIS3DHTR<TwoWire> LIS;\n #define WIRE Wire\n#endif\n");

		translator.addSetupCommand("while (!Serial) {};\n LIS.begin(WIRE, LIS3DHTR_ADDRESS_UPDATED);\ndelay(100);\nLIS.setOutputDataRate(LIS3DHTR_DATARATE_50HZ);\n");

		String ret = "LIS.getAccelerationZ()";

		return codePrefix + ret + codeSuffix;
	}
	
	
	
	
	
	
	
	
	
}
