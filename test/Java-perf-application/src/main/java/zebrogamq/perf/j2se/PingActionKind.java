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

package zebrogamq.perf.j2se;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import zebrogamq.gamelogic.ActionInvocationException;
import zebrogamq.gamelogic.GameLogicActionInterface;
import zebrogamq.gamelogic.GameLogicState;
import zebrogamq.gamelogic.Util;

public enum PingActionKind implements GameLogicActionInterface {
	ALL_ACTION("pingAllAction") {
		public Object execute(final GameLogicState state,
				final String[] header, final String body)
				throws ActionInvocationException {
			return MyGameLogicProtocol.pingAllAction(state, header, body);
		}
	},
	PLAYER_ACTION("pingPlayerAction") {
		public Object execute(final GameLogicState state,
				final String[] header, final String body)
				throws ActionInvocationException {
			return MyGameLogicProtocol.pingPlayerAction(state, header, body);
		}
	},
	SERVER_ACTION("pingServerAction") {
		public Object execute(final GameLogicState state,
				final String[] header, final String body)
				throws ActionInvocationException {
			// PING to server can only be received by server.
			return null;
		}
	};

	public final static int KIND_NUMBER = 100;
	public final static int LOWER_ACTION_NUMBER = 0;
	public final static int UPPER_ACTION_NUMBER = 1000;
	public final String nameKind = "pingActionKind";

	// Ignore the code below. Just make sure it is present in all your enums.
	// The copy and paste is due to a limitation of Java enums (no inheritance).

	private final static Map<String, PingActionKind> privateActionMap = new HashMap<String, PingActionKind>();
	public final static Map<String, PingActionKind> actionMap = Collections
			.unmodifiableMap(privateActionMap);

	private final String codeKind;
	private final String codeAction;
	private final String nameAction;

	static {
		for (PingActionKind gra : PingActionKind.values()) {
			privateActionMap.put(gra.toString(), gra);
		}
	}

	private PingActionKind(final String nameAction) {
		this.codeKind = String.valueOf(KIND_NUMBER);
		this.codeAction = String.valueOf(LOWER_ACTION_NUMBER + ordinal());
		this.nameAction = nameAction;
	}

	public String getCodeKind() {
		return codeKind;
	}

	public String getNameKind() {
		return nameKind;
	}

	public String getCodeAction() {
		return codeAction;
	}

	public String getNameAction() {
		return nameAction;
	}

	public String toString() {
		return nameKind
				+ Util.getRabbitMQProperties().getProperty(
						"routingKeySeparator") + nameAction;
	}
}
