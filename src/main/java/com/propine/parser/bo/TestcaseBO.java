package com.propine.parser.bo;

import com.propine.parser.constants.TestExecutionStatus;
import lombok.*;

@NonNull
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TestcaseBO {

	private String testcaseName;
	private int invocationNumber;
	private TestExecutionStatus executionStatus;
	private String testValue;
	private String expectedResult;
	private String actualResult;
	private String screenShotNamePrefix;
}
