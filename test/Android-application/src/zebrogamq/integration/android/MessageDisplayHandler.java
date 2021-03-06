/**
 ZebroGaMQ: Communication Middleware for Mobile Gaming
 Copyright: Copyright (C) 2009-2012
 Contact: denis.conan@telecom-sudparis.eu, michel.simatic@telecom-sudparis.eu

 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public
 License as published by the Free Software Foundation; either
 version 3 of the License, or any later version.

 This library is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public
 License along with this library; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
 USA

 Developer(s): Denis Conan, Gabriel Adgeg
 */

package zebrogamq.integration.android;

import android.os.Handler;
import android.os.Message;

public class MessageDisplayHandler extends Handler {

	public final static int PRINT_STRING_WHAT = 0;

	private final GameLogicApplication testHandlerActivity;

	private MessageDisplayHandler(GameLogicApplication testHandlerActivity) {
		this.testHandlerActivity = testHandlerActivity;
	}

	public static MessageDisplayHandler getInstance(
			GameLogicApplication testHandlerActivity) {
		return new MessageDisplayHandler(testHandlerActivity);
	}

	@Override
	public void handleMessage(Message msg) {
		switch (msg.what) {
		case PRINT_STRING_WHAT:
			// retrieve an array of bytes from message's data
			String message = new String(msg.getData().getByteArray(null));
			// print value in text view
			testHandlerActivity.printMessage(message);
			break;
		default:
			break;
		}
	}
}
