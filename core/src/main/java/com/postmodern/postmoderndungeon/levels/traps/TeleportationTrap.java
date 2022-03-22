/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2021 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.postmodern.postmoderndungeon.levels.traps;

import com.postmodern.postmoderndungeon.Assets;
import com.postmodern.postmoderndungeon.Dungeon;
import com.postmodern.postmoderndungeon.actors.Actor;
import com.postmodern.postmoderndungeon.actors.Char;
import com.postmodern.postmoderndungeon.actors.hero.Hero;
import com.postmodern.postmoderndungeon.actors.mobs.Mob;
import com.postmodern.postmoderndungeon.effects.CellEmitter;
import com.postmodern.postmoderndungeon.effects.Speck;
import com.postmodern.postmoderndungeon.items.Heap;
import com.postmodern.postmoderndungeon.items.Item;
import com.postmodern.postmoderndungeon.items.scrolls.ScrollOfTeleportation;
import com.postmodern.postmoderndungeon.messages.Messages;
import com.postmodern.postmoderndungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.PathFinder;

public class TeleportationTrap extends Trap {

	{
		color = TEAL;
		shape = DOTS;
	}

	@Override
	public void activate() {

		for (int i : PathFinder.NEIGHBOURS9){
			Char ch = Actor.findChar(pos + i);
			if (ch != null){
				if (ScrollOfTeleportation.teleportChar(ch)) {
					if (ch instanceof Mob && ((Mob) ch).state == ((Mob) ch).HUNTING) {
						((Mob) ch).state = ((Mob) ch).WANDERING;
					}
				}
			}
			Heap heap = Dungeon.level.heaps.get(pos + i);
			if (heap != null && heap.type == Heap.Type.HEAP){
				int cell = Dungeon.level.randomRespawnCell( null );

				Item item = heap.pickUp();

				if (cell != -1) {
					Dungeon.level.drop( item, cell );
				}
			}
		}

	}
}
