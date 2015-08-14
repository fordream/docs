package com.dalviksoft.calculator.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.exacmple.mauto.Main1Activity;
import com.exacmple.mauto.MainActivity;
import com.exacmple.mauto.R;
import com.robotium.solo.Solo;
import com.robotium.solo.Solo.Config;
import com.robotium.solo.Solo.Config.ScreenshotFileType;

public class AttendanceTest extends ActivityInstrumentationTestCase2<MainActivity> {
	private Solo solo;

	public AttendanceTest() {
		super(MainActivity.class);
	}

	// @Before
	public void setUp() throws Exception {
		Config config = new Config();
		config.screenshotFileType = ScreenshotFileType.PNG;
		config.screenshotSavePath = "/mnt/sdcard/RobotiumTest/";
		solo = new Solo(getInstrumentation(), config);
		getActivity();

		super.setUp();
	}

	// @After
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

	// @Test
	public void testAttendance() throws Exception {
		EditText login = (EditText) solo.getCurrentActivity().findViewById(com.exacmple.mauto.R.id.editText1);
		solo.enterText(login, "abc123");
		solo.clickOnView(solo.getCurrentActivity().findViewById(R.id.button1));
		
		if (solo.waitForActivity(Main1Activity.class)) {
			assertTrue("test success", true);
		} else {
			assertTrue("test success", false);
		}
	}

	/**
	 * some method
	 */
	// assertCurrentActivity (text,Activity)This method verifies whether the
	// current activity is the activity which is passed as the send parameter.

	// clickOnButton(text) This method will click on the button with the
	// specified Text. solo.clickOnButton("ADMIN");

	// #3. clickOnButton(int) This method will click on the button with the
	// specified index. solo.clickOnButton(2);

	// waitForText(text) This method will wait until the text appearing on the
	// activity. solo.waitForText("Creating New Password");

	// enterText(int, text) This method will type the text passed as the second
	// parameter to the specified index editbox. solo.enterText(0,"test");

	// clickOnCheckbox(int) This Method will click on the checkbox with given
	// index.

	// clickOnRadioButton(int) This Method will click on the Radio button with
	// the given index.

	// clickOnImage(int) This Method will click on the image with the given
	// index. solo.clickOnImage(1);

	// clearEditText(int) This Method will clear the text in the edit box with
	// the given index.

	// waitForText(text) This Method will wait until the given text is appearing
	// on the activity.
}