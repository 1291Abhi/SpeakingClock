package com.example.SpeakingClock;

import com.example.SpeakingClock.Service.SpeakingClockService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpeakingClockApplicationTests {

	@org.junit.jupiter.api.Test
	public void convertTimeToString() {
		SpeakingClockService services=new SpeakingClockService();
		assertEquals("It's eight thirty four",services.convertTimeToString("08:34"));
		assertEquals( "It's Midday",services.convertTimeToString("12:00"));
		assertEquals( "It's Midnight",services.convertTimeToString("00:00"));

	}

}
