/*
 *  Copyright (C) 2011  Tom Quist
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You can get the GNU General Public License at
 *  http://www.gnu.org/licenses/gpl.html
 */
package de.quist.app.samyGoRemote;

import android.content.SharedPreferences;

public class BSeriesKeyCodeSenderFactory extends KeyCodeSenderFactory {

	@Override
	protected KeyCodeSender create(SharedPreferences prefs) {
		String host = prefs.getString(Remote.PREFS_SERVER_HOST_KEY, "");
		int port = Integer.parseInt(Remote.PREFS_SERVER_PORT_DEFAULT);
		try {
			port = Integer.parseInt(prefs.getString(Remote.PREFS_SERVER_PORT_KEY, Remote.PREFS_SERVER_PORT_DEFAULT));
		} catch (NumberFormatException e) { }

		KeyCodeSender keyCodeSender = new BSeriesSender(host, port);
		return keyCodeSender;
	}

}
