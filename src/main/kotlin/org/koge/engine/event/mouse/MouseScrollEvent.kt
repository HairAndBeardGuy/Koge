/**
 * Copyright (C) 2020 Moncef YABI
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package org.koge.engine.event.mouse

import org.koge.engine.event.Event

/**
 * The {@code MouseCursorEnterEvent} class groups the values of a mouse button pressed event.
 *
 * @property xoffset, values: 0 no change, -1 left, 1 right
 * @property xoffset, values: 0 no change, -1 back, 1 front
 *
 * @author Moncef YABI
 */
class MouseScrollEvent (var xoffset: Double, var yoffset: Double): Event()
